public class MyJVMTest_4670 {

    static long[] o = { -1257576182448849088L, 0, 6765897059121629131L, -1190640213194325293L, 0, 0, 9223372036854775807L, -1536588661849506978L, -9223372036854775808L, 0 };

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 5;

    int getLength(long[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4670().getLength(o));
    }
}
