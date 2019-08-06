package operations.photos;

import database.DataOperations;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;

import java.util.ArrayList;
import java.util.List;

public class LastPhotoOperation implements ExecutorPhotos {

    @Override
    public List<SendPhoto> doOperationWithPhoho(long chat_id) {
        DataOperations d = new DataOperations();
        try {
            ArrayList<String> fromDB = d.get();
            if (!fromDB.isEmpty()) {
                var element = fromDB.get(fromDB.size()-1);
                List <SendPhoto> list1 = new ArrayList<>();
                        list1.add( new SendPhoto()
                        .setChatId(chat_id)
                        .setPhoto(element)
                        .setCaption("last from db ") );
                return list1;

            }else System.out.println("list is empty");

        } catch (Exception e) {
            System.out.println("error in get");
        }
        return null;
    }



}
