public class MyJVMTest_4101 {

    short remi_sum() {
        Short j = new Short((short) 1);
        for (int i = 0; i < 1000; i++) {
            j = new Short((short) (j + 1));
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4101().remi_sum());
    }
}
