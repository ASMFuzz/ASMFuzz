public class MyJVMTest_7041 {

    static int n = 0;

    String toHexByteString(int n) {
        if (n < 0)
            n &= 0xFF;
        String s = Integer.toHexString(n).toUpperCase();
        if (s.length() == 1)
            s = '0' + s;
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7041().toHexByteString(n));
    }
}
