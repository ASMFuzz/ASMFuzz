public class MyJVMTest_8595 {

    static Short ibc = new Short((short) 1);

    short remi_sumc() {
        Short j = ibc;
        for (int i = 0; i < 1000; i++) {
            j = (short) (j + ibc);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8595().remi_sumc());
    }
}
