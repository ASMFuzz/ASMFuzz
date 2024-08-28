public class MyJVMTest_3839 {

    static String[] args = { "Dx='hjr8XC", "Dv&u^Ysj15", "BvBW>8TwLx", "-#uyusHtP8", "Ont9L\"z-sV", "RoO!T[v~@!", "SNtVZYC`$)", "TE$vqBXE&D", "r$6:CMeb8P", "\"IE{/Ym$E}" };

    float test(String[] args) {
        String[] arr = new String[4];
        float f = -1;
        try {
            arr[0] = "-1";
            if (args.length > 1) {
                f = 42;
                arr[1] = "42";
            }
        } catch (Exception e) {
            for (int i = 0; i < 1; ++i) {
                f = f;
            }
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3839().test(args);
    }
}
