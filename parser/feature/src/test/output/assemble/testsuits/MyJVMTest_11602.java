public class MyJVMTest_11602 {

    static String x = "_?#%'hVXa}";

    static String y = "K.a$<OZSa|";

    int compare(String x, String y) {
        return (x == null ? -1 : y == null ? 1 : x.compareTo(y));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11602().compare(x, y));
    }
}
