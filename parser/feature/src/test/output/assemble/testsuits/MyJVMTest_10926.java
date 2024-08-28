public class MyJVMTest_10926 {

    static long n = 1683933972518096680L;

    String rightJustify(long n) {
        String field = "         ";
        String num = Long.toString(n);
        if (num.length() >= field.length())
            return num;
        StringBuilder b = new StringBuilder(field);
        b.replace(b.length() - num.length(), b.length(), num);
        return b.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10926().rightJustify(n));
    }
}
