public class MyJVMTest_3990 {

    static int a = 0;

    static int b = 0;

    int addPublicInner(int a, int b) {
        return a + b + 20;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3990().addPublicInner(a, b));
    }
}
