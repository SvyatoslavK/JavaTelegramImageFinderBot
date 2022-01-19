package github.telegramimagefinderbot.jpbft.command.impl;

import github.telegramimagefinderbot.jpbft.command.Command;
import org.junit.jupiter.api.DisplayName;

import static github.telegramimagefinderbot.jpbft.command.CommandName.START;
import static github.telegramimagefinderbot.jpbft.command.impl.StartCommand.START_MESSAGE;

@DisplayName("Unit-level testing for Start command")
public class StartCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageTest);
    }
}
