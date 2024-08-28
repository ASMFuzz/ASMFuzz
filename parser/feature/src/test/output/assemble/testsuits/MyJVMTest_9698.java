public class MyJVMTest_9698 {

    static T6348760<Long> i = null;

    static T6348760<Long> j = null;

    static T6348760<Boolean> a = null;

    static T value = null;

    static int n = 0;

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
        new MyJVMTest_9698().testLong(i, j, a);
    }
}
