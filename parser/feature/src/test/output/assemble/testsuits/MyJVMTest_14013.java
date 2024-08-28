import java.text.*;

public class MyJVMTest_14013 {

    static long nodes = 0;

    int nodesToHeight(long nodes) {
        int h = 1;
        long n = 1;
        while (n + n - 1 <= nodes) {
            n = n + n;
            h = h + 1;
        }
        return h - 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14013().nodesToHeight(nodes));
    }
}
