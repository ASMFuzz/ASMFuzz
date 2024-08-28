public class MyJVMTest_1748 {

    static Long j = 0;

    long remi_sump(Long j) {
        for (int i = 0; i < 1000; i++) {
            j = new Long(j + 1);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1748().remi_sump(j));
    }
}
