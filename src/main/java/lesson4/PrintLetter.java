package lesson4;

public class PrintLetter {
    private final Object mon = new Object();
    private byte asciiCurrent;

    private PrintLetter() {
        this.asciiCurrent = 65;
    }

    public static void main(String[] args) {
        PrintLetter pl = new PrintLetter();
        Thread t1 = new Thread(() -> pl.printOne('A'));
        Thread t2 = new Thread(() -> pl.printOne('B'));
        Thread t3 = new Thread(() -> pl.printOne('C'));
        t1.start();
        t2.start();
        t3.start();
    }

    private void printOne(char letter) {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (this.asciiCurrent != (byte)letter) {
                        mon.wait();
                    }
                    System.out.println(letter);
                    if(++this.asciiCurrent > 67) this.asciiCurrent = 65;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}