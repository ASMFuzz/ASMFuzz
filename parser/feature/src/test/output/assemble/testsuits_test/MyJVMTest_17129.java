import java.util.Arrays;

public class MyJVMTest_17129 {

    static String[] args = { "E.o_tu]Eu`", "&DBN,Mv4=$", "2A)G|{gD2.", "5(v.W3F#[7", "LxVy__:\\F=", "1#92_[[sY*", "qg3AO<>)QR", "pYg,4%@Ly.", "u WPyOuACN", "b!jJaO^ b(" };

    static String keyword = "oN.V;PDTD_";

    static int defaultValue = 2104221831;

    String keywordValue(String[] args, String keyword) {
        for (String arg : args) if (arg.startsWith(keyword))
            return arg.substring(keyword.length() + 1);
        return null;
    }

    static int[] sofar = {0,0,0,-1273621920,-2027910465,3,8,7,-1205084145,5};

    int intArg(String[] args, String keyword, int defaultValue) {
        String val = keywordValue(args, keyword);
        return (val == null) ? defaultValue : Integer.parseInt(val);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17129().intArg(args, keyword, defaultValue));
    }
}
