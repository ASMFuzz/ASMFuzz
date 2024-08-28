public class MyJVMTest_11743 {

    static String[] o = { "E''x$bFu1=", "]&?KfeC,}h", "Dd:@~7w1k!", "U|*%OZE=cN", "K{8t&k%eXo", "[Dap7lOy5.", "=DOplX7@T6", "`e@0$}n5S=", "9\\>,xak+*Z", "[0rPFFMeI " };

    static int nonStaticPublicField = 4;

    int getLengthStatic(String[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11743().getLengthStatic(o));
    }
}
