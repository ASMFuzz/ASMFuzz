public class MyJVMTest_17640 {

    static int a = -722794815;

    String concatInt(int a) {
        return new StringBuilder().append(a).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17640().concatInt(a));
    }
}
