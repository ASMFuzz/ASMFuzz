public class MyJVMTest_18113 {

    static int i = 1861666810;

    static int limit = 7;

    int test1(int i, int limit) {
        int result = 0;
        while (i++ != 0) {
            if (result >= limit)
                break;
            result = i * 2;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18113().test1(i, limit));
    }
}
