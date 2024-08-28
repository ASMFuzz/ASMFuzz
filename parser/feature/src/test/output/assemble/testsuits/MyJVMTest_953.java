public class MyJVMTest_953 {

    static int a = 0;

    static int b = 1406588607;

    int checkMethod(int a, int b) {
        return Math.subtractExact(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_953().checkMethod(a, b));
    }
}
