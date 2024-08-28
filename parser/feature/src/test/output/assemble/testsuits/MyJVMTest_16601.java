public class MyJVMTest_16601 {

    static int[] array = { 5, 0, 0, 3, 3, 4, 2, 1, -385469885, 7 };

    static int w = 2;

    static int x = 3;

    static int y = 4;

    int test(int[] array) {
        int result = 0;
        int[] iArr = new int[8];
        for (int i = 0; i < array.length; i++) {
            for (int j = 5; j < i; j++) {
                if (x == 42) {
                    y = 34;
                }
                iArr[j] += array[j];
                result += array[j];
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16601().test(array));
    }
}
