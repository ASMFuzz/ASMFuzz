import java.util.Arrays;

public class MyJVMTest_10470 {

    static String[] array = { "2=#Et42G:y", ".L>F8V_}E!", "1x;EgAd=if", "Nx?@AP'>'8", "l*x&%obcQ2", "$bYh>\"sn~e", "&t+59sywD2", "y\"rG*@*\\r ", "L_.<kF\"KAD", " t9PJpOCc3" };

    String[] reset(String[] array) {
        if (null == array) {
            array = new String[3];
        }
        array[0] = "1";
        array[1] = "2";
        array[2] = "3";
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10470().reset(array)));
    }
}
