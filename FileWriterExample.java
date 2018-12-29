import java.io.*;

public class FileWriterExample {
    public static void main (String[] args) {
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            // attaching node stream with data source
            // if file does not exist, it automatically creates it
            fw = new FileWriter ("D:\\output.txt");

            // attatching filter stream over node stream
            pw = new PrintWriter(fw);

            String s1 = "Hello World";
            String s2 = "Web Design and Development";

            // writing first string to file
            pw.println(s1);

            // writing second string to file
            pw.println(s2);

            // flushing stream
            pw.flush();

        } catch(IOException ex) {
            System.out.println(ex);

        } finally {
            // closing streams
            pw.close();
            fw.close();
        }
    }
}
