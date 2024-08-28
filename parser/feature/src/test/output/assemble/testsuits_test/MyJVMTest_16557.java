public class MyJVMTest_16557 {

    static int n = 1710627452;

    String toHexByteString(int n) {
        if (n < 0)
            n &= 0xFF;
        String s = Integer.toHexString(n).toUpperCase();
        if (s.length() == 1)
            s = '0' + s;
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16557().toHexByteString(n));
    }
}
