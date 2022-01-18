package github.telegramimagefinderbot.jpbft.command.impl;

import github.telegramimagefinderbot.jpbft.command.Command;
import github.telegramimagefinderbot.jpbft.command.SendBotMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static github.telegramimagefinderbot.jpbft.command.CommandName.*;

public class HelpCommand implements Command {

    private final SendBotMessage sendBotMessage;
    public static final String HELP_MESSAGE = String.format(
            "Commands for bots:\n \n" +
                    "%s - get started work with bot\n" +
                    "%s - stop work with bot\n" +
                    "%s - get help work with bot\n" +
                    "%s - get message from bot with information\n" +
                    "%s - get pictures from your site list\n" +
                    "%s - like photo and post it on your telegram channel\n" +
                    "%s - dislike photo and reject posting on your telegram channel \n" +
                    "%s - show your stats" +
                    "%s - show your sites subscription\n" +
                    "%s - add site to your favourites\n" +
                    "%s - remove site from your favourites\n",
            START.getCommandName(),
            STOP.getCommandName(),
            HELP.getCommandName(),
            MESSAGE.getCommandName(),
            PICTURE.getCommandName(),
            POST.getCommandName(),
            DISLIKE.getCommandName(),
            STATS.getCommandName(),
            LISTSITESSUB.getCommandName(),
            ADDSITESUB.getCommandName(),
            REMOVESITESSUB.getCommandName()

    );

    public HelpCommand(SendBotMessage sendBotMessage) {
        this.sendBotMessage = sendBotMessage;
    }

    @Override
    public void execute(Update update) {
        sendBotMessage.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }

}
