public class MyJVMTest_3831 {

    static int[] intArr = { 9, 0, 1488332635, 8, 1, 0, 7, 4, 0, 0 };

    static short[] shortArr = { -32768, -32768, 0, 0, 0, -32768, 32767, 0, -32768, 32767 };

    static int iFld = -1486041221;

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
        new MyJVMTest_3831().test(intArr, shortArr);
    }
}
