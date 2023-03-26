import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        int i = 0;
        int random = 0;
        while (random != 4) {
            random = (int)(Math.random() * 4);
            i++;
            if (i % 10000000 == 0) {
                System.out.println(i);
            }
        }
        System.out.println(i);
    }
}
