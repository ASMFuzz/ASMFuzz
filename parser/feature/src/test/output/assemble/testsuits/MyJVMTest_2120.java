public class MyJVMTest_2120 {

    static Number n = null;

    String m(Number n) {
        return "Number " + n;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2120().m(n));
    }
}
