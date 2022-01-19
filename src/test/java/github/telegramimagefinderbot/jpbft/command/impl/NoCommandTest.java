package github.telegramimagefinderbot.jpbft.command.impl;

import github.telegramimagefinderbot.jpbft.command.Command;
import org.junit.jupiter.api.DisplayName;
import static github.telegramimagefinderbot.jpbft.command.CommandName.NO_COMMAND;

@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return NO_COMMAND.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NoCommand.NO_COMMAND;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageTest);
    }
}
