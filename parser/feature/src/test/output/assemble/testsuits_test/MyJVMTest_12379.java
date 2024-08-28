public class MyJVMTest_12379 {

    static String a = "lRn0uO1rZr";

    String concatString(String a) {
        return new StringBuilder().append(a).toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12379().concatString(a));
    }
}
