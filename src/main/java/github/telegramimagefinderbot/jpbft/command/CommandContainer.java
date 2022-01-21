package github.telegramimagefinderbot.jpbft.command;

import com.google.common.collect.ImmutableMap;
import github.telegramimagefinderbot.jpbft.command.impl.*;

import java.sql.Driver;

import static github.telegramimagefinderbot.jpbft.command.CommandName.*;

public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownMessage;

    public CommandContainer(SendBotMessage sendBotMessage)
    {
        commandMap = ImmutableMap.<String,Command>builder()
                .put(START.getCommandName(),new StartCommand(sendBotMessage))
                .put(STOP.getCommandName(),new StopCommand(sendBotMessage))
                .put(HELP.getCommandName(),new HelpCommand(sendBotMessage))
                .put(GREETINGS.getCommandName(),new GreetingsCommand(sendBotMessage))
                .put(NO_COMMAND.getCommandName(),new NoCommand((sendBotMessage)))
                .build();

        unknownMessage = new UnknownCommand(sendBotMessage);
    }
    public  Command retrieveCommand(String commandIdentifier)
    {
        return commandMap.getOrDefault(commandIdentifier,unknownMessage);
    }

}

