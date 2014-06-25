package util;

import business.OrderRecord;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.CREATE;

/**
 *
 * @author Ian Mori
 * @since May 13, 2014
 */
public class FileUtility {

    static final int RECORD_SIZE = createStringFormat().length();

    //Moved the method over here to clean up the code, Ian Mori@May14,2014
    public static String createStringFormat() {
        final String USER_ID_FORMAT = "00000";
        final String ORDER_ID_FORMAT = "00000";
        final String PRODUCT_ID_FORMAT = "00000";
        final String ORDER_LINE_ID_FORMAT = "00000";
        final String QUANTITY_ORDERED_FORMAT = "00000";
        final String SALE_PRICE_FORMAT = "0000.00";
        String delimiter = ",";
        String record = ORDER_LINE_ID_FORMAT + delimiter + ORDER_ID_FORMAT + delimiter
                + USER_ID_FORMAT + delimiter + PRODUCT_ID_FORMAT + delimiter + QUANTITY_ORDERED_FORMAT
                + delimiter + SALE_PRICE_FORMAT + System.getProperty("line.separator");
        return record;
    }

    //Moved the method over here to clean up the code, Ian Mori@May14,2014
    public static void createFileIfDoesntExist(Path orderFile, String record) {
        try {
            String path = "C:" + File.separator + "completedOrders" + File.separator + "orders.txt";
            File f = new File(path);
            f.getParentFile().mkdirs();
            f.createNewFile();
            createEmptyFile(orderFile, record);
        } catch (IOException io) {
            System.out.println("Error: " + io);
        }
    }

    //Creating the blank default file, Ian Mori@May14,2014
    public static void createEmptyFile(Path file, String s) {
        final int NUM_RECS = 1000;
        try {
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

            for (int i = 0; i < NUM_RECS; ++i) {
                writer.write(s, 0, s.length());
            }
            writer.close();
        } catch (IOException io) {
            System.out.println("Error: " + io);
        }
    }

    //Will save each record to a txt file by random access, one by one, Ian Mori@May14,2014
    public static void saveRecord(OrderRecord ord, FileChannel fc) {
        try {

            System.out.println("here i am saving to file, this is orderlineId" + ord.getOrderLineId());
            String record = ord.getStringRecord();
            byte[] data = record.getBytes();
            ByteBuffer bbuffer = ByteBuffer.wrap(data);
            fc.position(ord.getOrderLineId() * RECORD_SIZE);
            fc.write(bbuffer);
           
        } catch (IOException io) {
            System.out.println("Error: " + io);
        }
    }
}
