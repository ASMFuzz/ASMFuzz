public class MyJVMTest_8798 {

    static char v = '0';

    static char value = '0';

    Character valueOf(char v) {
        return new Character(v);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8798().valueOf(v));
    }
}
