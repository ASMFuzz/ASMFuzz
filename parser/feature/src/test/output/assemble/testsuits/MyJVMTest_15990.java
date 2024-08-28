public class MyJVMTest_15990 {

    static int i = 0;

    static int[] data = {5,0,0,0,1694634826,0,0,1703850816,0,0};

    static int size = 0;

    boolean filter(int i) {
        return ((i & 0b101) == 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15990().filter(i));
    }
}
