package com.svilen.unit4extensionkitliquidxmlwithnamespaceconverterjavafx;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MessageConverter2 {
    public static String convert(String message, String variable) {
        return Arrays.stream(message.split("\\.")).map(item -> {
            if ((item.contains("{{")) && (item.contains(variable))) {
                return item + ".";
            }
            if (item.equals("ParsedContent")) return item;
            if (item.equals("Envelope")) item = "soapenv:" + item;
            else if (item.equals("Body")) item = "soapenv:" + item;
            else item = "BG:" + item;

            if (item.contains("}}")) {
                String m = item.substring(item.indexOf("}}"));
                item = item.substring(0, item.indexOf("}}"));
                item = "[\"" + item + "\"]";
                return item + m;
            }
            return "[\"" + item + "\"]";
        }).collect(Collectors.joining());
    }
}
