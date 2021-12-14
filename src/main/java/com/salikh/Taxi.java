package com.salikh;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Taxi extends TelegramLongPollingBot {

    String nation;
    static int totalMember;


    @Override
    public String getBotUsername() {
        return "taxisalikhbot";
    }

    @Override
    public String getBotToken() {
        return "5043441404:AAH7KVz9Sv6orlolVsimC3CaeUYgTFJFDCQ";
    }

    @Override
    public void onUpdateReceived(Update update) {
        UzbTaxi uzbTaxi = new UzbTaxi();
        RusTaxi rusTaxi = new RusTaxi();
        Buttons buttons = new Buttons();
        Message message = update.getMessage();
        String user_name = update.getMessage().getChat().getFirstName();

        int min = 4000;
        int max = 5000;
        int random = (int) (Math.random() * (max - min + 1) + min);

        int min1 = 2;
        int max2 = 9;
        int random1 = (int) (Math.random() * (max2 - min1 + 1) + min1);

        if (message.hasText()) {
            String text = message.getText();
            if (text.equals("/start")) {
                totalMember++;
                System.out.println("Start bosildi !");
                buttons.choseLanguage(message, user_name);
                try {
                    execute(buttons.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (text.equals("\uD83C\uDDFA\uD83C\uDDFF O'zbekcha")) {
                System.out.println("O'zbek tili !");
                nation = "Uzbek";
                uzbTaxi.Menu(message);
                try {
                    execute(uzbTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (text.equals("\uD83C\uDDF7\uD83C\uDDFA Русский")) {
                System.out.println("Rus tili !");
                nation = "Rus";
                rusTaxi.Menu(message);
                try {
                    execute(rusTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (text.equals("\uD83D\uDE96 Taxi chaqirish")) {
                System.out.println("U : Taksi chaqirish !");
                uzbTaxi.callTaxi(message);
                try {
                    execute(uzbTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (text.equals("\uD83D\uDE96 Вызвать такси")) {
                System.out.println("R : Taksi chaqirish !");
                rusTaxi.callTaxi(message);
                try {
                    execute(rusTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (text.equals("⬅️ Ortga")) {
                System.out.println("U : orqaga !");
                uzbTaxi.Menu(message);
                try {
                    execute(uzbTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (text.equals("⬅️ Назад")) {
                System.out.println("R : orqaga !");
                rusTaxi.Menu(message);
                try {
                    execute(rusTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (text.equals("❌ Bekor qilish")) {
                System.out.println("U : Bekor qlish !");
                uzbTaxi.Menu(message);
                try {
                    execute(uzbTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (text.equals("❌ Отменить")) {
                System.out.println("R : Bekor qlish !");
                rusTaxi.Menu(message);
                try {
                    execute(rusTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (text.equals("\uD83D\uDCCA Statistika")) {
                System.out.println("U : Statistika !");
                uzbTaxi.statistic(message, totalMember);
                try {
                    execute(uzbTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (text.equals("\uD83D\uDCCA Статистика")) {
                System.out.println("R : Statistika !");
                rusTaxi.statistic(message, totalMember);
                try {
                    execute(rusTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (text.equals("\uD83D\uDCD2 Ma'lumot")) {
                System.out.println("U : Malimotlar !");
                uzbTaxi.info(message);
                try {
                    execute(uzbTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (text.equals("\uD83D\uDCD2 Информация")) {
                System.out.println("R : Malimotlar !");
                rusTaxi.info(message);
                try {
                    execute(rusTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        } else if (message.hasContact()) {
            Contact contact = message.getContact();
            System.out.println("Raqam yuborildi :" + contact.getPhoneNumber());
            if (nation.equals("Uzbek")) {
                uzbTaxi.locSend(message);
                try {
                    execute(uzbTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (nation.equals("Rus")) {
                rusTaxi.locSend(message);
                try {
                    execute(rusTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        } else if (message.hasLocation()) {
            Location location = message.getLocation();
            System.out.println("Loc : " + location.getLatitude() + " " + location.getLongitude());
            if (nation.equals("Uzbek")) {
                uzbTaxi.andLocation(message, random, location, user_name, random1);
                try {
                    execute(uzbTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (nation.equals("Rus")) {
                rusTaxi.andLocation(message, random, location, user_name, random1);
                try {
                    execute(rusTaxi.getSendMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}