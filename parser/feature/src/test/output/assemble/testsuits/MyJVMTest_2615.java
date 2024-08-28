public class MyJVMTest_2615 {

    static short arg = -32768;

    String print(short arg) {
        return String.valueOf(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2615().print(arg));
    }
}
