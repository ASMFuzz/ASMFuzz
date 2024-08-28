public class MyJVMTest_6889 {

    int remi_sumb2() {
        Integer j1 = Integer.valueOf(1);
        Integer j2 = Integer.valueOf(1);
        for (int i = 0; i < 1000; i++) {
            j1 = j1 + 1;
            j2 = j2 + 2;
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6889().remi_sumb2());
    }
}
