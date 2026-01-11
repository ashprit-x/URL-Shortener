package org.example.utils;

import org.example.commands.Command;

import java.util.List;
import java.util.Map;

/**
 *
 */
public final class URLFormatter {

    private URLFormatter() {}

    /**
     * @param entries of all the URLs
     * @return formatted CLI output
     */
    public static String formatUrls(List<Map.Entry<String, String>> entries) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> e : entries) {
            sb.append(e.getKey())
                    .append(" -> ")
                    .append(e.getValue())
                    .append("\n");
        }
        return sb.toString();
    }

    /**
     * @param commands available to the CLI
     * @return formatted CLI output
     */
    public static String formatCommands(Map<String, Command> commands) {
        StringBuilder sb = new StringBuilder();
        commands.forEach((name, cmd) ->
                sb.append(name)
                        .append(" -> ")
                        .append(cmd.help())
                        .append("\n")
        );
        return sb.toString();
    }
}
