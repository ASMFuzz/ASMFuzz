public class MyJVMTest_386 {

    static int a = 3;

    static int b = 0;

    int addPrivateInner(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_386().addPrivateInner(a, b));
    }
}
