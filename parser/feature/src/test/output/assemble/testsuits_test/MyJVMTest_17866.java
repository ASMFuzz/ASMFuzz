public class MyJVMTest_17866 {

    static double d1 = Double.MAX_VALUE;

    double checkSum(double[] a) {
        double sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += (a[j] / (j + 1) + a[j] % (j + 1));
        }
        return sum;
    }

    static int N = 400;

    static long instanceCount = -2288355609708559532L;

    int iMeth(double d1) {
        int i4 = 6022, i5 = -211, i6 = -15841, iArr[] = new int[N];
        double d2 = -8.78129, dArr[] = new double[N];
        i5 = 1;
        do {
            i6 = 1;
            while (++i6 < 5) {
                i4 = -933;
                i4 *= i4;
                dArr[i5 + 1] = i4;
                i4 -= i4;
                d2 = 1;
                do {
                    iArr[(int) (d2 + 1)] += (int) instanceCount;
                    try {
                        i4 = (i4 % -51430);
                        i4 = (iArr[i6] % 31311);
                        iArr[i6 + 1] = (24197 / i5);
                    } catch (ArithmeticException a_e) {
                    }
                    i4 -= (int) instanceCount;
                    i4 <<= i5;
                    i4 &= 12;
                } while (++d2 < 1);
            }
        } while (++i5 < 320);
        long meth_res = Double.doubleToLongBits(checkSum(dArr));
        return (int) meth_res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17866().iMeth(d1));
    }
}
