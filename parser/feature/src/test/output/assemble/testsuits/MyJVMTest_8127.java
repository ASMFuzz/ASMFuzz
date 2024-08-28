public class MyJVMTest_8127 {

    void m() {
        final int i;
        while (true) if (false)
            i = 1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8127().m();
    }
}
