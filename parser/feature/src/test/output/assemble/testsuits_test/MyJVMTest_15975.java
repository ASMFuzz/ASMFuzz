public class MyJVMTest_15975 {

    static long a = 5534898790571469004L;

    long test_mulc3(long a) {
        return a * 7;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15975().test_mulc3(a));
    }
}
