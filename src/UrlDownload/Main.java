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
            //isr liest characters von einem byte stream
            InputStreamReader isr = new InputStreamReader(myUrl.openStream());
            //zeilenweise auslesen
            BufferedReader br = new BufferedReader(isr);
            //neue file objekte erstellen
            File file= new File("content.html");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String one_line;
            //jede zeile von website -> auf content.html
            while((one_line = br.readLine()) !=null) {
                printWriter.println(one_line); //println - neue zeile
//                System.out.println(one_line);
            }
            br.close();
            //schließen das file
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            //fangen wir exceptions und geben wir aus
            throw new RuntimeException(e);
        }
    }

}