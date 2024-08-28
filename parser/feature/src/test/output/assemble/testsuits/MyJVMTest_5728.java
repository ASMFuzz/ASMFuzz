public class MyJVMTest_5728 {

    static int count = 0;

    void not_inlined() throws Exception1 {
        count++;
        if ((count % 100) == 0) {
            throw new Exception1();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5728().not_inlined();
    }
}
