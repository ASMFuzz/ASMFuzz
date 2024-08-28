import java.util.ArrayList;

public class MyJVMTest_6471 {

    static List<T> list = new ArrayList<T>();

    static T key = null;

    <T extends Object & Comparable<T>> int binarySearch(List<T> list, T key) {
        throw new Error();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6471().binarySearch(list, key));
    }
}
