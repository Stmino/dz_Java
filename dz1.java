import java.util.Scanner;

class dz1 {
  public static int find_n() {
    System.out.println("Введите n:\n");
    Scanner sc = new Scanner(System.in);
    int val = sc.nextInt();
    sc.close();
    return val;
  }

  public static int triangle(int val) {
    int i = 1;
    int t = 1;
    while (i <= val) {
      t = (i * (i + 1)) / 2;
      i = i + 1;
      System.out.println(t);
    }
    return t;
  }

  public static void main(String[] args) {
    int val = find_n();
    triangle(val);
  }
}