public class MyJVMTest_4931 {

    static long a = 5866503628919639456L;

    boolean test_isGeC(long a) {
        return a >= 7L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4931().test_isGeC(a));
    }
}
