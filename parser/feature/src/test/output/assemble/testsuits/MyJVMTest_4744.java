import java.util.Arrays;

public class MyJVMTest_4744 {

    static int i = 1;

    static int[] ids = {368278581,5,7,8,-1854117753,8,-473379528,6,1,-903255179};

    boolean complyWith(int i) {
        return Arrays.stream(ids).anyMatch(j -> j == i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4744().complyWith(i));
    }
}
