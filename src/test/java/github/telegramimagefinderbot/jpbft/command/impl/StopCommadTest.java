package github.telegramimagefinderbot.jpbft.command.impl;

import github.telegramimagefinderbot.jpbft.command.Command;

import static github.telegramimagefinderbot.jpbft.command.CommandName.STOP;
import static github.telegramimagefinderbot.jpbft.command.impl.StopCommand.STOP_MESSAGE;

public class StopCommadTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageTest);
    }
}
