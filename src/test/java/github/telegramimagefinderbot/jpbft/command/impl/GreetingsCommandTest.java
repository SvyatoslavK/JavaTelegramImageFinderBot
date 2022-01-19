package github.telegramimagefinderbot.jpbft.command.impl;

import github.telegramimagefinderbot.jpbft.command.Command;

import static github.telegramimagefinderbot.jpbft.command.CommandName.GREETINGS;
import static github.telegramimagefinderbot.jpbft.command.impl.GreetingsCommand.GREETINGS_MESSAGE;

public class GreetingsCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return GREETINGS.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return GREETINGS_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new GreetingsCommand(sendBotMessageTest);
    }
}
