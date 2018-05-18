package club.veev.plugin.happycoding;

public class Test {

    private Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello");
            synchronized (Test.this) {
                try {
                    Test.this.wait();
                } catch (InterruptedException e) {
                    System.out.println("World");
                }
            }
        }
    });

    private Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello");
            synchronized (Test.this) {
                try {
                    Test.this.wait();
                } catch (InterruptedException e) {
                    System.out.println("World");
                }
            }
        }
    });

    public static void main(String[] args) {
        Test test = new Test();
        test.t1.start();
        test.t2.start();
        Test.class.notifyAll();
    }
}
