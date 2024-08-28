public class MyJVMTest_12784 {

    static String cmd = "&[vh8#e&8h";

    JdbCommand step() {
        return new JdbCommand("step");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12784().step());
    }
}
