package operations.text;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public enum Actions {
    KEYBOARD(new KeyboardActions());

    private final Executor executor;

     Actions(Executor executor) {
        this.executor = executor;
    }

    public SendMessage doCommand(long chat_id, String action){
        return executor.sendInlineKeyBoard(chat_id, action);
    }
}
