public class MyJVMTest_6377 {

    static T6348760<Boolean> i = null;

    static T6348760<Boolean> j = null;

    static T6348760<Boolean> a = null;

    static T value = null;

    static int n = 0;

    T6348760<Boolean> testBoolean(T6348760<Boolean> i, T6348760<Boolean> j, T6348760<Boolean> a) {
        i.value = i.value & j.value;
        i.value = i.value ^ j.value;
        i.value = i.value | j.value;
        i.value &= j.value;
        i.value ^= j.value;
        i.value |= j.value;
        a.value = i.value == j.value;
        a.value = i.value != j.value;
        a.value = !j.value;
        a.value = i.value && j.value;
        a.value = i.value || j.value;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6377().testBoolean(i, j, a);
    }
}
