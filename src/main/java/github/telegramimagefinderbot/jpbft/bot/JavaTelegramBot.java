package github.telegramimagefinderbot.jpbft.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

/**
 * Telegram bot for uploading pictures from sites to telegram channel
 */

@Component

public class JavaTelegramBot extends TelegramLongPollingBot {

    private final static Logger LOGGER = LoggerFactory.getLogger(JavaTelegramBot.class);

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && (update.getMessage().hasText()|update.getMessage().hasPhoto()))
        {
            String message = update.getMessage().getText().trim();
            String chat_id = update.getMessage().getChatId().toString();

            SendMessage mess = new SendMessage();

            mess.setChatId(chat_id);
            mess.setText(message);

       /*     File obj = update.getMessage().getDocument();
            SendPhoto messP = SendPhoto.builder().photo(obj) ;*/


            try {
                execute(mess);
            } catch (TelegramApiException e)
            {
              e.printStackTrace();
            }

        }
    }

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
