public class MyJVMTest_6529 {

    static char v = 'B';

    static char value = '0';

    Character valueOf(char v) {
        return new Character(v);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6529().valueOf(v));
    }
}
