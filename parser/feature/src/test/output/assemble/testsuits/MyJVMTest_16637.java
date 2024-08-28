public class MyJVMTest_16637 {

    static double v = Double.POSITIVE_INFINITY;

    void setSpecial() {
        switch((int) (Math.random() * 3)) {
            case 0:
                v = Double.NaN;
                break;
            case 1:
                v = Double.POSITIVE_INFINITY;
                break;
            case 2:
                v = Double.NEGATIVE_INFINITY;
                break;
            default:
                throw new InternalError();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16637().setSpecial();
    }
}
