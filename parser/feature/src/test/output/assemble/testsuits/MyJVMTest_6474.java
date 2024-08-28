public class MyJVMTest_6474 {

    static int arg = 8;

    String print(int arg) {
        return String.valueOf(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6474().print(arg));
    }
}
