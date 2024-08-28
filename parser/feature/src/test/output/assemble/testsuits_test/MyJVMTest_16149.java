import javax.imageio.ImageReadParam;

public class MyJVMTest_16149 {

    static int minPass = 0;

    static int numPasses = -1385629192;

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
        new MyJVMTest_16149().checkForIAE(minPass, numPasses);
    }
}
