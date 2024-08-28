public class MyJVMTest_16044 {

    static long a = 578620033688093202L;

    long test_shrc65(long a) {
        return a >> 65;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16044().test_shrc65(a));
    }
}
