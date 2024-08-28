public class MyJVMTest_3754 {

    static int x = -694714426;

    static int y = 5;

    static int SIZE = 128;

    boolean isOrangeArea(int x, int y) {
        return x < SIZE / 2 && y >= SIZE / 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3754().isOrangeArea(x, y));
    }
}
