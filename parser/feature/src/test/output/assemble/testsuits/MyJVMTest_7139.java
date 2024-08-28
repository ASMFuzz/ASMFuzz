public class MyJVMTest_7139 {

    static int counter = 0;

    void not_inlined() {
        counter--;
        if (counter <= 0) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7139().not_inlined();
    }
}
