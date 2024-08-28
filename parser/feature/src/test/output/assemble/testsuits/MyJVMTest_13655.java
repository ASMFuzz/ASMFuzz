public class MyJVMTest_13655 {

    int remi_sumb() {
        Integer j = Integer.valueOf(1);
        for (int i = 0; i < 1000; i++) {
            j = j + 1;
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13655().remi_sumb());
    }
}
