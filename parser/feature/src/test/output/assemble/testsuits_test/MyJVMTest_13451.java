import javax.management.*;

public class MyJVMTest_13451 {

    static int x = 7;

    static int y = 0;

    int op(int x, int y) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13451().op(x, y));
    }
}
