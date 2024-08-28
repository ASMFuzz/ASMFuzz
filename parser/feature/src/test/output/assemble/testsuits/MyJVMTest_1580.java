public class MyJVMTest_1580 {

    static String prev = "\"<WG.zx>:/";

    String foo(String prev) {
        StringBuffer buf = new StringBuffer(prev);
        buf.append("Different ");
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1580().foo(prev));
    }
}
