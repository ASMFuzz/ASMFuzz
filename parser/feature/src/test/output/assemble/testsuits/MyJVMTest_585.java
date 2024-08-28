public class MyJVMTest_585 {

    static Long s = 9223372036854775807L;

    static Long ts = -8450640800110033652L;

    Long m(Long s, Long ts) {
        return s + ts;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_585().m(s, ts));
    }
}
