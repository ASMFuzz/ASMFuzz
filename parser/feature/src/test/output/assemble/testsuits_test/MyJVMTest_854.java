public class MyJVMTest_854 {

    static int i = 1;

    static int j = 1;

    static String s1 = "Hi, ";

    static String s2 = "Hi, ";

    static int[] arr1 = new int[] { 1 };

    static int[] arr2 = new int[] { 1 };

    boolean test2() {
        (i) += (i) += 1;
        (j) += (j) += 1;
        (arr1[0]) += (arr1[0]) += 1;
        (arr2[0]) += (arr2[0]) += 1;
        (s1) += (s1) += "dude";
        (s2) += (s2) += "dude";
        return (i == j && i == 3 && arr1[0] == arr2[0] && arr2[0] == 3 && s1.equals(s2) && s1.endsWith("Hi, Hi, dude"));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_854().test2());
    }
}
