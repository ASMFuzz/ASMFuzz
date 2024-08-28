import javax.management.*;

public class MyJVMTest_4092 {

    static int x = 0;

    static int y = 8;

    int op(int x, int y) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4092().op(x, y));
    }
}
