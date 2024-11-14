package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionService extends JFrame {
        private Question[] questions = new Question[5];
        private String[] selection = new String[5];
        private int currentQuestionIndex = 0;
        private JLabel questionLabel;
        private JRadioButton option1, option2, option3, option4;
        private ButtonGroup optionsGroup;
        private JButton nextButton;

        public QuestionService() {
                // Initialize the questions
                questions[0] = new Question(1, "What is the name of the player character?", "Ashen One",
                                "Cursed undead", "Tarnished", "The hollow", "Tarnished");
                questions[1] = new Question(2, "What is the name of the player character?", "Ashen One",
                                "Cursed undead", "Tarnished", "The hollow", "Tarnished");
                questions[2] = new Question(3, "What is the name of the player character?", "Ashen One",
                                "Cursed undead", "Tarnished", "The hollow", "Tarnished");
                questions[3] = new Question(4, "What is the name of the player character?", "Ashen One",
                                "Cursed undead", "Tarnished", "The hollow", "Tarnished");
                questions[4] = new Question(5, "What is the name of the player character?", "Ashen One",
                                "Cursed undead", "Tarnished", "The hollow", "Tarnished");

                // Initialize GUI components
                setupGUI();
                displayQuestion(currentQuestionIndex);
        }

        private void setupGUI() {
                // Basic JFrame setup
                setTitle("Quiz Game");
                setSize(500, 400);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
                setLayout(new BorderLayout());

                // Question label
                questionLabel = new JLabel("", JLabel.CENTER);
                questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
                add(questionLabel, BorderLayout.NORTH);

                // Radio buttons for options
                JPanel optionsPanel = new JPanel();
                optionsPanel.setLayout(new GridLayout(4, 1));

                option1 = new JRadioButton();
                option2 = new JRadioButton();
                option3 = new JRadioButton();
                option4 = new JRadioButton();

                optionsGroup = new ButtonGroup();
                optionsGroup.add(option1);
                optionsGroup.add(option2);
                optionsGroup.add(option3);
                optionsGroup.add(option4);

                optionsPanel.add(option1);
                optionsPanel.add(option2);
                optionsPanel.add(option3);
                optionsPanel.add(option4);

                add(optionsPanel, BorderLayout.CENTER);

                // Next button to proceed to next question
                nextButton = new JButton("Next");
                nextButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String selectedOption = getSelectedOption();
                                if (selectedOption != null) {
                                        selection[currentQuestionIndex] = selectedOption;
                                        currentQuestionIndex++;
                                        if (currentQuestionIndex < questions.length) {
                                                displayQuestion(currentQuestionIndex);
                                        } else {
                                                displayScore();
                                        }
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "Please select an answer before proceeding.");
                                }
                        }
                });
                add(nextButton, BorderLayout.SOUTH);
        }

        private void displayQuestion(int index) {
                Question q = questions[index];
                questionLabel.setText(q.getQuestion());
                option1.setText(q.getOption1());
                option2.setText(q.getOption2());
                option3.setText(q.getOption3());
                option4.setText(q.getOption4());

                // Clear previous selections
                optionsGroup.clearSelection();
        }

        private String getSelectedOption() {
                if (option1.isSelected())
                        return option1.getText();
                if (option2.isSelected())
                        return option2.getText();
                if (option3.isSelected())
                        return option3.getText();
                if (option4.isSelected())
                        return option4.getText();
                return null;
        }

        private void displayScore() {
                int score = 0;
                for (int i = 0; i < questions.length; i++) {
                        Question q = questions[i];
                        String actualAnswer = q.getAnswer();
                        String userAnswer = selection[i];
                        if (actualAnswer.equals(userAnswer)) {
                                score++;
                        }
                }
                String scoreMessage = "Your score is: " + score + " / " + questions.length;

                // Display the score in a message dialog
                JOptionPane.showMessageDialog(this, scoreMessage);

                // Exit the application after the user clicks OK
                System.exit(0);
        }

        public static void main(String[] args) {
                SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                                new QuestionService().setVisible(true);
                        }
                });
        }
}
