public class MyJVMTest_17425 {

    static int k = 8;

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
        new MyJVMTest_17425().howManyGroup(k);
    }
}
