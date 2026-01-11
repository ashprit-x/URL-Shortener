package org.example.commands.impl;

import org.example.commands.BaseCommand;
import org.example.commands.CommandException;
import org.example.service.URLShortenerInterface;
import org.example.utils.URLFormatter;

/**
 * Lists all the URL to shortened URL code pairs
 */
public class ListCommand extends BaseCommand {

    private final URLShortenerInterface shortenerService;

    public ListCommand(URLShortenerInterface shortenerService) {
        this.shortenerService = shortenerService;
    }

    @Override
    public String execute(String[] args) throws CommandException {
        requireArgs(args, 1);
        return URLFormatter.formatUrls(shortenerService.listUrls());
    }

    @Override
    public String help() {
        return "list : lists all the url to shortened url code pairs";
    }
}
