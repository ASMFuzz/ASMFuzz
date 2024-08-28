public class MyJVMTest_4656 {

    static int x = 9;

    static int y = 7;

    static int p = 3;

    static int q = 4;

    int interpreted(int x, int y, int q, int p) {
        return (x < y) ? p + q : q;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4656().interpreted(x, y, q, p));
    }
}
