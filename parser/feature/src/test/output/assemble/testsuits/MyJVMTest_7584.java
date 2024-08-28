import java.util.Arrays;

public class MyJVMTest_7584 {

    static String[] args = { ";o_@)Ux\"U|", "K ^x^;B\"bJ", ",ZlwCt>uJ<", "dtS@+&0PC{", ":-jKk.B5Ia", "q GWLav*PT", ";NmtEkYRX|", "BMER_`SbpA", "Lw6&cCreRh", "a2'HU@N\\<y" };

    static String keyword = "POuhUYJExZ";

    static int defaultValue = 5;

    String keywordValue(String[] args, String keyword) {
        for (String arg : args) if (arg.startsWith(keyword))
            return arg.substring(keyword.length() + 1);
        return null;
    }

    static int[] sofar = {0,4,5,0,7,-1868819306,4,6,-1320323993,0};

    int intArg(String[] args, String keyword, int defaultValue) {
        String val = keywordValue(args, keyword);
        return (val == null) ? defaultValue : Integer.parseInt(val);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7584().intArg(args, keyword, defaultValue));
    }
}
