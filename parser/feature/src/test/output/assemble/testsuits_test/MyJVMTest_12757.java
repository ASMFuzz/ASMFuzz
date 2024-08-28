public class MyJVMTest_12757 {

    static byte[] inputArray = { 69, 12, -109, -21, -27, 11, -59, 15, 110, -112 };

    static byte[][] outputArray = { { -29, -25, 109, -122, -11, -20, -19, -25, 74, 38 }, { 49, 115, -71, 73, 66, -100, -91, -70, 56, -91 } };

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
        new MyJVMTest_12757().getPermutations(inputArray, outputArray);
    }
}
