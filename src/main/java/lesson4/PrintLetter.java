package lesson4;

public class PrintLetter {
    private final Object mon = new Object();
    private byte asciiCurrent;

    private PrintLetter() {
        this.asciiCurrent = 65;
    }

    public static void main(String[] args) {
        PrintLetter pl = new PrintLetter();
        byte ascii = 65;
        for (int i = 0; i < 3; i++) {
            byte finalAscii = ascii;
            Thread t = new Thread(() -> pl.printOne(finalAscii));
            t.start();
            ascii++;
        }
    }

    private void printOne(byte letter) {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (this.asciiCurrent != letter) {
                        mon.wait();
                    }
                    System.out.println((char)letter);
                    if(++this.asciiCurrent > 67) this.asciiCurrent = 65;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}