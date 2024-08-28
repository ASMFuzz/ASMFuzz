public class MyJVMTest_9751 {

    static Long s = -3025582379684294524L;

    static Long ts = 9223372036854775807L;

    Long m(Long s, Long ts) {
        return s + ts;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9751().m(s, ts));
    }
}
