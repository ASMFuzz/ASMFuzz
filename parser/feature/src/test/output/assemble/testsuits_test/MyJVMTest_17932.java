public class MyJVMTest_17932 {

    long remi_sum2() {
        Long j1 = new Long(1);
        Long j2 = new Long(1);
        for (int i = 0; i < 1000; i++) {
            j1 = new Long(j1 + 1);
            j2 = new Long(j2 + 2);
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17932().remi_sum2());
    }
}
