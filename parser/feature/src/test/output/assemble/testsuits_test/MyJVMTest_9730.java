public class MyJVMTest_9730 {

    static Test7103261 null_value = null;

    static Test7103261 nonnull_value = new Test7103261();

    static long l = 9223372036854775807L;

    static int i = 2022259324;

    static float f = Float.POSITIVE_INFINITY;

    static double d = Double.NaN;

    static byte b = 0;

    static char c = '!';

    static short s = 2263;

    static boolean z = false;

    void constantStore() {
        for (int field = 0; field < 8; field++) {
            try {
                Test7103261 o = nonnull_value;
                for (int i = 0; i < 100000; i++) {
                    switch(field) {
                        case 0:
                            o.l = 0;
                            break;
                        case 1:
                            o.i = 0;
                            break;
                        case 2:
                            o.f = 0;
                            break;
                        case 3:
                            o.d = 0;
                            break;
                        case 4:
                            o.b = 0;
                            break;
                        case 5:
                            o.c = 0;
                            break;
                        case 6:
                            o.s = 0;
                            break;
                        case 7:
                            o.z = false;
                            break;
                        default:
                            throw new InternalError();
                    }
                    if (i == 90000) {
                        o = null_value;
                    }
                }
            } catch (NullPointerException npe) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9730().constantStore();
    }
}
