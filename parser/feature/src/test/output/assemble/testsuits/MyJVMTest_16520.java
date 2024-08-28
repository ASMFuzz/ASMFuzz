public class MyJVMTest_16520 {

    static int a = 0;

    static int b = 8;

    long l(int[] a) {
        long m = 0;
        for (int i = 0; i < a.length; i++) m = a[i];
        return m;
    }

    static int h = 2;

    float j(int a, int b) {
        double d = 0.19881;
        int c, e[] = new int[9];
        c = 1;
        while (++c < 12) switch((c % 7 * 5) + 122) {
            case 156:
            case 46128:
            case 135:
            case 148:
            case 127:
                break;
            default:
        }
        while ((d += 2) < 62) ;
        long k = l(e);
        return k;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16520().j(a, b));
    }
}
