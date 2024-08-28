public class MyJVMTest_11019 {

    static String cmd = "gVNE,l%L&r";

    JdbCommand next() {
        return new JdbCommand("next");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11019().next());
    }
}
