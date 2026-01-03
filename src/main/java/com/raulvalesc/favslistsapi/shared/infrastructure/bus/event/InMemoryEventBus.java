package com.raulvalesc.favslistsapi.shared.infrastructure.bus.event;

import com.raulvalesc.favslistsapi.shared.domain.bus.event.DomainEvent;
import com.raulvalesc.favslistsapi.shared.domain.bus.event.EventBus;
import com.raulvalesc.favslistsapi.shared.domain.bus.event.EventHandler;
import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;
import jakarta.annotation.PreDestroy;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Injectable
public class InMemoryEventBus implements EventBus {
    private final EventHandlersInformation information;
    private final ApplicationContext context;
    private final ExecutorService executor;

    public InMemoryEventBus(EventHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context = context;
        this.executor = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );
    }

    @Override
    public void publish(DomainEvent event) {
        List<Class<? extends EventHandler>> handlerClasses = information.search(event.getClass());

        for (Class<? extends EventHandler> handlerClass : handlerClasses) {
            executor.submit(() -> {
                try {
                    EventHandler<DomainEvent> handler = context.getBean(handlerClass);
                    handler.handle(event);
                } catch (Exception e) {
                    handleError(event, handlerClass, e);
                }
            });
        }
    }

    @Override
    public void publish(List<DomainEvent> events) {
        for (DomainEvent event : events) {
            publish(event);
        }
    }

    private void handleError(DomainEvent event, Class<? extends EventHandler> handlerClass, Exception e) {
        System.err.printf(
                "[EventBus] Error handling event '%s' in handler '%s': %s%n",
                event.getEventName(),
                handlerClass.getSimpleName(),
                e.getMessage()
        );
        e.printStackTrace();
    }

    @PreDestroy
    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
