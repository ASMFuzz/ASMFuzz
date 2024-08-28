public class MyJVMTest_15849 {

    static Short j = 32767;

    short remi_sump(Short j) {
        for (int i = 0; i < 1000; i++) {
            j = new Short((short) (j + 1));
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15849().remi_sump(j));
    }
}
