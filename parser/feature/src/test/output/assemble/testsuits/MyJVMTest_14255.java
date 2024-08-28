public class MyJVMTest_14255 {

    static int[] array = { 2, 0, 947667237, 0, 1531746925, 3, 4, 2, 5, 0 };

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
        System.out.println(new MyJVMTest_14255().test5(array));
    }
}
