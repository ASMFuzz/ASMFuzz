public class MyJVMTest_534 {

    static T6348760<Long> i = null;

    static T6348760<Long> j = null;

    static T6348760<Boolean> a = null;

    static T value = null;

    static int n = 1;

    T6348760<Long> testLong(T6348760<Long> i, T6348760<Long> j, T6348760<Boolean> a) {
        i.value++;
        i.value--;
        ++i.value;
        --i.value;
        i.value = +i.value;
        i.value = -i.value;
        i.value = ~i.value;
        i.value = i.value * j.value;
        i.value = i.value / j.value;
        i.value = i.value % j.value;
        i.value = i.value + j.value;
        i.value = i.value - j.value;
        i.value = i.value << j.value;
        i.value = i.value >> j.value;
        i.value = i.value >>> j.value;
        i.value = i.value & j.value;
        i.value = i.value ^ j.value;
        i.value = i.value | j.value;
        i.value *= j.value;
        i.value /= j.value;
        i.value %= j.value;
        i.value += j.value;
        i.value -= j.value;
        i.value <<= j.value;
        i.value >>= j.value;
        i.value >>>= j.value;
        i.value &= j.value;
        i.value ^= j.value;
        i.value |= j.value;
        a.value = i.value < j.value;
        a.value = i.value > j.value;
        a.value = i.value <= j.value;
        a.value = i.value >= j.value;
        a.value = i.value == j.value;
        a.value = i.value != j.value;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_534().testLong(i, j, a);
    }
}
