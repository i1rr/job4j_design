package ru.job4j.chat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
//    закончить - остановка программы
//    стоп - отключить бота
//    продолжить - возобновить работу бота
    private final String logPath;
    private final String botAnswers;
    private final List<String> botAnswerList = new ArrayList<>();
    private final List<String> temporaryLog = new ArrayList<>();
    private boolean botOnline = true;
    private boolean live = true;
    private boolean botAnswersCopied = false;

    public ConsoleChat(String logPath, String botAnswers) {
        this.logPath = logPath;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String userPhrase;
            while (live) {
                userPhrase = scanner.nextLine();
                if (userPhrase.equals(STOP)) {
                    botOnline = false;
                } else if (userPhrase.equals(CONTINUE)) {
                    botOnline = true;
                }
                temporaryLog.add(userPhrase);
                if (botOnline) {
                    temporaryLog.add(botAnswer());
                }
                if (userPhrase.equals(OUT)) {
                    live = false;
                }
            }

    }

    private String botAnswer() throws IOException {
        if (!botAnswersCopied) {
            try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
                br.lines().forEach(botAnswerList::add);
                botAnswersCopied = true;
            }
        }
            int rInd = (int) ((Math.random() * (botAnswerList.size())));
        String botName = "Бот Володя: ";
        System.out.println(botName + botAnswerList.get(rInd));
        return botName + botAnswerList.get(rInd);
    }

    private void saveLog() {
            try (PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(logPath)
                    ))) {
                for (String str : temporaryLog) {
                    out.println(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat(
                "chatLog.txt",
                "botAnswers.txt");
        cc.run();
        cc.saveLog();
    }
}