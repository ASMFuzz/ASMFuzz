public class MyJVMTest_5246 {

    void f2() {
        boolean b = true, c = false;
        if ((c && false) ? b : b)
            ;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5246().f2();
    }
}
