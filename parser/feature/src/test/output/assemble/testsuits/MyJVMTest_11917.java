public class MyJVMTest_11917 {

    static float v = 0.43425554f;

    void setSpecial() {
        switch((int) (Math.random() * 3)) {
            case 0:
                v = Float.NaN;
                break;
            case 1:
                v = Float.POSITIVE_INFINITY;
                break;
            case 2:
                v = Float.NEGATIVE_INFINITY;
                break;
            default:
                throw new InternalError();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11917().setSpecial();
    }
}
