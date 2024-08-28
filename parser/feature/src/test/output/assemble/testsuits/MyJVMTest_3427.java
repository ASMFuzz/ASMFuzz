public class MyJVMTest_3427 {

    static byte[] inputArray = { -48, -83, -114, -52, -58, -38, 80, 99, 74, 34 };

    static byte[][] outputArray = { { 110, -6, -127, -74, 106, -84, 40, 3, -104, 106 }, { 59, -36, -93, -17, -125, 87, 20, 56, -63, 14 } };

    byte[] getPermutations(byte[] inputArray, byte[][] outputArray) {
        int[] indexes = new int[] { 0, 2 };
        for (int a = 0; a < inputArray.length; a++) {
            int oneIdx = indexes[0]++;
            for (int b = a + 1; b < inputArray.length; b++) {
                int twoIdx = indexes[1]++;
                outputArray[twoIdx][0] = inputArray[a];
                outputArray[twoIdx][1] = inputArray[b];
            }
        }
        return inputArray;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3427().getPermutations(inputArray, outputArray);
    }
}
