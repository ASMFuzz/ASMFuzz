public class MyJVMTest_11624 {

    static int[] a = { 215867302, 366973927, 3, 0, 0, 0, 8, -1120964713, 0, -1079905997 };

    static Integer ibc = new Integer(1);

    int sumc(int[] a) {
        Integer result = ibc;
        for (Integer i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11624().sumc(a));
    }
}
