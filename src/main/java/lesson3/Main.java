package lesson3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
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

    }
}
