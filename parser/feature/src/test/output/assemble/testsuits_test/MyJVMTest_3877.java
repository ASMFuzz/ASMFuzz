public class MyJVMTest_3877 {

    long remi_sum() {
        Long j = new Long(1);
        for (int i = 0; i < 1000; i++) {
            j = new Long(j + 1);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3877().remi_sum());
    }
}
