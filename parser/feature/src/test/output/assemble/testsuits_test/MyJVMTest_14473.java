public class MyJVMTest_14473 {

    static double[][] value = {{Double.MIN_VALUE,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,Double.MAX_VALUE,0d,0.424599939984008,Double.MAX_VALUE,Double.POSITIVE_INFINITY,0d,0.1601881636250807},{Double.NEGATIVE_INFINITY,Double.NaN,Double.MAX_VALUE,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,0d,0.9105809855713042,0.43194650245103006,Double.MIN_VALUE,Double.NEGATIVE_INFINITY}};

    static double[][] result = {{Double.NaN,Double.MAX_VALUE,0d,Double.MIN_VALUE,Double.MIN_VALUE,Double.POSITIVE_INFINITY,Double.MAX_VALUE,Double.MAX_VALUE,Double.MIN_VALUE,0d},{Double.NaN,Double.MIN_VALUE,Double.MIN_VALUE,Double.NEGATIVE_INFINITY,Double.MIN_VALUE,Double.NEGATIVE_INFINITY,Double.NaN,Double.MAX_VALUE,Double.NEGATIVE_INFINITY,0d}};

    static double[][] source = {{Double.NEGATIVE_INFINITY,Double.NaN,0.02893689513997688,Double.MAX_VALUE,Double.MIN_VALUE,Double.MAX_VALUE,Double.NaN,Double.MIN_VALUE,Double.NaN,Double.NEGATIVE_INFINITY},{Double.MAX_VALUE,0.6534644008351673,Double.NaN,Double.NEGATIVE_INFINITY,0.5269147536161082,Double.POSITIVE_INFINITY,0.7805741000080595,Double.POSITIVE_INFINITY,0.7211944670857995,Double.NaN}};

    static int line0 = -836002049;

    static int bunch = 3;

    int size() {
        return value.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14473().size());
    }
}
