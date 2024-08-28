public class MyJVMTest_841 {

    static int d = -436336874;

    boolean isZero(int d) {
        switch(d) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_841().isZero(d));
    }
}
