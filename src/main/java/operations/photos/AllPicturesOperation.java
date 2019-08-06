package operations.photos;

import database.DataOperations;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;

import java.util.ArrayList;
import java.util.List;

public class AllPicturesOperation implements ExecutorPhotos {

    @Override
    public List<SendPhoto> doOperationWithPhoho(long chat_id){
        DataOperations d = new DataOperations();
        try {
            ArrayList<String> list = d.get();
            if (!list.isEmpty()) {
//                var element = list.get(list.size()-1);

                List<SendPhoto> multiple = new ArrayList<>();
                list.forEach(x->
                        multiple.add(new SendPhoto()
                                .setCaption("from db все ")
                                .setPhoto(x)
                                .setChatId(chat_id)
                        )
                );

                return multiple;

            }else System.out.println("list is empty");


        } catch (Exception e) {
            System.out.println("error in get");
        }
        return null;
    }
}
