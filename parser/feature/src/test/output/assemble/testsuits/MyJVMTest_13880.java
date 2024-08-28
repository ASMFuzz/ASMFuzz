public class MyJVMTest_13880 {

    static String name = "ov+4VmA\\e+";

    static String signature = "@;2iwv=>7^";

    boolean hasId() {
        char ch = signature.charAt(0);
        return (ch == '[' || ch == 'L');
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13880().hasId());
    }
}
