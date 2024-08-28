public class MyJVMTest_15060 {

    static byte arg = 20;

    String print(byte arg) {
        return String.valueOf(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15060().print(arg));
    }
}
