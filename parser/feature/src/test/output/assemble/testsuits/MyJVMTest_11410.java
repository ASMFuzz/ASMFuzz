public class MyJVMTest_11410 {

    static int prefix = 4;

    boolean checkIPv4PrefixLength(int prefix) {
        if (prefix >= 0 && prefix <= 32)
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11410().checkIPv4PrefixLength(prefix));
    }
}
