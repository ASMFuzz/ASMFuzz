public class MyJVMTest_5898 {

    static double x = Double.NEGATIVE_INFINITY;

    static double y = Double.POSITIVE_INFINITY;

    int __HI(double x) {
        long transducer = Double.doubleToRawLongBits(x);
        return (int) (transducer >> 32);
    }

    double __HI(double x, int high) {
        long transX = Double.doubleToRawLongBits(x);
        return Double.longBitsToDouble((transX & 0x0000_0000_FFFF_FFFFL) | (((long) high)) << 32);
    }

    int __LO(double x) {
        long transducer = Double.doubleToRawLongBits(x);
        return (int) transducer;
    }

    static double D = -7.05306122448979611050e-01;

    static double E = 1.41428571428571436819e+00;

    static double F = 1.60714285714285720630e+00;

    double compute(double x, double y) {
        double a = x;
        double b = y;
        double t1, t2, y1, y2, w;
        int j, k, ha, hb;
        ha = __HI(x) & 0x7fffffff;
        hb = __HI(y) & 0x7fffffff;
        if (hb > ha) {
            a = y;
            b = x;
            j = ha;
            ha = hb;
            hb = j;
        } else {
            a = x;
            b = y;
        }
        a = __HI(a, ha);
        b = __HI(b, hb);
        if ((ha - hb) > 0x3c00000) {
            return a + b;
        }
        k = 0;
        if (ha > 0x5f300000) {
            if (ha >= 0x7ff00000) {
                w = a + b;
                if (((ha & 0xfffff) | __LO(a)) == 0)
                    w = a;
                if (((hb ^ 0x7ff00000) | __LO(b)) == 0)
                    w = b;
                return w;
            }
            ha -= 0x25800000;
            hb -= 0x25800000;
            k += 600;
            a = __HI(a, ha);
            b = __HI(b, hb);
        }
        if (hb < 0x20b00000) {
            if (hb <= 0x000fffff) {
                if ((hb | (__LO(b))) == 0)
                    return a;
                t1 = 0;
                t1 = __HI(t1, 0x7fd00000);
                b *= t1;
                a *= t1;
                k -= 1022;
            } else {
                ha += 0x25800000;
                hb += 0x25800000;
                k -= 600;
                a = __HI(a, ha);
                b = __HI(b, hb);
            }
        }
        w = a - b;
        if (w > b) {
            t1 = 0;
            t1 = __HI(t1, ha);
            t2 = a - t1;
            w = Math.sqrt(t1 * t1 - (b * (-b) - t2 * (a + t1)));
        } else {
            a = a + a;
            y1 = 0;
            y1 = __HI(y1, hb);
            y2 = b - y1;
            t1 = 0;
            t1 = __HI(t1, ha + 0x00100000);
            t2 = a - t1;
            w = Math.sqrt(t1 * y1 - (w * (-w) - (t1 * y2 + t2 * b)));
        }
        if (k != 0) {
            t1 = 1.0;
            int t1_hi = __HI(t1);
            t1_hi += (k << 20);
            t1 = __HI(t1, t1_hi);
            return t1 * w;
        } else
            return w;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5898().compute(x, y));
    }
}
