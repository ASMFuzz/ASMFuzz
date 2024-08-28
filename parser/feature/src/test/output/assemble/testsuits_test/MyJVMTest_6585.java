public class MyJVMTest_6585 {

    static T6348760<Character> i = null;

    static T6348760<Character> j = null;

    static T6348760<Boolean> a = null;

    static T value = null;

    static int n = 2;

    T6348760<Character> testCharacter(T6348760<Character> i, T6348760<Character> j, T6348760<Boolean> a) {
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
        new MyJVMTest_6585().testCharacter(i, j, a);
    }
}
