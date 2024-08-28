public class MyJVMTest_17982 {

    static int k = 1;

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
        new MyJVMTest_17982().howManyRule(k);
    }
}
