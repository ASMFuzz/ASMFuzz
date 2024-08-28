public class MyJVMTest_1626 {

    static short[] a = { 32767, 0, 0, 32767, -26625, 0, -32768, -32768, -12858, 0 };

    short summ2(short[] a) {
        Short result1 = 1;
        Short result2 = new Short((short) 1);
        for (Short i : a) {
            result1 = (short) (result1 + i);
            result2 = (short) (result2 + new Short((short) (i + 1)));
        }
        return (short) (result1 + result2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1626().summ2(a));
    }
}
