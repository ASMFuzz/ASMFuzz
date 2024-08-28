public class MyJVMTest_6771 {

    static short[] a = { -32768, 0, 32767, 0, 32767, 0, 2431, -6673, -32768, 8680 };

    static Short result = 32767;

    short sump(short[] a, Short result) {
        for (Short i : a) result = (short) (result + i);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6771().sump(a, result));
    }
}
