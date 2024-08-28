public class MyJVMTest_4855 {

    static int[] array = { 0, 0, -793542649, 6, -2088579214, 5, 0, 6, 0, 7 };

    int test5(int[] array) {
        int result = 0;
        int[] iArr = new int[8];
        for (int i = 0; i < array.length; i++) {
            for (int j = 5; j < i; j++) {
                iArr[j] += array[j];
                result += array[j];
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4855().test5(array));
    }
}
