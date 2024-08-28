public class MyJVMTest_1254 {

    int remi_summ2() {
        Integer j1 = new Integer(1);
        Integer j2 = Integer.valueOf(1);
        for (int i = 0; i < 1000; i++) {
            j1 = new Integer(j1 + 1);
            j2 = j2 + 2;
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1254().remi_summ2());
    }
}
