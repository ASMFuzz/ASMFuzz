public class MyJVMTest_10800 {

    static String prev = "k%[R3E`%O!";

    String foo(String prev) {
        StringBuffer buf = new StringBuffer(prev);
        buf.append("Different ");
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10800().foo(prev));
    }
}
