public class MyJVMTest_15629 {

    static long i = -9223372036854775808L;

    boolean test_helper() {
        i++;
        if ((i % 10) == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15629().test_helper());
    }
}
