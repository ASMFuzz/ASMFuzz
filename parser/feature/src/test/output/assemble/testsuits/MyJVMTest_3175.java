public class MyJVMTest_3175 {

    static String s1 = "&QS+ZUJeL+";

    static String s2 = "v<|FAbiY_t";

    int stringCompareTo(String s1, String s2) {
        return s1.compareTo(s2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3175().stringCompareTo(s1, s2));
    }
}
