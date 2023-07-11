package UrlDownload;

import java.io.*;
import java.net.URL;

public class Main {

    //Dieses Projekt lädt die Daten der URL https://de.wikipedia.org/wiki/Objektorientierte_Programmierung
    //und gibt alle Zeilen in die Datei „content.html“ aus. Die Zeilen der Datei „content.html“ haben
    //die für Windows üblichen Zeilenumbrüche (nehmen Sie die integrierte Funktion
    // um die Zeilenumbrüche zu realisieren)
    public static void main(String[] args) {
        try {
            System.out.println("Main starting up...");
            //URL auslesen
            URL myUrl = new URL("https://de.wikipedia.org/wiki/Objektorientierte_Programmierung");
            InputStreamReader isr = new InputStreamReader(myUrl.openStream());
            BufferedReader br = new BufferedReader(isr);
            File file= new File("content.html");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String one_line;
            //jede zeile von website -> auf konsole
            while((one_line = br.readLine()) !=null) {
                printWriter.println(one_line);
//                System.out.println(one_line);
            }
            br.close();
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}