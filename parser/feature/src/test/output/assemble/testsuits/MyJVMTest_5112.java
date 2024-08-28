public class MyJVMTest_5112 {

    static int a = -2057154005;

    static int b = 0;

    static int nonStaticPublicField = 6;

    int addPublicInner(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5112().addPublicInner(a, b));
    }
}
