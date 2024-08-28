public class MyJVMTest_5061 {

    static double[][] value = {{0.4004351100246192,Double.POSITIVE_INFINITY,0d,Double.NaN,Double.POSITIVE_INFINITY,Double.MAX_VALUE,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,0.9284936070810993,Double.POSITIVE_INFINITY},{Double.NaN,0d,0d,0d,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,0d,Double.NaN,Double.MIN_VALUE}};

    static double[][] result = {{0.8101305748868781,Double.MIN_VALUE,Double.MAX_VALUE,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,0d,Double.NEGATIVE_INFINITY,Double.MAX_VALUE,Double.NEGATIVE_INFINITY,Double.MAX_VALUE},{0d,Double.NEGATIVE_INFINITY,Double.MAX_VALUE,Double.NEGATIVE_INFINITY,Double.MIN_VALUE,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.MIN_VALUE,Double.POSITIVE_INFINITY,0.3121601704174449}};

    static double[][] source = {{Double.MIN_VALUE,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.NaN,Double.NaN,Double.NEGATIVE_INFINITY,Double.NaN,0.2770275544410079,0d,Double.MIN_VALUE},{Double.POSITIVE_INFINITY,Double.MIN_VALUE,0d,Double.MAX_VALUE,0.44104964571770533,0d,Double.NaN,Double.MAX_VALUE,0d,Double.NEGATIVE_INFINITY}};

    static int line0 = 0;

    static int bunch = 0;

    int size() {
        return value.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5061().size());
    }
}
