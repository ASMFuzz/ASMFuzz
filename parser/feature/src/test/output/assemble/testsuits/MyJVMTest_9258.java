public class MyJVMTest_9258 {

    static int cp = 1010819425;

    static int EXTEND = 4;

    static int RI = 5;

    static int PREPEND = 6;

    static int SPACINGMARK = 7;

    static int L = 8;

    static int V = 9;

    static int T = 10;

    static int LV = 11;

    static int LVT = 12;

    static int FIRST_TYPE = 0;

    static int LAST_TYPE = 12;

    static boolean[][] rules = {{true,false,true,false,false,true,true,false,false,false},{false,false,true,true,true,false,false,false,true,false}};

    boolean isExcludedSpacingMark(int cp) {
        return cp == 0x102B || cp == 0x102C || cp == 0x1038 || cp >= 0x1062 && cp <= 0x1064 || cp >= 0x1062 && cp <= 0x106D || cp == 0x1083 || cp >= 0x1087 && cp <= 0x108C || cp == 0x108F || cp >= 0x109A && cp <= 0x109C || cp == 0x1A61 || cp == 0x1A63 || cp == 0x1A64 || cp == 0xAA7B || cp == 0xAA7D;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9258().isExcludedSpacingMark(cp));
    }
}
