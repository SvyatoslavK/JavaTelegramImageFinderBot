package github.telegramimagefinderbot.jpbft.command.impl;

import github.telegramimagefinderbot.jpbft.command.Command;
import github.telegramimagefinderbot.jpbft.command.SendBotMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand implements Command {

    private final SendBotMessage sendBotMessage;
    public static final String UNKNOWN_MESSAGE = "** UNKNOWN TYPE OF COMMAND!\n Please read /help to find right command **";

    public UnknownCommand(SendBotMessage sendBotMessage) {
        this.sendBotMessage = sendBotMessage;
    }

    @Override
    public void execute(Update update)
    {
        sendBotMessage.sendMessage(update.getMessage().getChatId().toString(),UNKNOWN_MESSAGE);
    }
}
