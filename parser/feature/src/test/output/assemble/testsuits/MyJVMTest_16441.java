import java.awt.Color;

public class MyJVMTest_16441 {

    static int numColors = 846867960;

    int getNumBits(int numColors) {
        if (numColors < 0 || 256 < numColors) {
            throw new RuntimeException("Unsupported number of colors: " + numColors);
        }
        int numBits = 1;
        int limit = 1 << numBits;
        while (numColors > limit) {
            numBits++;
            limit = 1 << numBits;
        }
        return numBits;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16441().getNumBits(numColors));
    }
}
