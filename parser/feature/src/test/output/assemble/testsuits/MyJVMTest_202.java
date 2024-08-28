public class MyJVMTest_202 {

    static int x = 0;

    static int y = 6;

    static int SIZE = 128;

    boolean isMagentaArea(int x, int y) {
        return x >= SIZE / 2 && y >= SIZE / 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_202().isMagentaArea(x, y));
    }
}
