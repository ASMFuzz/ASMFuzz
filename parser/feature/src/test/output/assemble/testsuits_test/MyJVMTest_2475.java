public class MyJVMTest_2475 {

    static String[] o = { "!YmG!*0ygd", ";OA t\\a~K^", "|G#<8U<4]Q", "ANw]2{d;xz", ":DBth'G$y/", "P$wjte1BNE", "qi(G*t6O-[", "Rw4y9w~!P8", "fA0rJZ./y7", "eRa<`vv`~a" };

    static int nonStaticPublicField = 6;

    int getLengthStatic(String[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2475().getLengthStatic(o));
    }
}
