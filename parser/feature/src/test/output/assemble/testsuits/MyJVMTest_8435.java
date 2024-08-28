public class MyJVMTest_8435 {

    static char[] ca = { 'V', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '4', '0', ']', '0', Character.MAX_VALUE };

    int _loadUS_signExt(char[] ca) {
        return (ca[0] << 16) >> 16;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8435()._loadUS_signExt(ca));
    }
}
