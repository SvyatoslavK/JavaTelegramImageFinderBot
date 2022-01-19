package github.telegramimagefinderbot.jpbft.command.impl;


import github.telegramimagefinderbot.jpbft.command.Command;
import org.junit.jupiter.api.DisplayName;
import static github.telegramimagefinderbot.jpbft.command.CommandName.HELP;

@DisplayName("Unit -level test for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName()
    {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage()
    {
        return HelpCommand.HELP_MESSAGE;
    }

    @Override
    Command getCommand()
    {
        return new HelpCommand(sendBotMessageTest);
    }
}
