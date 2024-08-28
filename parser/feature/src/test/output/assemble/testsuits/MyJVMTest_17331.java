public class MyJVMTest_17331 {

    static char[] o = { '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 'G', Character.MAX_VALUE, '0', 'c', '0' };

    static int nonStaticPublicField = 6;

    static int nonStaticFinalPublicField = 0;

    int getLength(char[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17331().getLength(o));
    }
}
