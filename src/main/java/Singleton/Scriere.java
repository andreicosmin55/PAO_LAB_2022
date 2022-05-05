package Singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class Scriere {
    private static Scriere instance = null;

    static BufferedWriter writer = null;

    private Scriere(){}

    public static Scriere getInstance() throws IOException {
        if (instance == null) {
            instance = new Scriere();

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            writer = new BufferedWriter(new FileWriter("src/main/resources/Audits/audit.txt"));
        }
        return instance;
    }

    public void ScrieAudit(String actiune) throws IOException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        writer.write( actiune + ", " + timestamp.toString() + "\n");


    }

    public void close() throws IOException {
        writer.close();
    }
}
