package com.raulvalesc.favslistsapi.shared.domain.bus.command;

public interface CommandBus {
    void dispatch(Command command);
}
