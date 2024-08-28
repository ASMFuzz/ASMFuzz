public class MyJVMTest_2635 {

    static float v = Float.POSITIVE_INFINITY;

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
        new MyJVMTest_2635().setSpecial();
    }
}
