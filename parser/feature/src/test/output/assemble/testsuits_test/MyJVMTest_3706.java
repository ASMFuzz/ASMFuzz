public class MyJVMTest_3706 {

    static long arg = -9223372036854775808L;

    String print(long arg) {
        return String.valueOf(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3706().print(arg));
    }
}
