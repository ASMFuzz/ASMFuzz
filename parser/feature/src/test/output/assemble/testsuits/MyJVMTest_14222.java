public class MyJVMTest_14222 {

    static T6348760<Byte> i = null;

    static T6348760<Byte> j = null;

    static T6348760<Boolean> a = null;

    static T value = null;

    static int n = 8;

    T6348760<Byte> testByte(T6348760<Byte> i, T6348760<Byte> j, T6348760<Boolean> a) {
        i.value++;
        i.value--;
        ++i.value;
        --i.value;
        n = +i.value;
        n = -i.value;
        n = ~i.value;
        n = i.value * j.value;
        n = i.value / j.value;
        n = i.value % j.value;
        n = i.value + j.value;
        n = i.value - j.value;
        n = i.value << j.value;
        n = i.value >> j.value;
        n = i.value >>> j.value;
        n = i.value & j.value;
        n = i.value ^ j.value;
        n = i.value | j.value;
        n *= j.value;
        n /= j.value;
        n %= j.value;
        n += j.value;
        n -= j.value;
        n <<= j.value;
        n >>= j.value;
        n >>>= j.value;
        n &= j.value;
        n ^= j.value;
        n |= j.value;
        a.value = i.value < j.value;
        a.value = i.value > j.value;
        a.value = i.value <= j.value;
        a.value = i.value >= j.value;
        a.value = i.value == j.value;
        a.value = i.value != j.value;
        return j;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14222().testByte(i, j, a);
    }
}
