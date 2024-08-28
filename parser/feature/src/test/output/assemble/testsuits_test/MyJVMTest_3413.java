public class MyJVMTest_3413 {

    short remi_sumb2() {
        Short j1 = Short.valueOf((short) 1);
        Short j2 = Short.valueOf((short) 1);
        for (int i = 0; i < 1000; i++) {
            j1 = (short) (j1 + 1);
            j2 = (short) (j2 + 2);
        }
        return (short) (j1 + j2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3413().remi_sumb2());
    }
}
