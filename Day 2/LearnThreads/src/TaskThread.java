public class TaskThread {
    public static void main(String[] args){
        Runnable obj1 = () ->
        {
            for(int i = 5; i >= 1; i--){
                System.out.println("" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable obj2 = () ->
        {
            for(int i = 0; i < 3; i++){
                System.out.println("Learning Threads in Java");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Main task running...");
        }

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("All threads finished.");


    }
}
