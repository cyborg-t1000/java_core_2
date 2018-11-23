import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {1, 2, 3, 4, 5, 6, 7};
        String[] arr2 = new String[] {"a", "b", "c", "d", "e"};

        swap(arr1, 2, 3);
        System.out.println(Arrays.toString(arr1));

        swap(arr2, 2, 3);
        System.out.println(Arrays.toString(arr2));

        System.out.println(array2list(arr1).getClass());

    }

    private static <T> void swap(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static <T> ArrayList<T> array2list(T[] a) {
        ArrayList<T> al = new ArrayList<T>();
        Collections.addAll(al, a);
        return al;
    }

}
