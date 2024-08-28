public class MyJVMTest_14047 {

    static int x = 0;

    static int y = -1027145083;

    static int p = 1;

    static int q = 4;

    int interpreted(int x, int y, int q, int p) {
        return (x < y) ? p + q : q;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14047().interpreted(x, y, q, p));
    }
}
