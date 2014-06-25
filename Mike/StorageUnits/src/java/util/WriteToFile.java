package util;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;

/**
 *
 * @author Michael Fesser
 * @since 6/25/2014
 */
public class WriteToFile {

    private static Path filepath = Paths.get("c:\\test\\logs.txt");
    private static BufferedOutputStream output;
    private static BufferedWriter writer;

    public static void fileWrite(String login) throws IOException {
        try {
            // Initialize the objects to create the file.
            output = new BufferedOutputStream(Files.newOutputStream(filepath, CREATE));
            writer = new BufferedWriter(new OutputStreamWriter(output));
            // Write to the file the required number of lines.
            writer.write(login);
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException io) {
            System.out.println("The file could not be created");
            // Close the file even if the program has an exception.
        } finally {
            try {
                writer.close();
            } catch (IOException io) {
                System.out.println("Error closing the file");
            }
        }
    }
}
