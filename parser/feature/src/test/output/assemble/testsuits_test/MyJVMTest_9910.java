public class MyJVMTest_9910 {

    static int paletteSize = 0;

    static int w = 100;

    static int h = 100;

    int getNumBits(int paletteSize) {
        if (paletteSize < 0) {
            throw new IllegalArgumentException("negative palette size: " + paletteSize);
        }
        if (paletteSize < 2) {
            return 1;
        }
        int numBits = 0;
        paletteSize--;
        while (paletteSize > 0) {
            numBits++;
            paletteSize = paletteSize >> 1;
        }
        return numBits;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9910().getNumBits(paletteSize));
    }
}
