public class MyJVMTest_16314 {

    static String cmd = "idf|paM@mb";

    JdbCommand untrace() {
        return new JdbCommand("untrace");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16314().untrace());
    }
}
