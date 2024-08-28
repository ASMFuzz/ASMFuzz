public class MyJVMTest_6501 {

    static int i = 0;

    static int[] data = {0,0,1,-845837490,8,-1480840319,1266295967,-2090550980,-2047875608,9};

    static int size = -2092200339;

    boolean filter(int i) {
        return ((i & 0b101) == 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6501().filter(i));
    }
}
