package github.telegramimagefinderbot.jpbft.command;

import github.telegramimagefinderbot.jpbft.command.Command;
import github.telegramimagefinderbot.jpbft.command.CommandContainer;
import github.telegramimagefinderbot.jpbft.command.CommandName;
import github.telegramimagefinderbot.jpbft.command.SendBotMessage;
import github.telegramimagefinderbot.jpbft.command.impl.UnknownCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")
public class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        SendBotMessage sendBotMessage = Mockito.mock(SendBotMessage.class);
        commandContainer = new CommandContainer(sendBotMessage);
    }

    @Test
    public void successCCExist()
    {
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class.getClass(), command.getClass());
                });

    }

    @Test
    public void successCCNotExist()
    {
        //given
        String not_a_command = "/misha";
        //when
        Command command = commandContainer.retrieveCommand(not_a_command);

        //then
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}
