package github.telegramimagefinderbot.jpbft.command;

import org.telegram.telegrambots.meta.api.objects.InputFile;

public interface SendBotPhoto {

    void sendPhoto(String chatId, InputFile filepath);
}
