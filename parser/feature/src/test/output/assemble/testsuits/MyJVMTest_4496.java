public class MyJVMTest_4496 {

    static byte[] inputArray = { -20, -79, -100, -94, -21, -118, 55, 81, 115, -124 };

    static byte[][] outputArray = { { -109, 3, 113, -39, -36, -98, 0, 111, -17, 61 }, { 69, 5, -106, 117, -108, -4, 89, -115, 68, 78 } };

    byte[] getPermutations(byte[] inputArray, byte[][] outputArray) {
        int[] indexes = new int[] { 0, 2 };
        for (int a = 0; a < a + 16; a++) {
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
        new MyJVMTest_4496().getPermutations(inputArray, outputArray);
    }
}
