public class MyJVMTest_8709 {

    static byte[] inputArray = { 57, -29, -121, -45, -23, -59, 30, -85, 18, -18 };

    static byte[][] outputArray = { { -117, -121, 71, -44, 99, 62, -107, -24, -92, 115 }, { 78, 119, 50, 22, -9, -125, -96, -33, -109, 41 } };

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
        new MyJVMTest_8709().getPermutations(inputArray, outputArray);
    }
}
