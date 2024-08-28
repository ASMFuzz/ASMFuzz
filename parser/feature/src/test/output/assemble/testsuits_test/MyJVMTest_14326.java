public class MyJVMTest_14326 {

    static T6348760<Short> i = null;

    static T6348760<Short> j = null;

    static T6348760<Boolean> a = null;

    static T value = null;

    static int n = 0;

    T6348760<Short> testShort(T6348760<Short> i, T6348760<Short> j, T6348760<Boolean> a) {
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
        new MyJVMTest_14326().testShort(i, j, a);
    }
}
