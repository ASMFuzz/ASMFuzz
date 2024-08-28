public class MyJVMTest_17161 {

    static String a = "^Y>T#ZHx>C";

    static String stringSmallL = "abc";

    String indexOfConstUL(String a) {
        int result = a.indexOf(stringSmallL);
        return a.substring(result, result + stringSmallL.length());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17161().indexOfConstUL(a));
    }
}
