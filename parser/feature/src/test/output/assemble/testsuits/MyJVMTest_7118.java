public class MyJVMTest_7118 {

    static double v = Double.MIN_VALUE;

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
        new MyJVMTest_7118().setSpecial();
    }
}
