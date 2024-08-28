public class MyJVMTest_7981 {

    void paramTest() throws Exception {
        try {
            System.clearProperty(null);
            throw new RuntimeException("Param test failed");
        } catch (NullPointerException npe) {
        }
        try {
            System.clearProperty("");
            throw new RuntimeException("Param test failed");
        } catch (IllegalArgumentException iae) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7981().paramTest();
    }
}
