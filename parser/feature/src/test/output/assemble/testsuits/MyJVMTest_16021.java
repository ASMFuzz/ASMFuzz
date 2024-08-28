public class MyJVMTest_16021 {

    static char v = '0';

    static char value = Character.MAX_VALUE;

    Character valueOf(char v) {
        return new Character(v);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16021().valueOf(v));
    }
}
