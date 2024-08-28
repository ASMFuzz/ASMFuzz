public class MyJVMTest_453 {

    long remi_sumb2() {
        Long j1 = Long.valueOf(1);
        Long j2 = Long.valueOf(1);
        for (int i = 0; i < 1000; i++) {
            j1 = j1 + 1;
            j2 = j2 + 2;
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_453().remi_sumb2());
    }
}
