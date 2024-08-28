public class MyJVMTest_651 {

    static int p = 7;

    static int x = 4;

    static int y = 946723614;

    static int q = 4;

    int compiled(int p, int x, int y) {
        return (x < y) ? q + (x - y) : (x - y);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_651().compiled(p, x, y));
    }
}
