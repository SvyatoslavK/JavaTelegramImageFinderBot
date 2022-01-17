package github.telegramimagefinderbot.jpbft.bot;

import github.telegramimagefinderbot.jpbft.command.CommandContainer;
import github.telegramimagefinderbot.jpbft.command.SendBotMessage;
import github.telegramimagefinderbot.jpbft.command.impl.SendBotMessageImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.List;

import static github.telegramimagefinderbot.jpbft.command.CommandName.GREETINGS;

/**
 * Telegram bot for uploading pictures from sites to telegram channel
 */

@Component

public class JavaTelegramBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";
    private final static Logger LOGGER = LoggerFactory.getLogger(JavaTelegramBot.class);

    @Value("${bot.username}")
   private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    public JavaTelegramBot()
    {
        this.commandContainer = new CommandContainer(new SendBotMessageImpl(this));
    }


    @Override
  public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText())
        {
            String message = update.getMessage().getText().trim();

            if (message.startsWith(COMMAND_PREFIX))
            {
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            }
            else
            {
                commandContainer.retrieveCommand(GREETINGS.getCommandName()).execute(update);
            }

        }
    }






//    @Override
//    public void onUpdateReceived(Update update) {
//
//        String chat_id = update.getMessage().getChatId().toString();
//
//        if (update.hasMessage() && (update.getMessage().hasText())) {
//
//            String message = update.getMessage().getText().trim();
//
//            SendMessage mess = new SendMessage();
//
//            mess.setChatId(chat_id);
//            mess.setText(message);
//
//            try {
//                execute(mess);
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        } else if (update.hasMessage() && update.getMessage().hasPhoto()) {
//
//            List<PhotoSize> photos = update.getMessage().getPhoto();
//
//            String photo_id = photos.get(0).getFileId();
//            InputFile ph = new InputFile().setMedia(photo_id);
//            SendPhoto sent_photo = new SendPhoto();
//
//            sent_photo.setPhoto(ph);
//            sent_photo.setChatId(chat_id);
//
//            try {
//                execute(sent_photo);
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }
//    @Value("${bot.username}")
//    private String username;
//
//    @Value("${bot.token}")
//    private String token;

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
