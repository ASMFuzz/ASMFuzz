public class MyJVMTest_16812 {

    int remi_sum2() {
        Integer j1 = new Integer(1);
        Integer j2 = new Integer(1);
        for (int i = 0; i < 1000; i++) {
            j1 = new Integer(j1 + 1);
            j2 = new Integer(j2 + 2);
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16812().remi_sum2());
    }
}
