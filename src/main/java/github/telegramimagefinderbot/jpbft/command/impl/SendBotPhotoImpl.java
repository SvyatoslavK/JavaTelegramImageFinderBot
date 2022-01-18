package github.telegramimagefinderbot.jpbft.command.impl;

import github.telegramimagefinderbot.jpbft.bot.JavaTelegramBot;
import github.telegramimagefinderbot.jpbft.command.SendBotPhoto;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotPhotoImpl implements SendBotPhoto {

    private final JavaTelegramBot javaTelegramBot;

    @Autowired
    public SendBotPhotoImpl(JavaTelegramBot javaTelegramBot) {
        this.javaTelegramBot = javaTelegramBot;
    }

    @Override
    public void sendPhoto(String chatId, InputFile filepath) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(filepath);

        try {
            javaTelegramBot.execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
