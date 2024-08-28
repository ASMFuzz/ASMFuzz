public class MyJVMTest_7492 {

    int returnOne() {
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            counter++;
        }
        for (int k = 0; k < 5; k++) {
            counter--;
        }
        return counter;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7492().returnOne());
    }
}
