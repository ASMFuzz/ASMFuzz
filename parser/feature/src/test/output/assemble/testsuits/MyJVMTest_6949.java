public class MyJVMTest_6949 {

    static short i = 0;

    short simple2(short i) {
        Short ib1 = new Short(i);
        Short ib2 = new Short((short) (i + 1));
        return (short) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6949().simple2(i));
    }
}
