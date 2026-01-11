package org.example.commands.impl;

import org.example.commands.BaseCommand;
import org.example.commands.CommandException;
import org.example.service.URLShortenerInterface;

import java.util.Optional;

public class GetCommand extends BaseCommand {

    private final URLShortenerInterface shortenerService;

    public GetCommand(URLShortenerInterface shortenerService) {
        this.shortenerService = shortenerService;
    }

    @Override
    public String execute(String[] args) throws CommandException {
        requireArgs(args, 2);

        Optional<String> original = shortenerService.getOriginalUrl(args[1]);

        if (!original.isPresent()) {
            throw new CommandException("Shortened URL could not be found");
        }

        return original.get();
    }

    @Override
    public String help() {
        return "get <code> : gets the original url from the code";
    }
}
