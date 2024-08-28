public class MyJVMTest_14444 {

    static Long j1 = -9223372036854775808L;

    long remi_sump2(Long j1) {
        Long j2 = Long.valueOf(1);
        for (int i = 0; i < 1000; i++) {
            j1 = new Long(j1 + 1);
            j2 = j2 + 2;
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14444().remi_sump2(j1));
    }
}
