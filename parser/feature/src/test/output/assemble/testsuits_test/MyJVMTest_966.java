public class MyJVMTest_966 {

    static String provName = "Wq9T2A!YNT";

    boolean isSHA3Supported(String provName) {
        if ("SUN".equals(provName)) {
            return true;
        }
        if ("OracleUcrypto".equals(provName) && "SunOS".equals(System.getProperty("os.name")) && System.getProperty("os.version").compareTo("5.12") >= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_966().isSHA3Supported(provName));
    }
}
