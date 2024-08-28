public class MyJVMTest_11404 {

    static int x = 8;

    static int y = 6;

    static int SIZE = 128;

    boolean isRedArea(int x, int y) {
        return x < SIZE / 2 && y < SIZE / 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11404().isRedArea(x, y));
    }
}
