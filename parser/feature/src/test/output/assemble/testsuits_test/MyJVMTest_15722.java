import java.util.*;

public class MyJVMTest_15722 {

    static List<Integer> list = new ArrayList<Integer>();

    static int N = 100;

    List<Integer> test(List<Integer> list) {
        for (int i = 0; i < N; i++) for (int j = 0; j < i; j++) list.add(i);
        Collections.shuffle(list);
        for (int i = 0; i < N; i++) if (Collections.frequency(list, i) != i)
            throw new RuntimeException(list.getClass() + ": " + i);
        return list;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15722().test(list);
    }
}
