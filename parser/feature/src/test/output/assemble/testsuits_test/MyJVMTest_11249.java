public class MyJVMTest_11249 {

    void indexOfStringIntNull() {
        StringBuffer sb = new StringBuffer();
        try {
            sb.indexOf(null, 1);
            throw new RuntimeException("Test failed: should have thrown NPE");
        } catch (NullPointerException npe) {
        } catch (Throwable t) {
            throw new RuntimeException("Test failed: should have thrown NPE. Instead threw " + t);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11249().indexOfStringIntNull();
    }
}
