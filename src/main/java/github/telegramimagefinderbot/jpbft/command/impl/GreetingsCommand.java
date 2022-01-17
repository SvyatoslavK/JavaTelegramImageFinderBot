package github.telegramimagefinderbot.jpbft.command.impl;

import github.telegramimagefinderbot.jpbft.command.Command;
import github.telegramimagefinderbot.jpbft.command.SendBotMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class GreetingsCommand implements Command {

    private final SendBotMessage sendBotMessage;
    public static final String GREETINGS_MESSAGE = "Welcome to the world of daily posting pictures!";

    public GreetingsCommand(SendBotMessage sendBotMessage)
    {
        this.sendBotMessage = sendBotMessage;
    }

    @Override
    public void execute(Update update) {
    sendBotMessage.sendMessage(update.getMessage().getChatId().toString(),GREETINGS_MESSAGE);
    }

}
