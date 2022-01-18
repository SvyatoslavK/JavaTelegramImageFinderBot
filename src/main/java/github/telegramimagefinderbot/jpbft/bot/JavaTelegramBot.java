package github.telegramimagefinderbot.jpbft.bot;

import github.telegramimagefinderbot.jpbft.command.CommandContainer;
import github.telegramimagefinderbot.jpbft.command.SendBotMessage;
import github.telegramimagefinderbot.jpbft.command.impl.SendBotMessageImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


import static github.telegramimagefinderbot.jpbft.command.CommandName.NO_COMMAND;

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
                commandContainer.retrieveCommand(NO_COMMAND.getCommandName()).execute(update);
            }

        }
    }


    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
