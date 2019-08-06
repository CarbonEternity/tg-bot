package operations.text;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface Executor {
    SendMessage sendInlineKeyBoard(long chat_id, String action);
}
