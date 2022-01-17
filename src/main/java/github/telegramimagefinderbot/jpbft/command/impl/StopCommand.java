package github.telegramimagefinderbot.jpbft.command.impl;

import github.telegramimagefinderbot.jpbft.command.Command;
import github.telegramimagefinderbot.jpbft.command.SendBotMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command {
private final SendBotMessage sendBotMessage;
public static final String STOP_MESSAGE = "Bot was stopped!";

public StopCommand(SendBotMessage sendBotMessage)
{
    this.sendBotMessage = sendBotMessage;
}

@Override
    public void execute(Update update)
{
    sendBotMessage.sendMessage(update.getMessage().getChatId().toString(),STOP_MESSAGE);
}

}
