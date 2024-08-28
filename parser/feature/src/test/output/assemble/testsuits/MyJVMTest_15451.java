public class MyJVMTest_15451 {

    static String parent = "D\\a==9_0V-";

    static String child = "egh!%NU+D3";

    static String info = "obvz={$\"=T";

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
        System.out.println(new MyJVMTest_15451().Test(parent, child, info));
    }
}
