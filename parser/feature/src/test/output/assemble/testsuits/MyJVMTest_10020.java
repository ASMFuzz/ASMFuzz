public class MyJVMTest_10020 {

    static int d = 24223868;

    boolean isZero(int d) {
        switch(d) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10020().isZero(d));
    }
}
