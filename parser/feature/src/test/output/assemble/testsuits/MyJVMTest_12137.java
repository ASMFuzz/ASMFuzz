public class MyJVMTest_12137 {

    void indexOfStringNull() {
        StringBuffer sb = new StringBuffer();
        try {
            sb.indexOf(null);
            throw new RuntimeException("Test failed: should have thrown NPE");
        } catch (NullPointerException npe) {
        } catch (Throwable t) {
            throw new RuntimeException("Test failed: should have thrown NPE. Instead threw " + t);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12137().indexOfStringNull();
    }
}
