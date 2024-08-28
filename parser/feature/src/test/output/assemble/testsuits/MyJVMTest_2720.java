import static java.util.Calendar.*;

public class MyJVMTest_2720 {

    static int x = 1726953325;

    static int start = 4;

    static int end = 0;

    int nextFdw(int x, int start, int end) {
        if (x == end)
            return start;
        x++;
        if (x > SATURDAY)
            x = SUNDAY;
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2720().nextFdw(x, start, end));
    }
}
