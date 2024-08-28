public class MyJVMTest_2159 {

    static int prefix = -1072723684;

    boolean checkIPv4PrefixLength(int prefix) {
        if (prefix >= 0 && prefix <= 32)
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2159().checkIPv4PrefixLength(prefix));
    }
}
