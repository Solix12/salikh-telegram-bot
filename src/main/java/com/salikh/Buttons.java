package com.salikh;

import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Buttons {

    SendMessage sendMessage = new SendMessage();
    List<KeyboardRow> keyboardRowList = new ArrayList<>();
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

    //chose language function
    public void choseLanguage(Message message, String user_name) {

        //uzbek and rus language
        KeyboardRow keyboardRowUzb = new KeyboardRow();
        KeyboardButton keyboardButtonUzb = new KeyboardButton();
        KeyboardButton keyboardButtonRu = new KeyboardButton();
        keyboardButtonUzb.setText("\uD83C\uDDFA\uD83C\uDDFF O'zbekcha");
        keyboardButtonRu.setText("\uD83C\uDDF7\uD83C\uDDFA Русский");
        keyboardRowUzb.add(keyboardButtonUzb);
        keyboardRowUzb.add(keyboardButtonRu);
        keyboardRowList.add(keyboardRowUzb);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        //send message
        sendMessage.setText("Assalomu alaykum " + user_name + "\nTilni tanlang \uD83C\uDDFA\uD83C\uDDFF " + "\n\nЗдравствуйте " + user_name + "\nВыберите язык \uD83C\uDDF7\uD83C\uDDFA");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setChatId(String.valueOf(message.getChatId()));

    }

    //get SendMessage
    public SendMessage getSendMessage() {
        return sendMessage;
    }
}
