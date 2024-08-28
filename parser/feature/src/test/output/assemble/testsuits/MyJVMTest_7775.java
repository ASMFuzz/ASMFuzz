public class MyJVMTest_7775 {

    static char[] o = { Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, 'k', '-', Character.MAX_VALUE, Character.MAX_VALUE, '0', '0', '&' };

    static int nonStaticPublicField = 2;

    static int nonStaticFinalPublicField = 0;

    int getLength(char[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7775().getLength(o));
    }
}
