package operations.photos;

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;

import java.util.List;

public enum ActionsWithPhotos {
    LAST(new LastPhotoOperation()),
    ALL(new AllPicturesOperation());

    private final ExecutorPhotos executor;

    @Override
    public String toString() {
        return this.name();
    }

    ActionsWithPhotos(ExecutorPhotos executor) {
        this.executor = executor;
    }

    public List<SendPhoto> doOperationWithPhoho(long chat_id){
        return executor.doOperationWithPhoho(chat_id);
    }
}
