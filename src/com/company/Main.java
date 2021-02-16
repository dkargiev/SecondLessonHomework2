package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String phoneNumber;
        System.out.print("Введите номер телефона:" + " ");
        phoneNumber = console.nextLine();
        console.close();
        String[] result = sortPhoneNumber(phoneNumber);
        System.out.println(result[0]);
        System.out.print(result[1]);
    }

    public static String[] sortPhoneNumber(String number) {
        String[] array = new String[2];
        String message = "";

        String str1, str2, str3, str4, str5;
        str1 = "Не было изменений";
        str2 = "Введен некорректный номер";
        str3 = "В номере есть пробелы и/или скобки";
        str4 = "Замена +7 на 8";
        str5 = "Количество символов больше/меньше 11";

        if (!number.contains("+7")
                && !number.contains("(")
                && !number.contains(")")
                && !number.contains(" ")
                && number.length() == 11) {
            message = message + str1;
        }

        if (number.contains("+7")) {
            number = number.replace("+7", "8");
            message = message + str4 + "; ";
        }

        if (number.contains(" ") || number.contains("(") || number.contains(")")) {
            number = number.replace(" ", "");
            number = number.replace(")", "");
            number = number.replace("(", "");
            message = message + str3 + "; ";
        }

        if(number.length() != 11 || number.isEmpty()) {
            number = str2;
            message = message + str5;
        }

        array[0] = number;
        array[1] = message;

        return array;
    }
}
