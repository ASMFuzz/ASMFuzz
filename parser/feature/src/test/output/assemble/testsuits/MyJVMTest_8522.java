public class MyJVMTest_8522 {

    static int i = 0;

    static int limit = 4;

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
        System.out.println(new MyJVMTest_8522().test1(i, limit));
    }
}
