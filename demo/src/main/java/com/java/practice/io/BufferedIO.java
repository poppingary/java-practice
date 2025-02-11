package com.java.practice.io;

import com.java.practice.dbconfig.ConnectionPooling;

import javax.sql.DataSource;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class BufferedIO {
    public static void main(String[] args) {
        ConnectionPooling connectionPooling = new ConnectionPooling();
        var dataSource = connectionPooling.getDataSource();

        // CSV output file
        String csvFile = "products_bufferedio.csv";

        // Query to select all data from product table
        String sql = "SELECT * FROM product";

        long start = System.currentTimeMillis();
        getAllProducts(dataSource, sql, csvFile);
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");
    }

    private static void getAllProducts(DataSource dataSource, String sql, String csvFile) {
        final int BUFFER_SIZE = 64 * 1024;
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile), BUFFER_SIZE)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Write CSV header (column names)
            writer.write(metaData.getColumnLabel(1));
            for (int i = 2; i <= columnCount; i++) {
                writer.write(",");
                writer.write(metaData.getColumnLabel(i));
            }
            writer.newLine();

            // Write data rows
            while (rs.next()) {
                String value = rs.getString(1);
                writer.write(value != null ? value : "");
                for (int i = 2; i <= columnCount; i++) {
                    value = rs.getString(i);
                    writer.write(",");
                    writer.write(value != null ? value : "");
                }
                writer.newLine();
            }
            System.out.println("CSV file exported: " + csvFile);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}