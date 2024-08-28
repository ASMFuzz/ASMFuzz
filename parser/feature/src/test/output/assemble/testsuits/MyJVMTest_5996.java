public class MyJVMTest_5996 {

    static String parent = "BVdF?JhiSr";

    static String child = "h2J!2/[1~o";

    static String info = "JK1n{QZZ}.";

    boolean Test(String parent, String child, String info) {
        boolean retval = true;
        if (!parent.equals(child)) {
            System.out.println("Error translation for " + info + " in TCH: " + parent);
            System.out.println("Which should be: " + child);
            retval = false;
        }
        return retval;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5996().Test(parent, child, info));
    }
}
