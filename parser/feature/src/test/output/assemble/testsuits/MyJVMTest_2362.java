public class MyJVMTest_2362 {

    static int[] a = { 4, 0, 7, 9, 3, 0, 1, 8, 7, 3 };

    static Integer ibc = new Integer(1);

    int sumc(int[] a) {
        Integer result = ibc;
        for (Integer i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2362().sumc(a));
    }
}
