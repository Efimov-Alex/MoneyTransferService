package ru.netology.logger;

public interface Logger {
    void log(String msg);
    static Logger getInstance(){
        return null;
    }
}
