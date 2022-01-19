package github.telegramimagefinderbot.jpbft.command.impl;

import github.telegramimagefinderbot.jpbft.bot.JavaTelegramBot;
import github.telegramimagefinderbot.jpbft.command.Command;
import github.telegramimagefinderbot.jpbft.command.SendBotMessage;
import github.telegramimagefinderbot.jpbft.command.impl.SendBotMessageImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Abstract class for test classes
 */
@SpringBootTest
abstract class AbstractCommandTest {
    protected JavaTelegramBot javaTelegramBot = Mockito.mock(JavaTelegramBot.class);
    protected SendBotMessage sendBotMessageTest = new SendBotMessageImpl(javaTelegramBot);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();

    @Test
    public void succsessExecuteCommand() throws TelegramApiException {
        //given
        //Long chatId = Long.valueOf("4215189451851");
        Long chatId = 4215189451851L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(false);

        //when
        getCommand().execute(update);

        //then
        Mockito.verify(javaTelegramBot).execute(sendMessage);
    }
}
