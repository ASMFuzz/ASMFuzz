public class MyJVMTest_5163 {

    static StringBuffer sb = null;

    StringBuffer doWith(StringBuffer sb) {
        sb.setLength(0);
        sb.trimToSize();
        sb.append("AA");
        return sb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5163().doWith(sb);
    }
}
