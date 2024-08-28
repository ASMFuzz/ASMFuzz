public class MyJVMTest_12491 {

    static String s1 = "%fk6Tya&f.";

    static String s2 = "C,_4xy7&Q,";

    int stringCompareTo(String s1, String s2) {
        return s1.compareTo(s2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12491().stringCompareTo(s1, s2));
    }
}
