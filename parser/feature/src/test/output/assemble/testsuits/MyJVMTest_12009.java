import static java.util.Calendar.*;

public class MyJVMTest_12009 {

    static int x = 5;

    static int start = 2;

    static int end = 1053663000;

    int nextFdw(int x, int start, int end) {
        if (x == end)
            return start;
        x++;
        if (x > SATURDAY)
            x = SUNDAY;
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12009().nextFdw(x, start, end));
    }
}
