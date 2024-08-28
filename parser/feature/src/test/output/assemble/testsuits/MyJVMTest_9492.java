public class MyJVMTest_9492 {

    static String x = "8k]L0H|Q{p";

    static String y = "u(@uLvC0)t";

    String add(String x, String y) {
        return x + y;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9492().add(x, y));
    }
}
