public class MyJVMTest_1704 {

    static long n = 2527601036706670194L;

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
        System.out.println(new MyJVMTest_1704().rightJustify(n));
    }
}
