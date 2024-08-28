public class MyJVMTest_4445 {

    void doit() {
        throw new RuntimeException("");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4445().doit();
    }
}
