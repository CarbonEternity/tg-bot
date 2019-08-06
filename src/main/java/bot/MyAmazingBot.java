package bot;

import models.WeatherModel;
import operations.photos.ActionsWithPhotos;
import operations.photos.Parameters;
import operations.text.Executor;
import operations.text.KeyboardActions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import weather.WeatherController;

import java.util.List;

public class MyAmazingBot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                if (update.getMessage().getText().equals("@croft_jv_bot start")) {
                    Executor keyboard = new KeyboardActions();
                    try {
                        execute(keyboard.sendInlineKeyBoard(update.getMessage().getChatId(), update.getMessage().getChat().getFirstName()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if (update.hasMessage() && update.getMessage().hasPhoto()) {
                SendPhoto photo = new Parameters().getPhotosParameters(update);
                sendPicture(photo);
            }
        } else if (update.hasCallbackQuery()) {
            String callbackNumber = update.getCallbackQuery().getData();
            switch (callbackNumber) {
                case "1748032": {
                    List<SendPhoto> message = ActionsWithPhotos.LAST.doOperationWithPhoho(update.getCallbackQuery().getMessage().getChatId());
                    message.forEach(this::sendPicture);
                    break;
                }

                case "346422": {
                    List<SendPhoto> message = ActionsWithPhotos.ALL.doOperationWithPhoho(update.getCallbackQuery().getMessage().getChatId());
                    message.forEach(this::sendPicture);
                    break;
                }

                case "1245465": {
                    sendMessageWithWeather(update.getCallbackQuery().getMessage(), "Kharkiv");
                    break;
                }


            }

        }
    }

    private SendMessage sendMessageWithWeather(Message message, String city) {

        WeatherController controller = new WeatherController();
        String weatherPrognoxz = controller.getWeather(city, new WeatherModel());

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        // sendMessage.setReplyToMessageId(message.getMessageId());

        sendMessage.setText(weatherPrognoxz);
        return sendMessage;
    }

    private void sendPicture(SendPhoto msg) {
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return "Croft-Weather Jv";
    }

    @Override
    public String getBotToken() {
        return "927128344:AAHDCEqzqOmWFftPl8PzNlWWilp-iGU9y0w";
    }
}
