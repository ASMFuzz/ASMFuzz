public class MyJVMTest_11031 {

    static String[] o = { "GwP0]n*B]I", "0?.i\"QQ]Q0", "0f=jd5L*]\\", "8h8N;,M>`p", "[2y;T)@~<K", "=2E/fZ=N#d", "WMnC\\L&3^=", "u6}ek:\\[lF", "XzD}RZTCa6", ".RdD%JKpD:" };

    static int nonStaticPublicField = 7;

    int getLength(String[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11031().getLength(o));
    }
}
