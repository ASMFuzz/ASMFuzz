public class MyJVMTest_2969 {

    static short[] a = { 32767, 32767, -32768, 32767, 4093, 0, -32768, -32768, -32768, 32767 };

    short sum(short[] a) {
        short result = 1;
        for (Short i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2969().sum(a));
    }
}
