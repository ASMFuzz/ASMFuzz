public class MyJVMTest_4701 {

    static int p = 9;

    static int x = 73258119;

    static int y = 9;

    static int q = 4;

    int interpreted(int p, int x, int y) {
        return (x < y) ? q + (x - y) : (x - y);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4701().interpreted(p, x, y));
    }
}
