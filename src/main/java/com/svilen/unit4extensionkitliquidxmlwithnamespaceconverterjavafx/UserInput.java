package com.svilen.unit4extensionkitliquidxmlwithnamespaceconverterjavafx;

import java.util.Scanner;

public class UserInput {

    public static String getMessage() {
        Scanner scanner = new Scanner(System.in);
        Printer.print("Message: ");
        return scanner.nextLine();
    }
}
