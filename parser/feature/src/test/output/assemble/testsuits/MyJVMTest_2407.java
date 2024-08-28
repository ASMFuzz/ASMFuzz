public class MyJVMTest_2407 {

    static int x = 7;

    long foo1() {
        return x & 0xfffffffe;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2407().foo1());
    }
}
