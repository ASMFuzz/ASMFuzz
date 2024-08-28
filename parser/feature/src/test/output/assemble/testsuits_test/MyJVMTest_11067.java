public class MyJVMTest_11067 {

    static int count = 8;

    static int b1 = 1239000352;

    static int b2 = 0;

    static int step1 = 0;

    int test1(int count, int b1, int b2) {
        int[] result = { 0 };
        if (b1 == 0) {
            count += 1;
        } else if (b1 == 1) {
            if (b2 == 1) {
                count += 2;
            }
        }
        for (int i = 0; i < count; ++i) {
            step1 = i;
            result[0] += count;
        }
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11067().test1(count, b1, b2));
    }
}
