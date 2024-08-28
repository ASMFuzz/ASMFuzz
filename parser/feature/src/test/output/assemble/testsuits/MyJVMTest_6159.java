public class MyJVMTest_6159 {

    static long i = 9223372036854775807L;

    boolean test_helper() {
        i++;
        if ((i % 10) == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6159().test_helper());
    }
}
