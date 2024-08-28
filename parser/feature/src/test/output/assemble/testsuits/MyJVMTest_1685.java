public class MyJVMTest_1685 {

    static Number n = null;

    String m(Number n) {
        return "Hello!";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1685().m(n));
    }
}
