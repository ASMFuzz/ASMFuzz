public class MyJVMTest_8399 {

    static int k = 8;

    int howManyRule(int k) {
        switch(k) {
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("many");
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8399().howManyRule(k);
    }
}
