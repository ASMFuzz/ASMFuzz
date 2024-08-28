import java.util.Arrays;

public class MyJVMTest_14587 {

    static String algoForTest = "]tbN;<wMtI";

    static byte[] key = {-106,55,121,76,41,-94,-34,86,-45,-49};

    static byte[] salt = {-52,-57,-93,-87,-106,104,35,-32,41,65};

    static String algorithm = "eT[1B9v9eQ";

    static int keyLength = 9;

    static String pass = "-Ixw`^77;W";

    static int itereationCount = 0;

    char[] getPassword() {
        return pass.toCharArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14587().getPassword()));
    }
}
