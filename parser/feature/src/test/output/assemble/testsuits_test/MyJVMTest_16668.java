public class MyJVMTest_16668 {

    static Long ibc = new Long(1);

    long remi_sumc() {
        Long j = ibc;
        for (int i = 0; i < 1000; i++) {
            j = j + ibc;
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16668().remi_sumc());
    }
}
