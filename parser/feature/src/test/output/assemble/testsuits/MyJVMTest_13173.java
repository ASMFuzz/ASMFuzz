public class MyJVMTest_13173 {

    static int[] intArr = { 8, 0, 4, 6, 5, 7, 1199063798, 0, 0, 0 };

    static short[] shortArr = { 32767, 0, 0, -32768, 32767, 32767, 0, -14862, -17275, 0 };

    static int iFld = 0;

    int[] test(int[] intArr, short[] shortArr) {
        for (int j = 8; j < intArr.length; j++) {
            shortArr[10] = 10;
            shortArr[j] = 30;
            intArr[7] = 260;
            intArr[j - 1] = 400;
            iFld = intArr[j];
        }
        return intArr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13173().test(intArr, shortArr);
    }
}
