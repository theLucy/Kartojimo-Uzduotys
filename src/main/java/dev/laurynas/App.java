package dev.laurynas;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
        Pattern a = Pattern.compile("\\w");
        Matcher b = a.matcher("aaaa sample text");
        b.reset()

    }
}