package org.example;

import org.example.commands.*;
import org.example.commands.impl.GetCommand;
import org.example.commands.impl.HelpCommand;
import org.example.commands.impl.ListCommand;
import org.example.commands.impl.ShortenCommand;
import org.example.repository.InMemoryURLRepository;
import org.example.service.URLShortenerService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A URL Shortener that works on the CLI.
 */
public class CLIURLShortener {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        URLShortenerService urlShortener = new URLShortenerService(new InMemoryURLRepository());

        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("shorten", new ShortenCommand(urlShortener));
        commandMap.put("get", new GetCommand(urlShortener));
        commandMap.put("list", new ListCommand(urlShortener));
        commandMap.put("help", new HelpCommand(commandMap));

        CommandExecutor commandExecutor = new CommandExecutor(commandMap);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                String line = scanner.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] input = line.split("\\s+");

                try {
                    System.out.println(commandExecutor.execute(input));
                } catch (CommandException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
