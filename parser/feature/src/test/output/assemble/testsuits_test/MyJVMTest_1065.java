public class MyJVMTest_1065 {

    static String[] args = { "!d<+\"%R^ZE", "e5U\"SRxnZO", "G|v!2(vnw(", ":]Z?ZX)<Gc", ".Ome0&(/v_", "1?#bvRbux=", ";;Al+.*!p#", "@gy!atwb%,", "S=.d$ #F1&", ";8~$#{).Ag" };

    static String keyword = "*I(3v>@GR_";

    static double start = 0.0;

    static double left = 0.7577861826526316;

    static double right = Double.NEGATIVE_INFINITY;

    static double area = Double.NEGATIVE_INFINITY;

    String keywordValue(String[] args, String keyword) {
        for (String arg : args) if (arg.startsWith(keyword))
            return arg.substring(keyword.length() + 1);
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1065().keywordValue(args, keyword));
    }
}
