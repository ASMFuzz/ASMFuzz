public class MyJVMTest_11367 {

    static Number n = null;

    String m(Number n) {
        return "Number " + n;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11367().m(n));
    }
}
