public class MyJVMTest_8249 {

    static short i = 0;

    short simpleb2(short i) {
        Short ib1 = Short.valueOf(i);
        Short ib2 = Short.valueOf((short) (i + 1));
        return (short) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8249().simpleb2(i));
    }
}
