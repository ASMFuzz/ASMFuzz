public class MyJVMTest_17777 {

    static int x = 5;

    static int y = 0;

    static int SIZE = 128;

    boolean isBlueArea(int x, int y) {
        return x >= SIZE / 2 && y < SIZE / 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17777().isBlueArea(x, y));
    }
}
