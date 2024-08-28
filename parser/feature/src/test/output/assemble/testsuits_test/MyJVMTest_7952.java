public class MyJVMTest_7952 {

    static String s = "u5Y\"\"a_p[F";

    static String[] a = { "EX/IM3Dn4w", "Eb!r.(W%NM", "M|X|OeOV,Y", "d{=_C)/>ge", "E<Uol.zIS-", "<1=3/YYb<^", "0azr9,c4d0", "t8Q,=Bmn++", "'I;cVGvI6[", "F5 )=+%=sQ" };

    boolean isPresent(String s, String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
            if (s.equals(a[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7952().isPresent(s, a));
    }
}
