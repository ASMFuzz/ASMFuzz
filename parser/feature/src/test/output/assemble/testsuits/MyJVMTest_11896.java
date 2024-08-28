public class MyJVMTest_11896 {

    static short arg = 0;

    String print(short arg) {
        return String.valueOf(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11896().print(arg));
    }
}
