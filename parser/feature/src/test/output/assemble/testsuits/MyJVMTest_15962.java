public class MyJVMTest_15962 {

    static int arg = 981020461;

    String print(int arg) {
        return String.valueOf(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15962().print(arg));
    }
}
