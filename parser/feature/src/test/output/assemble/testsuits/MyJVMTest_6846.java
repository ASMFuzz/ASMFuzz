public class MyJVMTest_6846 {

    static String garbageProducer1Id = "0FN+^D+/om";

    String setGarbageProducer1Id(String garbageProducer1Id) {
        this.garbageProducer1Id = garbageProducer1Id;
        return garbageProducer1Id;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6846().setGarbageProducer1Id(garbageProducer1Id);
    }
}
