public class MyJVMTest_13181 {

    static String[] args = { "%,B'OCx{&s", "G~(hW>Y'_b", "-*!L'(p$h-", "dAsuF#GICr", "}#LkGsbg0|", "}6E8aH#@.E", "9t&0X-<f1W", "H0M*ES[)R:", "~9BgOR7.-R", "w#MXH;#<ag" };

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
        new MyJVMTest_13181().test(args);
    }
}
