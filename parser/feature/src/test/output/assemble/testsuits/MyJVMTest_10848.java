public class MyJVMTest_10848 {

    static short[] a = { -19717, -6868, 32767, 0, -13859, 32767, -32768, 8436, 0, -32768 };

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
        System.out.println(new MyJVMTest_10848().summ2(a));
    }
}
