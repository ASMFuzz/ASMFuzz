public class MyJVMTest_8009 {

    static String cmd = "-UC0)HXIfV";

    JdbCommand pop() {
        return new JdbCommand("pop");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8009().pop());
    }
}
