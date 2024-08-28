public class MyJVMTest_11180 {

    static int i = 0;

    static int limit = -1606463962;

    int test2(int i, int limit) {
        int result = 0;
        while (i-- != 0) {
            if (result <= limit)
                break;
            result = i * 2;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11180().test2(i, limit));
    }
}
