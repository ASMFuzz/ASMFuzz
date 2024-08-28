public class MyJVMTest_17145 {

    static int limit = 0;

    static int result = 0;

    int test_le1(int limit) {
        int indx;
        int sum = 0;
        for (indx = -500; indx <= limit; indx += 2) {
            sum += 3000 / indx;
            result = sum;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17145().test_le1(limit));
    }
}
