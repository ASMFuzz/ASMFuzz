public class MyJVMTest_18021 {

    static char[] ca = { '1', Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    int _loadUS_signExt(char[] ca) {
        return (ca[0] << 16) >> 16;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18021()._loadUS_signExt(ca));
    }
}
