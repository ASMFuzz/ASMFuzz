public class MyJVMTest_15669 {

    static String[] o = { "|0+{bS2:f%", "16vX={PWjg", "m7]dxn'TvG", "WNW>LY>V/@", "-{?3z58.(u", "G^^QJh<T2h", "1ir,.{omjt", "{*ZQ21-7y*", "=CrCaoP%t>", "$+Mi-_iSR}" };

    static int nonStaticPublicField = 7;

    static int nonStaticFinalPublicField = 1;

    int getLength(String[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15669().getLength(o));
    }
}
