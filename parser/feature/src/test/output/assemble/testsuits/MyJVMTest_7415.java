public class MyJVMTest_7415 {

    static String cmd = "x 33]y:VP'";

    JdbCommand cont() {
        return new JdbCommand("cont");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7415().cont());
    }
}
