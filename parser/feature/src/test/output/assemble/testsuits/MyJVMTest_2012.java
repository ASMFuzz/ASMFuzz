public class MyJVMTest_2012 {

    static int limit = 7;

    static int result = 0;

    int test_ge1(int limit) {
        int indx;
        int sum = 0;
        for (indx = 500; indx >= limit; indx -= 2) {
            sum += 2000 / indx;
            result = sum;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2012().test_ge1(limit));
    }
}
