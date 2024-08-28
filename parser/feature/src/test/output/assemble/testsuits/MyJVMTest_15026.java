public class MyJVMTest_15026 {

    static int a = -1280356426;

    static int b = 7;

    int addPublicInner(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15026().addPublicInner(a, b));
    }
}
