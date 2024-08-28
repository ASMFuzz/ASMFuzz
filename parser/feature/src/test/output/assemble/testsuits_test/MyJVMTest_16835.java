public class MyJVMTest_16835 {

    static String[] o = { "Ua5a{Dm~,w", "{1rw{WBL9C", "i)p(22>k;?", "'DPk) ~j_C", "A[tY;H~Ra;", "O[&IIx<J-F", "KLfwGD\"\";l", "5'_o<V^fVu", "Bz1mU)xUct", "U>6O!*(gz," };

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 6;

    int getLengthStatic(String[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16835().getLengthStatic(o));
    }
}
