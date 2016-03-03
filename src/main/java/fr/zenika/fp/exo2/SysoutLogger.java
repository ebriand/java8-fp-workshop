package fr.zenika.fp.exo2;

public class SysoutLogger implements ILogger {

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
