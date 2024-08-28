public class MyJVMTest_10971 {

    static Long j = -2219398999264942298L;

    long remi_sump(Long j) {
        for (int i = 0; i < 1000; i++) {
            j = new Long(j + 1);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10971().remi_sump(j));
    }
}
