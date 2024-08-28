import java.util.Arrays;

public class MyJVMTest_85 {

    static Object[][] data = { { 672955378, 2, 8, 9, 0, 1, 0, 7, 0, 3 }, { 1, 6, 7, 778316757, 193162852, 9, 4, 3, 6, 7 } };

    static char L = '\u200E';

    byte[] getLevels(Object[][] data) {
        int levelLength = data[0].length;
        byte[] array = new byte[levelLength];
        int textIndex = 0;
        for (int i = 0; i < levelLength; i++) {
            array[i] = (byte) (((String) data[1][0]).charAt(textIndex) - '0');
            textIndex += ((String) data[0][i]).length();
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_85().getLevels(data)));
    }
}
