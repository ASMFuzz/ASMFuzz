public class MyJVMTest_3461 {

    static char[] ca = { Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0', '%', Character.MAX_VALUE, '+', '0' };

    int loadUS_signExt(char[] ca) {
        return (ca[0] << 16) >> 16;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3461().loadUS_signExt(ca));
    }
}
