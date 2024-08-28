public class MyJVMTest_1912 {

    static T6348760<Float> i = null;

    static T6348760<Float> j = null;

    static T6348760<Boolean> a = null;

    static T value = null;

    static int n = 0;

    T6348760<Float> testFloat(T6348760<Float> i, T6348760<Float> j, T6348760<Boolean> a) {
        i.value++;
        i.value--;
        ++i.value;
        --i.value;
        i.value = +i.value;
        i.value = -i.value;
        i.value = i.value * j.value;
        i.value = i.value / j.value;
        i.value = i.value % j.value;
        i.value = i.value + j.value;
        i.value = i.value - j.value;
        i.value *= j.value;
        i.value /= j.value;
        i.value %= j.value;
        i.value += j.value;
        i.value -= j.value;
        a.value = i.value < j.value;
        a.value = i.value > j.value;
        a.value = i.value <= j.value;
        a.value = i.value >= j.value;
        a.value = i.value == j.value;
        a.value = i.value != j.value;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1912().testFloat(i, j, a);
    }
}
