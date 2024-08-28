import java.util.Arrays;

public class MyJVMTest_5171 {

    static String algoForTest = "\\_@*$Q4tw,";

    static byte[] key = {-116,13,-14,-87,88,-19,-81,54,117,5};

    static byte[] salt = {23,-52,-25,-39,-31,23,107,42,-76,-87};

    static String algorithm = "PDA7/hl]-a";

    static int keyLength = 0;

    static String pass = "HEh?nLM(jo";

    static int itereationCount = 2;

    char[] getPassword() {
        return pass.toCharArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5171().getPassword()));
    }
}
