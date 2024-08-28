import java.util.Arrays;

public class MyJVMTest_9228 {

    static Object[][] data = { { 0, 3, 0, 0, 0, 875860709, 1259212014, 4, 0, 1 }, { 0, 5, 2, 5, 1003983631, 5, -575658309, 1, 0, 531948513 } };

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
        System.out.println(Arrays.asList(new MyJVMTest_9228().getLevels(data)));
    }
}
