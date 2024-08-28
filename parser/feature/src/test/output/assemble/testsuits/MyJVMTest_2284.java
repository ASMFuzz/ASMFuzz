public class MyJVMTest_2284 {

    void zoo() {
        Integer i = 100;
        do {
            throw new RuntimeException();
        } while (i++ < 10);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2284().zoo();
    }
}
