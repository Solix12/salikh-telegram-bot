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

public class UzbTaxi extends Taxi {


    SendMessage sendMessage = new SendMessage();
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    List<KeyboardRow> keyboardRowList = new ArrayList<>();


    //menu function
    public void Menu(Message message) {

        //call taxi & info
        KeyboardRow keyboardRow = new KeyboardRow();
        KeyboardButton keyboardButtonCall = new KeyboardButton();
        KeyboardButton keyboardButtonInfo = new KeyboardButton();
        keyboardButtonCall.setText("\uD83D\uDE96 Taxi chaqirish");
        keyboardButtonInfo.setText("\uD83D\uDCD2 Ma'lumot");
        keyboardRow.add(keyboardButtonCall);
        keyboardRow.add(keyboardButtonInfo);
        keyboardRowList.add(keyboardRow);
        replyKeyboardMarkup.setResizeKeyboard(true);

        //statistic
        KeyboardRow keyboardRowSta = new KeyboardRow();
        KeyboardButton keyboardButtonSta = new KeyboardButton();
        keyboardButtonSta.setText("\uD83D\uDCCA Statistika");
        keyboardRowSta.add(keyboardButtonSta);
        keyboardRowList.add(keyboardRowSta);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        //send message
        sendMessage.setText("Quydagilardan birini tanlang \uD83D\uDD30");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }

    //call taxi function
    public void callTaxi(Message message) {

        //tel
        KeyboardRow keyboardRowTel = new KeyboardRow();
        KeyboardButton keyboardButtonTel = new KeyboardButton();
        keyboardButtonTel.setText("☎️  Telefon raqamini ayting");
        keyboardButtonTel.setRequestContact(true);
        keyboardRowTel.add(keyboardButtonTel);
        keyboardRowList.add(keyboardRowTel);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        //back
        KeyboardRow keyboardRowBack = new KeyboardRow();
        KeyboardButton keyboardButtonBack = new KeyboardButton();
        keyboardButtonBack.setText("⬅️ Ortga");
        keyboardRowBack.add(keyboardButtonBack);
        keyboardRowList.add(keyboardRowBack);
        replyKeyboardMarkup.setResizeKeyboard(true);

        //send message
        sendMessage.setText("Men sizning buyurtmangizni olishga tayyorman! Endi menga telefon raqamingizni aytish uchun quyidagi tugmani bosing. Tafsilotlarni aniqlashtirish uchun dispetcher (robot emas, shaxs) 2 daqiqa ichida ushbu raqamga qo'ng'iroq qiladi. (Hech kim qo'ng'iroq qilmaydi, chunki bu beta bot) \uD83D\uDE0A");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }

    //location function
    public void locSend(Message message) {

        //geo location
        KeyboardRow keyboardRowGeo = new KeyboardRow();
        KeyboardButton keyboardButtonGeo = new KeyboardButton();
        keyboardButtonGeo.setText("\uD83D\uDCCD Geografik joylashuvni yuborish");
        keyboardButtonGeo.setRequestLocation(true);
        keyboardRowGeo.add(keyboardButtonGeo);
        keyboardRowList.add(keyboardRowGeo);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        //cancel
        KeyboardRow keyboardRowCen = new KeyboardRow();
        KeyboardButton keyboardButtonCen = new KeyboardButton();
        keyboardButtonCen.setText("❌ Bekor qilish");
        keyboardRowCen.add(keyboardButtonCen);
        keyboardRowList.add(keyboardRowCen);

        //send message
        sendMessage.setText("Yaxshi! Endi joylashuvingiz haqida xabar berish uchun quyidagi tugmani bosing - men mashinani qaerga yuborishni bilishim kerak. Ammo dispetcher 2 daqiqa ichida sizga qo'ng'iroq qilib, nuanslarni aniqlab beradi. (Aslida, mashina kelmaydi va hech kim qo'ng'iroq qilmaydi, chunki bu mening imkoniyatlarimning namoyishi)\n \uD83D\uDE0A");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }

    //the end
    public void andLocation(Message message, int random, Location location, String user_name , int random1) {
        Menu(message);
        sendMessage.setText("Buyurtma raqami : " + random + " \uD83D\uDCCC \nJoylashuv(" + location.getLatitude() + " " + location.getLongitude() + ") \uD83D\uDCCD" +
                "\n" + user_name + " Arizangiz qabul qlindi "+random1+" daqiqadan song mashina joylashuvga yetib boradi \uD83D\uDE0A");
    }

    //statistics
    public void statistic(Message message, int totalMember) {
        sendMessage.setText("\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDCBB Botdagi obunachilar: " + totalMember + " ta\n\nBot praktika qilish maqsadida tayorlangan\n\uD83D\uDCCA @Taxisalikhbot statistikasi");
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setParseMode(ParseMode.MARKDOWN);
    }

    //information
    public void info(Message message) {
        sendMessage.setText("@Taxisalikhbot loyhasi salikh tomonidan  , toshkent shahrida taxsi chaqirishni" +
                " qulay qilish maqsatida yaratiilgan . Taklif va murojatlar uchun \uD83E\uDDD1\uD83C\uDFFC\u200D\uD83D\uDCBB @salikh444");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
    }

    //getMessage function
    public SendMessage getSendMessage() {
        return sendMessage;
    }


}
