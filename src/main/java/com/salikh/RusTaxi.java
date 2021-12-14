package com.salikh;

import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class RusTaxi {


    SendMessage sendMessage = new SendMessage();
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    List<KeyboardRow> keyboardRowList = new ArrayList<>();


    //menu function
    public void Menu(Message message) {

        //call taxi & info
        KeyboardRow keyboardRow = new KeyboardRow();
        KeyboardButton keyboardButtonCall = new KeyboardButton();
        KeyboardButton keyboardButtonInfo = new KeyboardButton();
        keyboardButtonCall.setText("\uD83D\uDE96 Вызвать такси");
        keyboardButtonInfo.setText("\uD83D\uDCD2 Информация");
        keyboardRow.add(keyboardButtonCall);
        keyboardRow.add(keyboardButtonInfo);
        keyboardRowList.add(keyboardRow);
        replyKeyboardMarkup.setResizeKeyboard(true);

        //statistic
        KeyboardRow keyboardRowSta = new KeyboardRow();
        KeyboardButton keyboardButtonSta = new KeyboardButton();
        keyboardButtonSta.setText("\uD83D\uDCCA Статистика");
        keyboardRowSta.add(keyboardButtonSta);
        keyboardRowList.add(keyboardRowSta);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        //send message
        sendMessage.setText("Выберите один из следующих \uD83D\uDD30");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }

    //call taxi function
    public void callTaxi(Message message) {

        //tel
        KeyboardRow keyboardRowTel = new KeyboardRow();
        KeyboardButton keyboardButtonTel = new KeyboardButton();
        keyboardButtonTel.setText("☎️ Сообщить номер телефон");
        keyboardButtonTel.setRequestContact(true);
        keyboardRowTel.add(keyboardButtonTel);
        keyboardRowList.add(keyboardRowTel);

        //back
        KeyboardRow keyboardRowBack = new KeyboardRow();
        KeyboardButton keyboardButtonBack = new KeyboardButton();
        keyboardButtonBack.setText("⬅️ Назад");
        keyboardRowBack.add(keyboardButtonBack);
        keyboardRowList.add(keyboardRowBack);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        //send message
        sendMessage.setText("Я готов принять ваш заказ! Теперь нажмите кнопку ниже, моя подключится к вашему номеру телефона. По этому номеру диспетчер (человек, а не робот) позвонит через 2-х минут для уточнения деталей. (На самом деле никто звонит не будет, поскольку это бета бот) \uD83D\uDE0A");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }

    //location function
    public void locSend(Message message) {

        //geo location
        KeyboardRow keyboardRowGeo = new KeyboardRow();
        KeyboardButton keyboardButtonGeo = new KeyboardButton();
        keyboardButtonGeo.setText("\uD83D\uDCCD Отправить геолокацию");
        keyboardButtonGeo.setRequestLocation(true);
        keyboardRowGeo.add(keyboardButtonGeo);
        keyboardRowList.add(keyboardRowGeo);

        //cancel
        KeyboardRow keyboardRowCen = new KeyboardRow();
        KeyboardButton keyboardButtonCen = new KeyboardButton();
        keyboardButtonCen.setText("❌ Отменить");
        keyboardRowCen.add(keyboardButtonCen);
        keyboardRowList.add(keyboardRowCen);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        //send message
        sendMessage.setText("Хорошо! Теперь нажмите на кнопку ниже, чтобы сообщить ваше местоположение - мне необходимо знать куда присылать машину. Но диспетчер всё равно уточнит нюансы, позвонив вам в течение 2-х минут. (На самом деле машина не приедет и звонить никто не будет, потому что это лишь демонстрация моих возможностей) \uD83D\uDE0A");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }

    //the end
    public void andLocation(Message message, int random, Location location, String user_name , int random1) {
        Menu(message);
        sendMessage.setText("Номер заказа : " + random + " \uD83D\uDCCC \nМесто расположения(" + location.getLatitude() + " " + location.getLongitude() + ") \uD83D\uDCCD" +
                "\n" + user_name + " Ваша заявка будет принята и машина приедет через "+random1+" минут. \uD83D\uDE0A");
    }

    //statistics
    public void statistic(Message message, int totalMember) {
        sendMessage.setText("\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB Подписчики на боте : " + totalMember +
                "\n\nБот создан для практики\n\uD83D\uDCCA @Taxisalikhbot  статистика");
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setParseMode(ParseMode.MARKDOWN);
    }

    //information
    public void info(Message message) {
        sendMessage.setText("Проект @Taxisalikhbot был создан Салихом, чтобы упростить вызов такси в Ташкенте. Для предложений и обращений \uD83E\uDDD1\uD83C\uDFFC\u200D\uD83D\uDCBB @salikh444");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
    }

    //getMessage function
    public SendMessage getSendMessage() {
        return sendMessage;
    }
}