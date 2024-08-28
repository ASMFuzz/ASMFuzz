public class MyJVMTest_8085 {

    static int[] a = { 8, 4, 5, 9, 1, -1071146038, 0, 0, 2, 556326689 };

    int sumb(int[] a) {
        Integer result = 1;
        for (Integer i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8085().sumb(a));
    }
}
