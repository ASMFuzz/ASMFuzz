import java.awt.image.BandedSampleModel;
import java.awt.image.DataBuffer;

public class MyJVMTest_7064 {

    static int TEST_NUM_BANDS = 3;

    static int TEST_SRC_IMG_DIM = 10;

    static BandedSampleModel singleBankModel = null;

    static BandedSampleModel multiBankModel = null;

    void initTest() {
        int[] bandOffsets = new int[TEST_NUM_BANDS];
        int[] bankIndices = new int[TEST_NUM_BANDS];
        bandOffsets[0] = 0;
        bandOffsets[1] = 120;
        bandOffsets[2] = 240;
        bankIndices[0] = 0;
        bankIndices[1] = 0;
        bankIndices[2] = 0;
        singleBankModel = new BandedSampleModel(DataBuffer.TYPE_BYTE, TEST_SRC_IMG_DIM, TEST_SRC_IMG_DIM, TEST_SRC_IMG_DIM, bankIndices, bandOffsets);
        bandOffsets[0] = 0;
        bandOffsets[1] = 20;
        bandOffsets[2] = 40;
        bankIndices[0] = 0;
        bankIndices[1] = 1;
        bankIndices[2] = 2;
        multiBankModel = new BandedSampleModel(DataBuffer.TYPE_BYTE, TEST_SRC_IMG_DIM, TEST_SRC_IMG_DIM, TEST_SRC_IMG_DIM, bankIndices, bandOffsets);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7064().initTest();
    }
}
