public class MyJVMTest_4297 {

    static char[] ca = { Character.MAX_VALUE, 'C', '0', '0', '+', Character.MIN_VALUE, 'O', Character.MIN_VALUE, Character.MAX_VALUE, '0' };

    int loadUS_signExt_1(char[] ca) {
        return (ca[0] << 16) >> 16;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4297().loadUS_signExt_1(ca));
    }
}
