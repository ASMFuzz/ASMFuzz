import java.nio.CharBuffer;

public class MyJVMTest_3874 {

    static String unicodeCNS1 = "CK;{/D'5OJ";

    static String unicodeCNS2 = "dkN9Yqr5qn";

    static String unicodeCNS3 = "H=aS%07B?L";

    static String unicodeCNS4 = "[g6>n,]_nG";

    static String unicodeCNS5 = "P'J7<TdS(y";

    static String unicodeCNS6 = "<-l@N<{ht%";

    static String unicodeCNS7 = "WiqS3UT%eN";

    static String unicodeCNS15 = "K8*K*|LR9d";

    String historicalName() {
        return "EUC_TW_OLD";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3874().historicalName());
    }
}
