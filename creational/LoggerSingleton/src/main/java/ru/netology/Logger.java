package ru.netology;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger logger = null;
    protected int num = 1;

    private Logger() {
    }

    public void log(String msg) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        System.out.printf("[%s %d] %s\n", LocalDateTime.now().format(fmt), num, msg);
        num++;
    }

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }
}