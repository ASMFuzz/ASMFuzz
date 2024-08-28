import java.util.ArrayList;

public class MyJVMTest_5167 {

    static List<T> list = new ArrayList<T>();

    static T key = null;

    static Comparator<T> c = null;

    <T> int binarySearch(List<T> list, T key, Comparator<T> c) {
        throw new Error();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5167().binarySearch(list, key, c));
    }
}
