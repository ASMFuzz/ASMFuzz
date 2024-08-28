public class MyJVMTest_7864 {

    static int k = 3;

    int howManyGroup(int k) {
        switch(k) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("many");
                break;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7864().howManyGroup(k);
    }
}
