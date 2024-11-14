package com.example;

public class Main {
    public static void main(String[] args) {
        // Launch the graphical user interface (GUI) version of the quiz
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create and display the QuestionService GUI (quiz)
                new QuestionService().setVisible(true);
            }
        });
    }
}
