package operations.text;

import models.WeatherModel;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import weather.WeatherController;

import java.util.ArrayList;
import java.util.List;

public class KeyboardActions implements Executor {

//    public SendMessage doPhoneKeyboard(long chat_id, String action) {
//        if (action.contains("show keyboard")) {
//            SendMessage message = new SendMessage()
//                    .setChatId(chat_id)
//                    .setText("Keyboard installed");
//
//            ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
//            //keyboardMarkup.setSelective(true);
//            keyboardMarkup.setResizeKeyboard(true);
//            List<KeyboardRow> keyboard = new ArrayList<>();
//
//            KeyboardRow row = new KeyboardRow();
//            row.add("last picture");
//            row.add("weather");
//            row.add("all picture");
//            keyboard.add(row);
//
//            keyboardMarkup.setKeyboard(keyboard);
//
//            // Add it to the message
//            message.setReplyMarkup(keyboardMarkup);
//            return message;
//
//        }
//        return new SendMessage();
//    }

//    public SendMessage picturekeyboard(long chat_id){
//        SendMessage message = new SendMessage()
//                .setChatId(chat_id)
//                .setText("Keyboard installed");
//
//        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
//        keyboardMarkup.setResizeKeyboard(true);
//       // keyboardMarkup.setSelective(false);
//        List<KeyboardRow> keyboard = new ArrayList<>();
//
//        KeyboardRow row = new KeyboardRow();
//        row.add("last");
//        row.add("all");
//
//        keyboard.add(row);
//        keyboardMarkup.setKeyboard(keyboard);
//
//        // Add it to the message
//        message.setReplyMarkup(keyboardMarkup);
//        return message;
//    }

//    public SendMessage hideKeyboard(Message message) {
//        SendMessage msg = new SendMessage()
//                .setChatId(message.getChatId())
//                .setText("Keyboard hidden");
//        ReplyKeyboardRemove keyboardMarkup = new ReplyKeyboardRemove();
//        msg.setReplyMarkup(keyboardMarkup);
//        return msg;
//
//    }

    @Override
    public SendMessage sendInlineKeyBoard(long chatId, String name) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();

        keyboardButtonsRow1.add(new InlineKeyboardButton().setText("Last picture").setCallbackData("1748032"));
        keyboardButtonsRow1.add(new InlineKeyboardButton().setText("All album").setCallbackData("346422"));
        keyboardButtonsRow2.add(new InlineKeyboardButton().setText("Weather in Kharkov").setCallbackData("1245465"));


        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);

        inlineKeyboardMarkup.setKeyboard(rowList);
        String text;
        if (name!=null){
            text = "What can I help you, "+name+"?";
        }else text = "What can I help you?";


        return new SendMessage()
                .setChatId(chatId)
                .setText(text)
                .setReplyMarkup(inlineKeyboardMarkup);
    }


//    private void setButtons(SendMessage sendMessage, String... value) {
//        if (value != null) {
//            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//            sendMessage.setReplyMarkup(replyKeyboardMarkup);
//            replyKeyboardMarkup.setSelective(true);
//            replyKeyboardMarkup.setResizeKeyboard(true);
//            replyKeyboardMarkup.setOneTimeKeyboard(false);
//
//            List<KeyboardRow> keyboardRowList = new ArrayList<>();
//            KeyboardRow keyboardFirstRow = new KeyboardRow();
//
//            for (String s : value) {
//                keyboardFirstRow.add(new KeyboardButton(s));
//            }
////        keyboardFirstRow.add(new KeyboardButton("pictures"));
////        keyboardFirstRow.add(new KeyboardButton("weather"));
//
//            keyboardRowList.add(keyboardFirstRow);
//            replyKeyboardMarkup.setKeyboard(keyboardRowList);
//        }
//
//    }
}
