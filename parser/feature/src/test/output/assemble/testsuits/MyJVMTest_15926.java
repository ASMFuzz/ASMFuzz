public class MyJVMTest_15926 {

    static CharSequence sbParam1 = null;

    static StringBuffer sb = new StringBuffer(sbParam1);

    StringBuffer doWith(StringBuffer sb) {
        sb.setLength(0);
        sb.trimToSize();
        sb.append("AA");
        return sb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15926().doWith(sb);
    }
}
