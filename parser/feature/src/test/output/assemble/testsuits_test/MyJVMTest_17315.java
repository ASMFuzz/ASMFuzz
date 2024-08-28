public class MyJVMTest_17315 {

    static int x = 2;

    long foo2() {
        return x & 0xff000000;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17315().foo2());
    }
}
