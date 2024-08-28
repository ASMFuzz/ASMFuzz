public class MyJVMTest_5280 {

    static String osVersion = System.getProperty("os.version");

    static int osVersionMajor = -1;

    static int osVersionMinor = -1;

    void init_version() {
        try {
            final String[] tokens = osVersion.split("\\.");
            if (tokens.length > 0) {
                osVersionMajor = Integer.parseInt(tokens[0]);
                if (tokens.length > 1) {
                    osVersionMinor = Integer.parseInt(tokens[1]);
                }
            }
        } catch (NumberFormatException e) {
            osVersionMajor = osVersionMinor = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5280().init_version();
    }
}
