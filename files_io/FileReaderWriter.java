import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Character Streams
 * ------------
 * Character streams are used to perform input and output for 16-bit unicode. most
 * frequently used classes are
 *  FileReader
 *  FileWriter
 * 
 */
public class FileReaderWriter {
  public static void main(String args[]) throws IOException {
    if (args.length != 2) {
      System.out.println("Need two args");
      System.exit(0);
    }

    FileReader in = null;
    FileWriter out = null;
    try {
      in = new FileReader(args[0]);
      out = new FileWriter(args[1]);
      int c;
      while ((c = in.read()) != -1) {
        out.write(c);
      }
    } finally {
      if (in != null) in.close();
      if (out != null) out.close();
    }
  }
}
