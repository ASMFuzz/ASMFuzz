public class MyJVMTest_8194 {

    static Long s = 9223372036854775807L;

    static Long ts = 9223372036854775807L;

    Long m(Long s, Long ts) {
        return 0L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8194().m(s, ts));
    }
}
