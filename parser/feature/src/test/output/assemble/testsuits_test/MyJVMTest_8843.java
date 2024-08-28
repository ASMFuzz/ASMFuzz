public class MyJVMTest_8843 {

    static String tParam1 = " lLm~+#|MW";

    static String tParam2Param1 = "Gl/ DYX&8N";

    static Throwable tParam2Param2 = new Throwable();

    static Throwable tParam2 = new Throwable(tParam2Param1, tParam2Param2);

    static Throwable t = new Throwable(tParam1, tParam2);

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
        new MyJVMTest_8843().checkIsOldVersion(t);
    }
}
