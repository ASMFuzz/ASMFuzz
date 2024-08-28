public class MyJVMTest_8071 {

    static int a = -2043794607;

    String concatInt(int a) {
        return new StringBuilder().append(a).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8071().concatInt(a));
    }
}
