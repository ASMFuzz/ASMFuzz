public class MyJVMTest_8254 {

    long remi_summ2() {
        Long j1 = new Long(1);
        Long j2 = Long.valueOf(1);
        for (int i = 0; i < 1000; i++) {
            j1 = new Long(j1 + 1);
            j2 = j2 + 2;
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8254().remi_summ2());
    }
}
