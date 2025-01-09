package com.java.practice.threads;

public class Join {
    public static void main(String[] args) {
        // Simulated shared resource for file content
        StringBuffer sharedData = new StringBuffer();

        // File Reading Thread
        Thread fileReader = new Thread(() -> {
            try {
                System.out.println("File Reader: Reading file...");
                Thread.sleep(2000);
                sharedData.append("File content read successfully.");
                System.out.println("File Reader: File reading completed.");
            } catch (InterruptedException e) {
                System.out.println("File Reader: " + e.getMessage());
            }
        });

        // Data Processing Thread
        Thread dataProcessor = new Thread(() -> {
            try {
                System.out.println("Data Processor: Waiting for file data...");
                Thread.sleep(3000);
                sharedData.append(" Processed data.");
                System.out.println("Data Processor: Data processing completed.");
            } catch (InterruptedException e) {
                System.out.println("Data Processor: " + e.getMessage());
            }
        });

        // Start threads
        fileReader.start();
        dataProcessor.start();

        try {
            System.out.println("Main Thread: Waiting for file reading to complete...");
            fileReader.join(); // Wait for fileReader to finish

            System.out.println("Main Thread: Waiting for data processing to complete...");
            dataProcessor.join(); // Wait for dataProcessor to finish
        } catch (InterruptedException e) {
            System.out.println("Main Thread: " + e.getMessage());
        }

        // Combining results after both threads complete
        System.out.println("Main Thread: Combining results...");
        System.out.println("Final Result: " + sharedData);
    }
}