package org.example.commands.impl;

import org.example.commands.BaseCommand;
import org.example.commands.CommandException;
import org.example.service.URLShortenerInterface;

public class ShortenCommand extends BaseCommand {

    private final URLShortenerInterface shortenerService;

    public ShortenCommand(URLShortenerInterface shortenerService) {
        this.shortenerService = shortenerService;
    }

    @Override
    public String execute(String[] args) throws CommandException {
        requireArgs(args, 2);
        return shortenerService.shorten(args[1]);
    }

    @Override
    public String help() {
        return "shorten <urL> : shortens a URL and gives the shortened code";
    }
}
