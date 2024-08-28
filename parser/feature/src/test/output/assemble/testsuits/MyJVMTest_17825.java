public class MyJVMTest_17825 {

    static short i = -5236;

    short simpleb2(short i) {
        Short ib1 = Short.valueOf(i);
        Short ib2 = Short.valueOf((short) (i + 1));
        return (short) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17825().simpleb2(i));
    }
}
