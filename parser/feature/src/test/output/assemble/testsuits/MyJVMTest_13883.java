public class MyJVMTest_13883 {

    static byte[] inputArray = { 98, -96, -60, -85, 63, -104, 107, 23, -35, 114 };

    static byte[][] outputArray = { { 39, -102, -30, -66, 29, -49, -49, -1, -30, 124 }, { 97, 22, -117, -60, -76, -55, 36, 26, 16, 59 } };

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
        new MyJVMTest_13883().getPermutations(inputArray, outputArray);
    }
}
