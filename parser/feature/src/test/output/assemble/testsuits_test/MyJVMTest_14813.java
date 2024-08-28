public class MyJVMTest_14813 {

    static short i = 0;

    static Short ibc = new Short((short) 1);

    short simplec2(short i) {
        Short ib1 = ibc;
        Short ib2 = Short.valueOf((short) (i + 1));
        return (short) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14813().simplec2(i));
    }
}
