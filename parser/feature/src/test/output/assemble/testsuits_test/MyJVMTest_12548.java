public class MyJVMTest_12548 {

    static int x = 4;

    static int y = 6;

    static int p = 1;

    static int q = 4;

    int compiled(int x, int y, int q, int p) {
        return (x < y) ? p + q : q;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12548().compiled(x, y, q, p));
    }
}
