public class MyJVMTest_13093 {

    static int x = 1527320902;

    static int y = -255693161;

    static int SIZE = 128;

    boolean isOrangeArea(int x, int y) {
        return x < SIZE / 2 && y >= SIZE / 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13093().isOrangeArea(x, y));
    }
}
