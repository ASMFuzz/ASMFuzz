public class MyJVMTest_5590 {

    static int a = 0;

    static int b = 4;

    int addPublicInner(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5590().addPublicInner(a, b));
    }
}
