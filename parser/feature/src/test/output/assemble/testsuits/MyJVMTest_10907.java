public class MyJVMTest_10907 {

    static Number n = null;

    String m(Number n) {
        return "Hello!";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10907().m(n));
    }
}
