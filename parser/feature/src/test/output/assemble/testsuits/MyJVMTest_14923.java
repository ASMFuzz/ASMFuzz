public class MyJVMTest_14923 {

    short remi_sum2() {
        Short j1 = new Short((short) 1);
        Short j2 = new Short((short) 1);
        for (int i = 0; i < 1000; i++) {
            j1 = new Short((short) (j1 + 1));
            j2 = new Short((short) (j2 + 2));
        }
        return (short) (j1 + j2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14923().remi_sum2());
    }
}
