import javax.swing.UIManager;

public class MyJVMTest_100 {

    static String[] properties = { "s3]tW\\pB!!", "NV|@LFyvw8", "Z arQ,2y.8", "Ra{'%q'd9T", "*o.UC5$HT7", "!<e,oLO}1>", "}F,]f<xn*M", "`xr?0b2sE&", "wWq9fwdoqy", "T+Z0(L9 Ph" };

    String test(final String[] properties) {
        for (final String name : properties) {
            String value = UIManager.getString(name);
            if (value == null) {
                System.err.println("Current LookAndFeel = " + UIManager.getLookAndFeel().getDescription());
                System.err.printf("The value for %s property is null\n", name);
                throw new Error();
            }
        }
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_100().test(properties);
    }
}
