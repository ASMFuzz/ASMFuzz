public class MyJVMTest_11302 {

    static int prefix = 9;

    boolean checkIPv6PrefixLength(int prefix) {
        if (prefix >= 0 && prefix <= 128)
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11302().checkIPv6PrefixLength(prefix));
    }
}
