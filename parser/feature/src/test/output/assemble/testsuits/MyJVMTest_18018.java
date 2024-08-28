public class MyJVMTest_18018 {

    static int a = 7;

    static int b = -1346047123;

    static int nonStaticPublicField = -1757105383;

    int addPublic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18018().addPublic(a, b));
    }
}
