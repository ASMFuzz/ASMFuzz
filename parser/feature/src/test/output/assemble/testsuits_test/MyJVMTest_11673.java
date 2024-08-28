public class MyJVMTest_11673 {

    static int x = 0;

    long foo1() {
        return x & 0xfffffffe;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11673().foo1());
    }
}
