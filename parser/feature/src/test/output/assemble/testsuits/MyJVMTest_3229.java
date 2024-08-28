public class MyJVMTest_3229 {

    static int x = 482812553;

    static int y = 2;

    static int p = 0;

    static int q = 4;

    int compiled(int x, int y, int q, int p) {
        return (x < y) ? p + q : q;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3229().compiled(x, y, q, p));
    }
}
