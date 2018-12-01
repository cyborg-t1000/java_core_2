package lesson3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

class Reader {
    private String file;
    private int pagesize;

    String getPage(int page) {
        try (RandomAccessFile raf = new RandomAccessFile(this.file, "r")) {
            byte[] bytes = new byte[pagesize];
            raf.seek(page * this.pagesize);
            raf.read(bytes);
            raf.close();
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    Reader(String file, int pagesize) {
        this.file = file;
        this.pagesize = 1800;
        this.pagesize = pagesize;
    }
}
