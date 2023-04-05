package dev.laurynas;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;

public class App {
    public static final Logger log = Logger.getLogger(App.class.getName());
    public static void main(String[] args) throws Exception {

        log.setLevel(Level.SEVERE);

        // Example of controlling log level with command line arguments.
        if(args.length >= 2 && args[0].equals("--logLevel")) {
            switch (args[1]) {
                case "SEVERE" -> log.setLevel(Level.SEVERE);
                case "WARNING" -> log.setLevel(Level.WARNING);
                case "INFO" -> log.setLevel(Level.INFO);
            }
        }

        // Format example: [14:23:59 INFO]: Kazkokia zinute
        Formatter formatter = new Formatter() {
            @Override
            public String format(LogRecord record) {
                return String.format("[%s %-7s]: %s\n",
                        LocalTime.ofInstant(record.getInstant(), ZoneId.systemDefault())
                                .format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                        record.getLevel(),
                        record.getMessage());
            }
        };

        Handler handler = new FileHandler("app.log", true);
        handler.setFormatter(formatter);

        log.addHandler(handler);

        log.getParent().getHandlers()[0].setFormatter(formatter);
        // Or this
        //Logger.getLogger("").getHandlers()[0].setFormatter(formatter);



        log.info("Programa startavo");
        log.warning("Netiksli data!");


        System.out.println("labas");
        log.config("sveiki visi");
        Thread.sleep(1000);

        log.severe("Buvo perkrauta atmintis");

        log.log(Level.INFO, "Programa baigia darba");

    }
}