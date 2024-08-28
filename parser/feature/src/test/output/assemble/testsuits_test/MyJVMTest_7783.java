public class MyJVMTest_7783 {

    static Integer ibc = new Integer(1);

    int remi_sumc2() {
        Integer j1 = ibc;
        Integer j2 = Integer.valueOf(1);
        for (int i = 0; i < 1000; i++) {
            j1 = j1 + ibc;
            j2 = j2 + 2;
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7783().remi_sumc2());
    }
}
