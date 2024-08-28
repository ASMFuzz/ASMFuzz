public class MyJVMTest_5624 {

    static byte arg = -128;

    String print(byte arg) {
        return String.valueOf(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5624().print(arg));
    }
}
