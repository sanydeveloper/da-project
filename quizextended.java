package JavaGUIProjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGameExtends implements ActionListener {

    String[] Questions = {
            "Which Company Created Java?",
            "Which year was java Created?",
            "What was java originally Called?"
    };

    String[][] Options = {
            {"Sun Microsystems", "Starbucks", "Microsoft", "Alphabet"},
            {"1989", "1996", "1972", "1492"},
            {"Apple", "Latte", "Oak", "Offing"}
    };

    char[] Answers = {
            'A',
            'B',
            'C'
    };

    char guess;
    char answer;
    int index;
    int Correct_Guesses = 0;
    int totalQuestions = Questions.length;
    int Result;
    int seconds = 10;

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();

    JLabel Answer_LabelA = new JLabel();
    JLabel Answer_LabelB = new JLabel();
    JLabel Answer_LabelC = new JLabel();
    JLabel Answer_LabelD = new JLabel();

    JLabel timeLabel = new JLabel();
    JLabel secondsLeft = new JLabel();

    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            secondsLeft.setText(String.valueOf(seconds));

            if (seconds <= 0){
                displayAnswer();
            }
        }

    });


    public QuizGameExtends(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0, 0, 650, 50);
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 25, 120));
        textField.setFont(new Font("Ink free", Font.BOLD + Font.ITALIC, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setBounds(0, 50, 650, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25, 25, 25));
        textArea.setForeground(new Color(25, 25, 120));
        textArea.setFont(new Font("MV Boli", Font.BOLD + Font.ITALIC, 25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        buttonA.setBounds(0, 100, 100, 100);
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0, 210, 100, 100);
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0, 320, 100, 100);
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0, 430, 100, 100);
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        Answer_LabelA.setBounds(125, 100, 500, 100);
        Answer_LabelA.setBackground(new Color(50, 50, 50));
        Answer_LabelA.setForeground(new Color(25, 255, 0));
        Answer_LabelA.setFont(new Font("MV Boli", Font.BOLD + Font.ITALIC, 35));

        Answer_LabelB.setBounds(125, 210, 500, 100);
        Answer_LabelB.setBackground(new Color(50, 50, 50));
        Answer_LabelB.setForeground(new Color(25, 255, 0));
        Answer_LabelB.setFont(new Font("MV Boli", Font.BOLD + Font.ITALIC, 35));

        Answer_LabelC.setBounds(125, 320, 500, 100);
        Answer_LabelC.setBackground(new Color(50, 50, 50));
        Answer_LabelC.setForeground(new Color(25, 255, 0));
        Answer_LabelC.setFont(new Font("MV Boli", Font.BOLD + Font.ITALIC, 35));

        Answer_LabelD.setBounds(125, 430, 500, 100);
        Answer_LabelD.setBackground(new Color(50, 50, 50));
        Answer_LabelD.setForeground(new Color(25, 255, 0));
        Answer_LabelD.setFont(new Font("MV Boli", Font.BOLD + Font.ITALIC, 35));

        secondsLeft.setBounds(535, 510, 100, 100);
        secondsLeft.setBackground(new Color(25, 25, 25));
        secondsLeft.setForeground(new Color(0, 255, 0));
        secondsLeft.setFont(new Font("Ink Free", Font.BOLD + Font.ITALIC, 60));
        secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));

        timeLabel.setBounds(535, 475, 100, 25);
        timeLabel.setBackground(new Color(50, 50, 50));
        timeLabel.setForeground(new Color(255, 10, 10));
        timeLabel.setFont(new Font("MV Boli", Font.PLAIN, 25));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setText("Timer");

        number_right.setBounds(225, 225, 200, 100);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 25, 255));
        number_right.setFont(new Font("Ink Free", Font.BOLD + Font.ITALIC, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225, 325, 200, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 25));
        percentage.setFont(new Font("Ink Free", Font.BOLD + Font.ITALIC, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setEditable(false);

        frame.add(timeLabel);
        frame.add(secondsLeft);
        frame.add(Answer_LabelA);
        frame.add(Answer_LabelB);
        frame.add(Answer_LabelC);
        frame.add(Answer_LabelD);
        frame.add(textField);
        frame.add(textArea);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        nextQuestion();
    }

    public void nextQuestion(){
        if (index >= totalQuestions){
            results();
        }
        else {
            textField.setText("Question " + (index + 1));
            textArea.setText(Questions[index]);
            Answer_LabelA.setText(Options[index][0]);
            Answer_LabelB.setText(Options[index][1]);
            Answer_LabelC.setText(Options[index][2]);
            Answer_LabelD.setText(Options[index][3]);

            timer.start();
        }
    }

    public void displayAnswer(){

        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (Answers[index] != 'A'){
            Answer_LabelA.setForeground(new Color(255, 0, 0));
        }

        if (Answers[index] != 'B'){
            Answer_LabelB.setForeground(new Color(255, 0, 0));
        }

        if (Answers[index] != 'C'){
            Answer_LabelC.setForeground(new Color(255, 0, 0));
        }

        if (Answers[index] != 'D'){
            Answer_LabelD.setForeground(new Color(255, 0, 0));
        }

        Timer Pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Answer_LabelA.setForeground(new Color(25, 255, 0));
                    Answer_LabelB.setForeground(new Color(25, 255, 0));
                    Answer_LabelC.setForeground(new Color(25, 255, 0));
                    Answer_LabelD.setForeground(new Color(25, 255, 0));

                    answer = ' ';
                    seconds = 10;
                    secondsLeft.setText(String.valueOf(seconds));
                    buttonA.setEnabled(true);
                    buttonB.setEnabled(true);
                    buttonC.setEnabled(true);
                    buttonD.setEnabled(true);

                    index++;

                    nextQuestion();
                }

        });

        Pause.setRepeats(false);
        Pause.start();
    }

    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        Result = (int)((Correct_Guesses /(double) totalQuestions) * 100);

        textField.setText("RESULTS!");
        textArea.setText("");
        Answer_LabelA.setText("");
        Answer_LabelB.setText("");
        Answer_LabelC.setText("");
        Answer_LabelD.setText("");

        number_right.setText(Correct_Guesses + "/" + totalQuestions);
        percentage.setText(Result + "%");

        frame.add(percentage);
        frame.add(number_right);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA){
            answer = 'A';
            if (answer == Answers[index]){
                Correct_Guesses++;
            }
        }

        else if (e.getSource() == buttonB){
            answer = 'B';
            if (answer == Answers[index]){
                Correct_Guesses++;
            }
        }

        else if (e.getSource() == buttonC){
            answer = 'C';
            if (answer == Answers[index]){
                Correct_Guesses++;
            }
        }

        else if (e.getSource() == buttonA){
            answer = 'D';
            if (answer == Answers[index]){
                Correct_Guesses++;
            }
        }

        displayAnswer();
    }
}
