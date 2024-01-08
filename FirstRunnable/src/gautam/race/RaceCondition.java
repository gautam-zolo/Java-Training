package gautam.race;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException{
        LongWrapper longWrapper = new LongWrapper(0);

        Runnable r = () -> {
            for(int i=0; i<1000; i++){
                longWrapper.incrementValue();
            }
        };

        Thread[] threads = new Thread[1000];
        for(int i = 0; i< threads.length; i++){
            threads[i] = new Thread(r);
            threads[i].start();
        }
        
        for(Thread t: threads)
            t.join();

        System.out.println("Value = "+ longWrapper.getValue());
    }
}
