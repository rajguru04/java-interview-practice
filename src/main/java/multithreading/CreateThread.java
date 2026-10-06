package multithreading;

public class CreateThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i=1;i<=100;i++) {
                System.out.println("Created Thread name: " + Thread.currentThread().getName()+"-"+i);
            }
        });
        Thread t2 = new Thread(() -> {
           for(int i=101; i<=200;i++){
               System.out.println("Created Thread name: " + Thread.currentThread().getName()+"-"+i);
           }
        });
        t1.start();
        t2.start();
        System.out.println("main thread name : "+Thread.currentThread().getName());
    }
}
