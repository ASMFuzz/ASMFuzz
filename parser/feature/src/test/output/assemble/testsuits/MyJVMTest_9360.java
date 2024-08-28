public class MyJVMTest_9360 {

    static int a = 7;

    static int b = 672923051;

    static int IGNORE_VALUE = -321;

    boolean areEquals(int a, int b) {
        return a == b || a == IGNORE_VALUE || b == IGNORE_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9360().areEquals(a, b));
    }
}
