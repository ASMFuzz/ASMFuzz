public class MyJVMTest_12767 {

    void testPatternEntry() throws Exception {
        PatternEntry fred = new PatternEntry(1, new StringBuffer("hello"), new StringBuffer("up"));
        PatternEntry barney = new PatternEntry(1, new StringBuffer("hello"), new StringBuffer("down"));
        PatternEntry homer = new PatternEntry(1, new StringBuffer("goodbye"), new StringBuffer("up"));
        if (fred.equals(barney)) {
            System.out.println("fred.equals(barney)");
        } else {
            System.out.println("!fred.equals(barney)");
        }
        System.out.println("fred.hashCode() == " + fred.hashCode());
        System.out.println("barney.hashCode() == " + barney.hashCode());
        if (!fred.equals(barney)) {
            throw new Exception("equals() failed on two hashtables that are equal");
        }
        if (fred.hashCode() != barney.hashCode()) {
            throw new Exception("hashCode() failed on two hashtables that are equal");
        }
        System.out.println();
        if (fred.equals(homer)) {
            System.out.println("fred.equals(homer)");
        } else {
            System.out.println("!fred.equals(homer)");
        }
        System.out.println("fred.hashCode() == " + fred.hashCode());
        System.out.println("homer.hashCode() == " + homer.hashCode());
        if (fred.equals(homer)) {
            throw new Exception("equals() failed on two hashtables that are not equal");
        }
        if (fred.hashCode() == homer.hashCode()) {
            throw new Exception("hashCode() failed on two hashtables that are not equal");
        }
        System.out.println();
        System.out.println("testPatternEntry() passed.\n");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12767().testPatternEntry();
    }
}
