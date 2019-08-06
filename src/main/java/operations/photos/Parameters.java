package operations.photos;

import database.DataOperations;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Comparator;
import java.util.List;

public class Parameters {

    public SendPhoto getPhotosParameters(Update update) {
        long chat_id = update.getMessage().getChatId();

        List<PhotoSize> photos = update.getMessage().getPhoto();

        String f_id = photos.stream()
                .max(Comparator.comparing(PhotoSize::getFileSize))
                .orElse(null).getFileId();

        int f_width = photos.stream()
                .max(Comparator.comparing(PhotoSize::getFileSize))
                .orElse(null).getWidth();

        int f_height = photos.stream()
                .max(Comparator.comparing(PhotoSize::getFileSize))
                .orElse(null).getHeight();

        String caption = "width: " + f_width + "\nheight: " + f_height;


        DataOperations d = new DataOperations();
        try {
            d.insert(f_id);
        } catch (Exception e) {
            System.out.println("insert was wrong");
        }

        return new SendPhoto()
                .setChatId(chat_id)
                .setPhoto(f_id)
                .setCaption(caption);

    }
}
