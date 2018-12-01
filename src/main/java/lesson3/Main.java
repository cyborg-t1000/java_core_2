package lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль

        byte[] ba = new byte[50];
        try (FileInputStream in = new FileInputStream("files/test.txt")) {
            int x, i = 0;
            while ((x = in.read()) != -1 && i<50) {
                ba[i++] = (byte)x;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(ba));

        // 2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт)

        String fileOut = "files/out2.txt";
        FileOutputStream fos = null;
        ArrayList<InputStream> al = new ArrayList<>();
        try {
            al.add(new FileInputStream("files/test1.txt"));
            al.add(new FileInputStream("files/test2.txt"));
            al.add(new FileInputStream("files/test3.txt"));
            al.add(new FileInputStream("files/test4.txt"));
            al.add(new FileInputStream("files/test5.txt"));
            fos = new FileOutputStream(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(al));
        int x;
        while (true) {
            try {
                if ((x = in.read()) == -1) break;
                if (fos != null) {
                    fos.write(x);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            in.close();
            if (fos != null) {
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Написать консольное приложение, которое умеет постранично читать текстовые файлы
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter page number: ");
        int page = keyboard.nextInt();

        Reader reader = new Reader("files/war-and-peace.txt", 1800);
        System.out.println(reader.getPage(page));


    }
}
