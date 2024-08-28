public class MyJVMTest_13315 {

    void f1() {
        boolean b = true, c = false;
        if ((b || true) ? c : !c)
            ;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13315().f1();
    }
}
