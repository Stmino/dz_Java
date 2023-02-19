
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class dz2 {
    static int a;
    static int b;

    public static void main(String[] args)
            throws IOException {
        read_file();
        System.out.println("Pow = " + power(a, b));
        write_file();
    }

    public static void read_file()
            throws IOException {
        List<String> listOfStrings = new ArrayList<String>();
        listOfStrings = Files.readAllLines(Paths.get("input.txt"));
        for (String str : listOfStrings) {
            if (str.startsWith("a"))
                a = Integer.parseInt(str.substring(2));
            if (str.startsWith("b"))
                b = Integer.parseInt(str.substring(2));
        }
        System.out.println("a = " + a + "; b = " + b);
    }

    public static double power(double a, int b) {

        if (a == 1 || a == 0)
            return a;
        if (b > 1)
            return a * power(a, --b);
        if (b < 1)
            return 1 / a * power(a, ++b);
        return a;
    }

    public static void write_file() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt", true);
        String res = "Result= " + power(a, b) + "\n";
        fileOutputStream.write(res.getBytes());
        fileOutputStream.close();
        System.out.println("Результат записан в output.txt");
    }
}
