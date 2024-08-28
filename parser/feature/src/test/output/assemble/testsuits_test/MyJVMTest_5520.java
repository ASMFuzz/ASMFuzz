public class MyJVMTest_5520 {

    static Long ibc = new Long(1);

    long remi_sumc2() {
        Long j1 = ibc;
        Long j2 = Long.valueOf(1);
        for (int i = 0; i < 1000; i++) {
            j1 = j1 + ibc;
            j2 = j2 + 2;
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5520().remi_sumc2());
    }
}
