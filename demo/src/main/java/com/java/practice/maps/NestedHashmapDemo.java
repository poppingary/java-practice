package com.java.practice.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Demonstrates how to use a nested HashMap (with a student name as key and another HashMap as value for
 * subject-score pairs) to find the highest scoring subject for each student.
 */
public class NestedHashmapDemo {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> studentScores = CreateNestedHashmap();

        for (Map.Entry<String, Map<String, Integer>> studentEntry : studentScores.entrySet()) {
            String studentName = studentEntry.getKey();
            Map<String, Integer> subjectScores = studentEntry.getValue();

            String highestSubject = "";
            int highestScore = -1;
            for (Map.Entry<String, Integer> subjectEntry : subjectScores.entrySet()) {
                String subject = subjectEntry.getKey();
                int score = subjectEntry.getValue();

                if (score > highestScore) {
                    highestScore = score;
                    highestSubject = subject;
                }
            }

            System.out.println(studentName + " - Highest Score: " + highestScore + " in " + highestSubject);
        }
    }

    private static Map<String, Map<String, Integer>> CreateNestedHashmap() {
        // Create a nested HashMap: student name -> (subject -> score)
        Map<String, Map<String, Integer>> studentScores = new HashMap<>();

        Map<String, Integer> scoresA = new HashMap<>();
        scoresA.put("Math", 85);
        scoresA.put("Science", 92);
        scoresA.put("History", 78);
        studentScores.put("Student A", scoresA);

        Map<String, Integer> scoresB = new HashMap<>();
        scoresB.put("Math", 88);
        scoresB.put("Science", 76);
        scoresB.put("History", 90);
        studentScores.put("Student B", scoresB);

        return studentScores;
    }
}