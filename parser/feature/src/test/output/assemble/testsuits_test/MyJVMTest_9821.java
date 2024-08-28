public class MyJVMTest_9821 {

    static int p = -1619511689;

    static int x = 1326572810;

    static int y = 4;

    static int q = 4;

    int compiled(int p, int x, int y) {
        return (x < y) ? q + (x - y) : (x - y);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9821().compiled(p, x, y));
    }
}
