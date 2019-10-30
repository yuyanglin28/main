package logic.parser;

import logic.command.Command;

import java.util.regex.Pattern;

public class EditCommandParser {

    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    public static Command parseEditCommand(String argument) {


    }
}
