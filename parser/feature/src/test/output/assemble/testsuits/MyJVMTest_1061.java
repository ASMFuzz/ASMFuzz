public class MyJVMTest_1061 {

    static boolean arg = true;

    String print(boolean arg) {
        return String.valueOf(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1061().print(arg));
    }
}
