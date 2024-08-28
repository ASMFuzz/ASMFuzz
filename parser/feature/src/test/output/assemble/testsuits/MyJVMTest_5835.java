public class MyJVMTest_5835 {

    static int n = 0;

    int get_n() {
        return n + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5835().get_n());
    }
}
