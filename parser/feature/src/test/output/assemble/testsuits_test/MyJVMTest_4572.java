public class MyJVMTest_4572 {

    static int a = 841464278;

    static int b = 4;

    int addPublicInner_Level2(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4572().addPublicInner_Level2(a, b));
    }
}
