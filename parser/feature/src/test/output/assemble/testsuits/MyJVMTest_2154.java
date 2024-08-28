public class MyJVMTest_2154 {

    static int x = 0;

    static int y = -224064268;

    static int SIZE = 128;

    boolean isRedArea(int x, int y) {
        return x < SIZE / 2 && y < SIZE / 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2154().isRedArea(x, y));
    }
}
