public class MyJVMTest_12792 {

    static char[] ca = { Character.MIN_VALUE, '}', '0', Character.MIN_VALUE, '0', 's', 'v', Character.MAX_VALUE, '8', '0' };

    int loadUS_signExt(char[] ca) {
        return (ca[0] << 16) >> 16;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12792().loadUS_signExt(ca));
    }
}
