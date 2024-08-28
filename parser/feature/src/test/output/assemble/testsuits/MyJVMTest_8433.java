public class MyJVMTest_8433 {

    static int a = 4;

    static int b = 1;

    static int nonStaticPublicField = 1;

    int addPublic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8433().addPublic(a, b));
    }
}
