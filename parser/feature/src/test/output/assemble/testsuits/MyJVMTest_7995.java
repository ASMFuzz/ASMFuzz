public class MyJVMTest_7995 {

    static T6348760<Double> i = null;

    static T6348760<Double> j = null;

    static T6348760<Boolean> a = null;

    static T value = null;

    static int n = 3;

    T6348760<Double> testDouble(T6348760<Double> i, T6348760<Double> j, T6348760<Boolean> a) {
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
        new MyJVMTest_7995().testDouble(i, j, a);
    }
}
