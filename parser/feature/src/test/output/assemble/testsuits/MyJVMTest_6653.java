import javax.imageio.ImageReadParam;

public class MyJVMTest_6653 {

    static int minPass = 7;

    static int numPasses = 0;

    boolean checkForIAE(int minPass, int numPasses) {
        ImageReadParam param = new ImageReadParam();
        boolean gotIAE = false;
        try {
            param.setSourceProgressivePasses(minPass, numPasses);
        } catch (IllegalArgumentException iae) {
            gotIAE = true;
        }
        if (!gotIAE) {
            throw new RuntimeException("Failed to get IAE for wraparound!");
        }
        return gotIAE;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6653().checkForIAE(minPass, numPasses);
    }
}
