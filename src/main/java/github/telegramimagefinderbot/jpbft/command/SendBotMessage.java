package github.telegramimagefinderbot.jpbft.command;
/**
 * Send bot message interface for telegram bot.
 * Type of arguments: String
 * @param @chatId - Id of the chat
 * @param @message - message
*/
public interface SendBotMessage {

    void sendMessage (String chatId, String message);
}

