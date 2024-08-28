import java.util.Random;

public class MyJVMTest_16869 {

    static int max = 0;

    static Random r = null;

    int next(int max) {
        if (max <= 0)
            return 0;
        int x = r.nextInt();
        if (x < 0)
            x = 0 - x;
        return x % (max + 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16869().next(max));
    }
}
