public class MyJVMTest_209 {

    static int a = 4;

    static int b = 9;

    static int IGNORE_VALUE = -321;

    boolean areEquals(int a, int b) {
        return a == b || a == IGNORE_VALUE || b == IGNORE_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_209().areEquals(a, b));
    }
}
