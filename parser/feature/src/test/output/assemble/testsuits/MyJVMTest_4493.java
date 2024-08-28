public class MyJVMTest_4493 {

    static String name = "s+L%h_,13O";

    static String signature = "$_4n'##G34";

    boolean hasId() {
        char ch = signature.charAt(0);
        return (ch == '[' || ch == 'L');
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4493().hasId());
    }
}
