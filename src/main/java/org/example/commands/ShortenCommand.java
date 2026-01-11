package org.example.commands;

import org.example.service.URLShortenerInterface;

public class ShortenCommand extends BaseCommand {

    private final URLShortenerInterface shortenerService;

    public ShortenCommand(URLShortenerInterface shortenerService) {
        this.shortenerService = shortenerService;
    }

    @Override
    public void execute(String[] args) throws CommandException {
        requireArgs(args, 2);
        System.out.println(shortenerService.shorten(args[1]));
    }

    @Override
    public String help() {
        return "shorten <urL> : shortens a URL and gives the shortened code";
    }
}
