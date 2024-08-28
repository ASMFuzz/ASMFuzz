public class MyJVMTest_16091 {

    static boolean store = false;

    static Test7103261 null_value = null;

    static Test7103261 nonnull_value = new Test7103261();

    static Test7103261 nonnull_value2 = new Test7103261();

    static long l = 0;

    static int i = 0;

    static float f = 0.34118038f;

    static double d = Double.NaN;

    static byte b = 127;

    static char c = Character.MIN_VALUE;

    static short s = 32767;

    static boolean z = true;

    boolean valueTest(boolean store) {
        for (int field = 0; field < 8; field++) {
            try {
                Test7103261 o = nonnull_value;
                Test7103261 o2 = nonnull_value2;
                for (int i = 0; i < 100000; i++) {
                    switch(field) {
                        case 0:
                            o.l = o2.l;
                            break;
                        case 1:
                            o.i = o2.i;
                            break;
                        case 2:
                            o.f = o2.f;
                            break;
                        case 3:
                            o.d = o2.d;
                            break;
                        case 4:
                            o.b = o2.b;
                            break;
                        case 5:
                            o.c = o2.c;
                            break;
                        case 6:
                            o.s = o2.s;
                            break;
                        case 7:
                            o.z = o2.z;
                            break;
                        default:
                            throw new InternalError();
                    }
                    if (i == 90000) {
                        if (store)
                            o = null_value;
                        else
                            o2 = null_value;
                    }
                }
            } catch (NullPointerException npe) {
            }
        }
        return store;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16091().valueTest(store);
    }
}
