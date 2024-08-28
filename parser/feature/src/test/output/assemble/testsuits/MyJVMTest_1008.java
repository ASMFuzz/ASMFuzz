public class MyJVMTest_1008 {

    static T6348760<Integer> i = null;

    static T6348760<Integer> j = null;

    static T6348760<Boolean> a = null;

    static T value = null;

    static int n = 1332232523;

    T6348760<Integer> testInteger(T6348760<Integer> i, T6348760<Integer> j, T6348760<Boolean> a) {
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
        new MyJVMTest_1008().testInteger(i, j, a);
    }
}
