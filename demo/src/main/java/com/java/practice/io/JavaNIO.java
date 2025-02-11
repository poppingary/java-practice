package com.java.practice.io;

import com.java.practice.dbconfig.ConnectionPooling;

import javax.sql.DataSource;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaNIO {
    public static void main(String[] args) {
        // Assume ConnectionPooling is a class that provides a configured DataSource
        ConnectionPooling connectionPooling = new ConnectionPooling();
        DataSource dataSource = connectionPooling.getDataSource();

        // CSV output file and SQL query
        String csvFile = "products_nio.csv";
        String sql = "SELECT * FROM product";

        long start = System.currentTimeMillis();
        exportProducts(dataSource, sql, csvFile);
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");
    }

    private static void exportProducts(DataSource dataSource, String sql, String csvFile) {
        // Set a large buffer size (256 KB in this example)
        final int BUFFER_SIZE = 256 * 1024;
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             FileChannel fileChannel = FileChannel.open(Path.of(csvFile),
                     StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {

            // Allocate a reusable ByteBuffer
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Build and write the header row
            StringBuilder header = new StringBuilder();
            header.append(metaData.getColumnLabel(1));
            for (int i = 2; i <= columnCount; i++) {
                header.append(",").append(metaData.getColumnLabel(i));
            }
            header.append("\n");
            writeToBuffer(buffer, header.toString(), fileChannel);

            // Process and write each row
            while (rs.next()) {
                StringBuilder row = new StringBuilder();
                // Process first column
                String value = rs.getString(1);
                row.append(value != null ? value : "");
                // Process remaining columns
                for (int i = 2; i <= columnCount; i++) {
                    row.append(",");
                    value = rs.getString(i);
                    // If the value contains commas, quotes, or newlines, escape it according to CSV rules.
                    if (value != null && (value.contains(",") || value.contains("\"") || value.contains("\n"))) {
                        value = value.replace("\"", "\"\"");
                        row.append("\"").append(value).append("\"");
                    } else {
                        row.append(value != null ? value : "");
                    }
                }
                row.append("\n");
                writeToBuffer(buffer, row.toString(), fileChannel);
            }
            // Flush any remaining data in the buffer to the file channel.
            flushBuffer(buffer, fileChannel);
            System.out.println("CSV export completed: " + csvFile);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes a string (converted to UTF-8 bytes) into the provided ByteBuffer.
     * If the buffer does not have enough remaining space, it is flushed to the file channel.
     */
    private static void writeToBuffer(ByteBuffer buffer, String data, FileChannel fileChannel) throws IOException {
        byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
        if (buffer.remaining() < bytes.length) {
            flushBuffer(buffer, fileChannel);
        }
        buffer.put(bytes);
    }

    /**
     * Flips the buffer, writes its contents to the file channel, and then clears it.
     */
    private static void flushBuffer(ByteBuffer buffer, FileChannel fileChannel) throws IOException {
        buffer.flip();
        while (buffer.hasRemaining()) {
            fileChannel.write(buffer);
        }
        buffer.clear();
    }
}