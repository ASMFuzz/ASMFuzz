public class MyJVMTest_6439 {

    static StringBuffer sb = new StringBuffer();

    StringBuffer doWith(StringBuffer sb) {
        sb.setLength(0);
        sb.trimToSize();
        sb.append("AA");
        return sb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6439().doWith(sb);
    }
}
