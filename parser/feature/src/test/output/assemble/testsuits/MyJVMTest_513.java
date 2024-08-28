public class MyJVMTest_513 {

    static int lineFileID = 0;

    static boolean lineFileIDSet = false;

    int setLineFileID(int lineFileID) {
        if (lineFileID < 0)
            throw new IllegalArgumentException("" + lineFileID);
        this.lineFileID = lineFileID;
        this.lineFileIDSet = true;
        return lineFileID;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_513().setLineFileID(lineFileID);
    }
}
