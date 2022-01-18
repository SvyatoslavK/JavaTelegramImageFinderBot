package github.telegramimagefinderbot.jpbft.command.impl;

import github.telegramimagefinderbot.jpbft.command.Command;
import github.telegramimagefinderbot.jpbft.command.SendBotMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class NoCommand implements Command {

    private final SendBotMessage sendBotMessage;
    public final static String NO_COMMAND = "Your command should starts from /, type /help for additional info";

    public NoCommand(SendBotMessage sendBotMessage) {
        this.sendBotMessage = sendBotMessage;
    }

    @Override
    public void execute(Update update) {
        sendBotMessage.sendMessage(update.getMessage().getChatId().toString(),NO_COMMAND);
    }

}
