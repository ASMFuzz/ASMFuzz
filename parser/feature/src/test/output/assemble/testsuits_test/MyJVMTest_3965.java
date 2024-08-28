public class MyJVMTest_3965 {

    void f1() {
        boolean b = true, c = false;
        if ((b || true) ? c : !c)
            ;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3965().f1();
    }
}
