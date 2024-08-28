public class MyJVMTest_15281 {

    static int n = 0;

    int get_n() {
        return n + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15281().get_n());
    }
}
