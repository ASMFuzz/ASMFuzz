public class MyJVMTest_8204 {

    static int x = 0;

    static int y = 6;

    static int SIZE = 128;

    boolean isBlueArea(int x, int y) {
        return x >= SIZE / 2 && y < SIZE / 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8204().isBlueArea(x, y));
    }
}
