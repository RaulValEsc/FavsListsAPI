package com.raulvalesc.favslistsapi.shared.domain.bus.command.exception;

import com.raulvalesc.favslistsapi.shared.domain.exceptions.InternalServerException;

public class CommandNotRegisteredException extends InternalServerException {
    public CommandNotRegisteredException(String commandName) {
        super("Command '" + commandName + "' is not registered.");
    }
}
