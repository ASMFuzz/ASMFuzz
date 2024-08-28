public class MyJVMTest_14763 {

    static long n = -9223372036854775808L;

    String rightJustify(long n) {
        String field = "         ";
        String num = Long.toString(n);
        if (num.length() >= field.length())
            return num;
        StringBuffer b = new StringBuffer(field);
        b.replace(b.length() - num.length(), b.length(), num);
        return b.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14763().rightJustify(n));
    }
}
