public class MyJVMTest_9561 {

    static char a = Character.MIN_VALUE;

    String concatChar(char a) {
        return new StringBuilder().append(a).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9561().concatChar(a));
    }
}
