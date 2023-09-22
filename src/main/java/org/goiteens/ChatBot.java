package org.goiteens;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ChatBot {
    private static Map<String, Integer> professions;
    private static Map<String, Integer> dreams;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        initProfessions();
        initDreams();

        String botAnswer = process(message);
        System.out.println(botAnswer);
    }
    
    public static void initProfessions() {
        professions = new LinkedHashMap<>();

        professions.put("Designer", 20000);
        professions.put("Java", 55000);
        professions.put("Frontend", 40000);
        professions.put("QA", 35000);
        professions.put("cashier", 13000);
        professions.put("teacher", 10000);
        professions.put("office_worker", 15000);

    }

    public static void initDreams() {
        dreams = new LinkedHashMap<>();

        dreams.put("Машин", 260000);
        dreams.put("iPhone", 30000);
        dreams.put("xbox", 20000);
        dreams.put("house", 2000000);
        dreams.put("bike", 600000 );
        dreams.put("helicopter-helicopter", 9999999);
        dreams.put("wooburn", 24000);
    }
    
    public static String process(String message) {
        if (isHelloMessage(message)) {
            String botName = "ChatBot";
            return "Вітаю, я - " + botName;
        }

        int professionSalary = find(message, professions);
        int dreamCost = find(message, dreams);

        if (professionSalary < 0) {
            return "Я не знайшов у твоєму повідомленні назви професії";
        }

        if (dreamCost < 0) {
            return "Я не знайшов у твоєму повідомленні мрії, яку ти хочеш";
        }

        int monthCount = calculateMonthCount(dreamCost, professionSalary);

        return "Щоб отримати свою мрію, потрібно місяців: " + monthCount;
    }

    public static int find(String message, Map<String, Integer> data) {
        message = message.toLowerCase();

        for(String word: data.keySet()) {
            String lowerCasedWord = word.toLowerCase();

            if (message.contains(lowerCasedWord)) {
                return data.get(word);
            }
        }

        return -1;
    }
    
    public static int calculateMonthCount(int dreamCost, int professionSalary) {
        int monthCount = dreamCost / professionSalary;
        monthCount = validateMonthCount(monthCount);
        return monthCount;
    }

    public static int validateMonthCount(int monthCount) {
        if (monthCount == 0) {
            return 1;
        }

        return monthCount;
    }
    
    private static boolean isHelloMessage(String message) {
        message = message.toLowerCase();

        String helloWord1 = "привіт";
        String helloWord2 = "вітаю";

        return message.contains(helloWord1) || message.contains(helloWord2);
    }
}
