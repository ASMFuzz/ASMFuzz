public class MyJVMTest_7343 {

    static String a = "WH~(2')s#M";

    static String stringSmallL = "abc";

    String indexOfConstL(String a) {
        int result = a.indexOf(stringSmallL);
        return a.substring(result, result + stringSmallL.length());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7343().indexOfConstL(a));
    }
}
