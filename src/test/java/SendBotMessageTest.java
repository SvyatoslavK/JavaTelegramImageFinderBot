import github.telegramimagefinderbot.jpbft.bot.JavaTelegramBot;
import github.telegramimagefinderbot.jpbft.command.SendBotMessage;
import github.telegramimagefinderbot.jpbft.command.impl.SendBotMessageImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessage")
public class SendBotMessageTest {

    private SendBotMessage sendBotMessage;
    private JavaTelegramBot javaTelegramBot;

    @BeforeEach
    public void init(){
      javaTelegramBot = Mockito.mock(JavaTelegramBot.class);
      sendBotMessage = new SendBotMessageImpl(javaTelegramBot);

    }

    @Test
    public void successSM() throws TelegramApiException
    {
        //given
        String chatId = "testChatId";
        String message = "testMessage";
        //when
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(false);
        //then
        sendBotMessage.sendMessage(chatId,message);

        Mockito.verify(javaTelegramBot).execute(sendMessage);
    }

    @Test
    public void failureSM() throws TelegramApiException
    {
        //given
        String chatId = "testChatId";
        String message = "testMessage";
        //when
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        //then
        sendBotMessage.sendMessage(chatId,message);

        Mockito.verify(javaTelegramBot).execute(sendMessage);
    }
}
