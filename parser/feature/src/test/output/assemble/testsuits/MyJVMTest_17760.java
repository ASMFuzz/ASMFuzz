import java.nio.charset.*;

public class MyJVMTest_17760 {

    static Charset cs = null;

    String checkAliases(Charset cs) {
        for (String alias : cs.aliases()) {
            Charset.forName(alias);
            Charset.isSupported(alias);
        }
        return alias;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17760().checkAliases(cs);
    }
}
