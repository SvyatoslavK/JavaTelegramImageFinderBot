package github.telegramimagefinderbot.jpbft.command.impl;

import github.telegramimagefinderbot.jpbft.bot.JavaTelegramBot;
import github.telegramimagefinderbot.jpbft.command.SendBotMessage;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageImpl implements SendBotMessage {

    private final JavaTelegramBot javaTelegramBot;

    @Autowired
    public SendBotMessageImpl(JavaTelegramBot javaTelegramBot)
    {
        this.javaTelegramBot = javaTelegramBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);

        try {
            javaTelegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        ;
    }
}
