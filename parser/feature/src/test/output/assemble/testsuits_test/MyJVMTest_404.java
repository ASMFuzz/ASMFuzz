public class MyJVMTest_404 {

    static char a = 'j';

    String concatChar(char a) {
        return new StringBuilder().append(a).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_404().concatChar(a));
    }
}
