public class MyJVMTest_5923 {

    int remi_sum() {
        Integer j = new Integer(1);
        for (int i = 0; i < 1000; i++) {
            j = new Integer(j + 1);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5923().remi_sum());
    }
}
