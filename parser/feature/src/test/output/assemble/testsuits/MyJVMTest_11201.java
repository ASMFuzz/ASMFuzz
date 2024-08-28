public class MyJVMTest_11201 {

    static int v = 0;

    static int v2 = 0;

    void m1() {
        v2 = v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11201().m1();
    }
}
