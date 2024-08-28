public class MyJVMTest_13668 {

    static char[] ca = { Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '3', '0', '0' };

    int loadUS_signExt_1(char[] ca) {
        return (ca[0] << 16) >> 16;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13668().loadUS_signExt_1(ca));
    }
}
