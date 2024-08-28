public class MyJVMTest_4426 {

    static int a = 0;

    static int b = -633753349;

    static int nonStaticPublicField = 4;

    static int nonStaticFinalPublicField = 1746099477;

    int addPublic(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4426().addPublic(a, b));
    }
}
