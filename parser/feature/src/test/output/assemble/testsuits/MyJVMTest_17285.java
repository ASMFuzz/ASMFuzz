public class MyJVMTest_17285 {

    void run() throws Exception {
        try {
            System.getProperty(null);
            throw new Exception("Expected NullPointerException not " + "thrown");
        } catch (NullPointerException npe) {
        }
        try {
            System.getProperty(null, "value");
            throw new Exception("Expected NullPointerException not " + "thrown");
        } catch (NullPointerException npe) {
        }
        try {
            System.getProperty("");
            throw new Exception("Expected IllegalArgumentException not " + "thrown");
        } catch (IllegalArgumentException iae) {
        }
        try {
            System.getProperty("", "value");
            throw new Exception("Expected IllegalArgumentException not " + "thrown");
        } catch (IllegalArgumentException iae) {
        }
        try {
            System.setProperty(null, "value");
            throw new Exception("Expected NullPointerException not " + "thrown");
        } catch (NullPointerException npe) {
        }
        try {
            System.setProperty("", "value");
            throw new Exception("Expected IllegalArgumentException not " + "thrown");
        } catch (IllegalArgumentException iae) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17285().run();
    }
}
