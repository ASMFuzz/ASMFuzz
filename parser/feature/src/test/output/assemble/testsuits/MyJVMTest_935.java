public class MyJVMTest_935 {

    String testDiv_un_opt() {
        int ia, ib;
        long lc, ld;
        double de, df;
        System.out.println("testDiv_un_opt:");
        ia = ib = 513;
        if (1 != ia / ib)
            return "case 1 failed";
        ia = -ia;
        if (-1 != ia / ib)
            return "case 2 failed";
        ia = ib = 1073741824;
        if (1 != ia / ib)
            return "case 3 failed";
        ia = -ia;
        if (-1 != ia / ib)
            return "case 4 failed";
        lc = ld = 8L;
        if (1 != lc / ld)
            return "case 5 failed";
        lc = -lc;
        if (-1 != lc / ld)
            return "case 6 failed";
        lc = ld = 1073741824L;
        if (1 != lc / ld)
            return "case 7 failed";
        lc = -lc;
        if (-1 != lc / ld)
            return "case 8 failed";
        ib = 0;
        try {
            ia = ia / ib;
            return "case 9 failed";
        } catch (java.lang.Exception x) {
        }
        ld = 0;
        try {
            lc = lc / ld;
            return "case 10 failed";
        } catch (java.lang.Exception x) {
        }
        try {
            lc = lc % ld;
            return "case 11 failed";
        } catch (java.lang.Exception x) {
        }
        de = df = 16385.0;
        if (1.0 != de / df)
            return "case 12 failed";
        de = -de;
        if (-1.0 != de / df)
            return "case 13 failed";
        df = 0.0;
        try {
            de = de / df;
        } catch (java.lang.Exception x) {
            return "case 14 failed";
        }
        try {
            de = de % df;
            de = 5.66666666666 % df;
        } catch (java.lang.Exception x) {
            return "case 15 failed";
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_935().testDiv_un_opt());
    }
}
