public class MyJVMTest_6864 {

    static String tParam1 = "P2{v1X^,W ";

    static Throwable tParam2Param1 = new Throwable();

    static Throwable tParam2 = new Throwable(tParam2Param1);

    static boolean tParam3 = false;

    static boolean tParam4 = true;

    static Throwable t = new Throwable(tParam1, tParam2, tParam3, tParam4);

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
        new MyJVMTest_6864().checkIsOldVersion(t);
    }
}
