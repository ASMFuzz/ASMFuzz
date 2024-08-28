import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_10729 {

    static int[] aParam1 = { 0, -925202116, 0, 3, -1379970582, 7, 5, 0, 6, 7 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 1846492079, 0, 0, 261635858, -313184130, 602016747, -70183548, 1543547198, 9, 9 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_cp(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.set(i, b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10729().test_cp(a, b);
    }
}
