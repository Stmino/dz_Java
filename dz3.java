
import java.util.Arrays;

public class dz3 {
    public static int[] Arrays(int[] arr) {
        int[] a1 = Arrays.copyOf(arr, arr.length);
        int[] a2 = new int[arr.length];
        int[] res = mergeArrays(a1, a2, 0, arr.length);
        return res;
    }

    public static int[] mergeArrays(int[] a1, int[] a2, int startI, int endI) {
        if (startI >= endI - 1) {
            return a1;
        }
        int middle = startI + (endI - startI) / 2;
        int[] sorted1 = mergeArrays(a1, a2, startI, middle);
        int[] sorted2 = mergeArrays(a1, a2, middle, endI);
        int index1 = startI;
        int index2 = middle;
        int resI = startI;
        int[] res;
        if (sorted1 == a1) {
            res = a2;
        } else {
            res = a1;
        }
        while (index1 < middle
                && index2 < endI) {
            if (sorted1[index1] <= sorted2[index2]) {
                res[resI] = sorted1[index1];
                index1++;
            } else {
                res[resI] = sorted2[index2];
                index2++;
            }
            resI++;
        }
        while (index1 < middle) {
            res[resI] = sorted1[index1];
            index1++;
            resI++;
        }
        while (index2 < endI) {
            res[resI] = sorted2[index2];
            index2++;
            resI++;
        }
        return res;
    }

    public static void main(String args[]) {
        int[] arr = { -1, 99, 10, 23, 5 };
        int[] res = Arrays(arr);
        System.out.println(Arrays.toString(res));
    }
}