public class MyJVMTest_17698 {

    void m() {
        final int i;
        while (true) if (false)
            i = 1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17698().m();
    }
}
