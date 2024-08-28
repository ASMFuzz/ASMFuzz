public class MyJVMTest_14200 {

    static int i = 1;

    static float halfUlp = Float.NEGATIVE_INFINITY;

    float strictValue(int i) {
        float r;
        switch(i % 4) {
            case 0:
                r = -Float.MAX_VALUE;
                break;
            case 1:
                r = Float.MAX_VALUE;
                break;
            case 2:
                r = Float.MIN_VALUE;
                break;
            default:
                r = 1L << 24;
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14200().strictValue(i));
    }
}
