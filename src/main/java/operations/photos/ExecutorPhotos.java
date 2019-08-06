package operations.photos;

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;

import java.util.List;

public interface ExecutorPhotos {
    List<SendPhoto> doOperationWithPhoho(long chat_id);
}
