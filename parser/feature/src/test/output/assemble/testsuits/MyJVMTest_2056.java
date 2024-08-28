public class MyJVMTest_2056 {

    static int prefix = 5;

    boolean checkIPv6PrefixLength(int prefix) {
        if (prefix >= 0 && prefix <= 128)
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2056().checkIPv6PrefixLength(prefix));
    }
}
