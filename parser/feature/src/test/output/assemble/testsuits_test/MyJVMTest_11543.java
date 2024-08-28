public class MyJVMTest_11543 {

    void zoo() {
        Integer i = 100;
        do {
            throw new RuntimeException();
        } while (i++ < 10);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11543().zoo();
    }
}
