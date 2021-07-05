package ru.job4j.chat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    private final String logPath;
    private final String botAnswers;
    private final List<String> botAnswerList = new ArrayList<>();
    private boolean botOnline = true;
    private boolean live = true;
    private boolean botAnswersCopied = false;

    public ConsoleChat(String logPath, String botAnswers) {
        this.logPath = logPath;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String userPhrase;
        try (FileWriter fw = new FileWriter(logPath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            while (live) {
                userPhrase = scanner.nextLine();
                if (userPhrase.equals("стоп")) {
                    botOnline = false;
                } else if (userPhrase.equals("продолжить")) {
                    botOnline = true;
                }
                out.println(userPhrase);
                if (botOnline) {
                    out.println("Бот Володя: " + botAnswer());
                }
                if (userPhrase.equals("закончить")) {
                    live = false;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
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
        System.out.println(botAnswerList.get(rInd));
        return botAnswerList.get(rInd);
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat(
                "chatLog.txt",
                "botAnswers.txt");
        cc.run();
    }
}