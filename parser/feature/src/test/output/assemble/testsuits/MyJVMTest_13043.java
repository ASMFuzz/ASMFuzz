public class MyJVMTest_13043 {

    static long arg = -9223372036854775808L;

    String print(long arg) {
        return String.valueOf(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13043().print(arg));
    }
}
