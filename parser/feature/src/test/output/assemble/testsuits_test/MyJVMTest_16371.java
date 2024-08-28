public class MyJVMTest_16371 {

    static Throwable t = new Throwable();

    String checkIsOldVersion(Throwable t) {
        String version = System.getProperty("java.version");
        version = version.split("\\D")[0];
        int v = Integer.parseInt(version);
        if (v >= 17) {
            t.printStackTrace();
            throw new RuntimeException("Unexpected exception for version " + v);
        }
        return version;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16371().checkIsOldVersion(t);
    }
}
