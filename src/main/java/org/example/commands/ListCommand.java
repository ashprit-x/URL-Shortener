package org.example.commands;

import org.example.service.URLShortenerInterface;

import java.util.List;
import java.util.Map;

public class ListCommand extends BaseCommand {

    private final URLShortenerInterface shortenerService;

    public ListCommand(URLShortenerInterface shortenerService) {
        this.shortenerService = shortenerService;
    }

    @Override
    public void execute(String[] args) throws CommandException {
        requireArgs(args, 1);

        List<Map.Entry<String, String>> shortenedUrlList = shortenerService.listUrls();

        if (shortenedUrlList.isEmpty()) {
            System.out.println("No shortened URLs exist");
            return;
        }

        for (Map.Entry<String, String> e : shortenedUrlList) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    @Override
    public String help() {
        return "list : lists all the url to shortened url pairs";
    }
}
