public class MyJVMTest_13830 {

    void doit() {
        throw new RuntimeException("");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13830().doit();
    }
}
