package util;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael Fesser
 * @since 6/25/2014
 */
public class WriteToFile {

    private static Path filepath = Paths.get("d:\\test\\logs.txt");
    private static BufferedOutputStream output;
    private static BufferedWriter writer;
    private static boolean writerOpen;

    public static void fileWrite(String login) {
        try {          
            // Initialize the objects to create the file.
            output = new BufferedOutputStream(Files.newOutputStream(filepath, CREATE, APPEND));
            writer = new BufferedWriter(new OutputStreamWriter(output));
            // Write to the file the required number of lines.
            writerOpen = true;
            writer.write(login);
            writer.newLine();
            writer.flush();
            writer.close();
            writerOpen = false;
        } catch (IOException io) {
            Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, null, io);
            System.out.println("The file could not be created");
            // Close the file even if the program has an exception.
        } finally {
            try {
                if (writerOpen == true) {
                    writer.close();
                }
            } catch (IOException io) {
                Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, null, io);
                System.out.println("Error closing the file");
            }
        }
    }
}
