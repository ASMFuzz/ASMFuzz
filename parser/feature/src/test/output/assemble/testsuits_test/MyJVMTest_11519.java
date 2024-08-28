public class MyJVMTest_11519 {

    void clearTest() throws Exception {
        System.setProperty("blah", "blech");
        if (!System.getProperty("blah").equals("blech"))
            throw new RuntimeException("Clear test failed 1");
        System.clearProperty("blah");
        if (System.getProperty("blah") != null)
            throw new RuntimeException("Clear test failed 2");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11519().clearTest();
    }
}
