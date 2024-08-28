public class MyJVMTest_16351 {

    static String garbageProducer1Id = "\"H+K;(0eG{";

    String setGarbageProducer1Id(String garbageProducer1Id) {
        this.garbageProducer1Id = garbageProducer1Id;
        return garbageProducer1Id;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16351().setGarbageProducer1Id(garbageProducer1Id);
    }
}
