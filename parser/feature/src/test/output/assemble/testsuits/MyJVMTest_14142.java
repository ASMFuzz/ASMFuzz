import java.util.Arrays;

public class MyJVMTest_14142 {

    static int i = 6;

    static int[] ids = {8,4,6,-7374808,1814621697,0,4,0,6,0};

    boolean complyWith(int i) {
        return Arrays.stream(ids).anyMatch(j -> j == i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14142().complyWith(i));
    }
}
