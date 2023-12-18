package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
    personInfo();
    }

    public static String personInfo() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите Ваше ФИО через пробел. При отсутствии отчества, поставьте прочерк: ");
        String fio = scanner.nextLine();
        String[] fioPerson = fio.split(" ");
        if(fioPerson.length != 3) {
            throw new RuntimeException("Введите полностью Фамилию Имя Отчество, при отсутствии отчества поставьте -");
        }

        System.out.print("Введите дату рождения в формате dd.mm.yyyy (пример: 17.06.1995): ");
        String date = scanner.nextLine();
        if(date.length() != 10) {
            throw new RuntimeException("Дата введена ошибочно!. Формат не соответствует dd.mm.yyyy");
        }

        System.out.print("Введите номер телефона начиная с 7 (Номер телефона должен быть не менее 11 цифр!): ");
        String phoneNumber = scanner.nextLine();
        if(phoneNumber.length() != 11 ) {
            throw new RuntimeException("Введен неверный формат номера телефона!");
        }
        System.out.print("Введите Ваш пол: f-женский, m - мужской: ");
        String gender = scanner.nextLine();
        if(Objects.equals(gender, "m") | Objects.equals(gender, "f"));
        else throw new RuntimeException("Введен неверный формат пола");
        String [] result = new String[]{fio,date,phoneNumber,gender};
        String fileName = fioPerson[0] + ".txt";
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file, true);
        if(!file.exists()) {
            file.createNewFile();
            for(String str: result) {
                fileWriter.write(str + " ");
            }
        }  else {
            for (String str : result) {
                fileWriter.write(str + " ");
            }
        }
        fileWriter.close();
        System.out.println("Данные успешно сохранены в файл " + fileName);
        scanner.close();
        return null;
        }
    }