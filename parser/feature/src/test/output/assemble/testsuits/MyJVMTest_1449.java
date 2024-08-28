public class MyJVMTest_1449 {

    static char[] ch = { Character.MIN_VALUE, Character.MAX_VALUE, '0', '0', Character.MIN_VALUE, '4', Character.MAX_VALUE, Character.MIN_VALUE, '0', 'j' };

    static int start = 8;

    static int length = -359285047;

    static StringBuffer currentValue = new StringBuffer();

    int characters(char[] ch, int start, int length) {
        currentValue.append(ch, start, length);
        return length;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1449().characters(ch, start, length);
    }
}
