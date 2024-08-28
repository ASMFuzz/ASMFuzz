public class MyJVMTest_16662 {

    static int counter = 0;

    void not_inlined() {
        counter--;
        if (counter <= 0) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16662().not_inlined();
    }
}
