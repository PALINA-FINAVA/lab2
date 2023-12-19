package bsu.rfe.java.group7.lab2.Finova.varB11;
//импорт классов
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
//главный класс фрейм
public class MainFrame extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 320;

    // Текстовые поля для считывания значений переменных,
// как компоненты, совместно используемые в различных методах
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;
    // Текстовое поле для отображения результата,
// как компонент, совместно используемый в различных методах
    private JTextField textFieldResult;
    // Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtons = new ButtonGroup();
    // Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtonsMemory = new ButtonGroup();
    // Контейнер для отображения радио-кнопок
    private Box hboxMemoryType = Box.createHorizontalBox();
    // Контейнер для отображения радио-кнопок
    private Box hboxFormulaType = Box.createHorizontalBox();
    private int formulaId = 1;
    private int memoryId = 1;
    public Double calculate1(Double x, Double y, Double z) {
        return ((1/Math.pow(x,1/2))+ Math.cos(Math.pow(Math.E,y))+Math.cos(Math.pow(z,2)))/
                Math.pow(Math.log(Math.pow(1+z,2))+Math.pow(Math.pow(Math.E, Math.cos(y))+Math.pow(Math.sin(Math.PI)*x,2),1/2),1/3);
    }
    public Double calculate2(Double x, Double y, Double z) {
        return (Math.atan(Math.pow(z, 1/x)))/
                (Math.pow(y,2)+z*Math.sin(Math.log(x)));
    }
    // Вспомогательный метод для добавления кнопок на панель
    private void addRadioButton(String buttonName, final int formulaId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.formulaId = formulaId;
            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }
// Вспомогательный метод для добавления кнопок на панель
    private void addRadioButtonMemory(String buttonName, final int memoryId) {
        JRadioButton button = new JRadioButton(buttonName);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.memoryId = memoryId;
            }
        });
        radioButtonsMemory.add(button);
        hboxMemoryType.add(button);
    }
    // Конструктор класса
    public MainFrame() {
        super("Formula calculation");
        setSize(WIDTH, HEIGHT);
        //создание кнопки мемори с заданным нулем изначально
        JLabel textFieldMemoryData1 = new JLabel("0");
        JLabel textFieldMemoryData2 = new JLabel("0");
        JLabel textFieldMemoryData3 = new JLabel("0");
// Отцентрировать окно приложения на экране
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - WIDTH)/2,(kit.getScreenSize().height - HEIGHT)/2);
//создание кнопки М+ для добавления памяти
        JButton buttonMemoryPlus = new JButton("M+");

        buttonMemoryPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(memoryId) {
                    case 1 : {
                        Double newValue = Double.parseDouble(textFieldResult.getText()) + Double.parseDouble(textFieldMemoryData1.getText());
                        textFieldMemoryData1.setText(newValue.toString());
                        break;
                    }
                    case 2 : {
                        Double newValue = Double.parseDouble(textFieldResult.getText()) + Double.parseDouble(textFieldMemoryData2.getText());
                        textFieldMemoryData2.setText(newValue.toString());
                        break;
                    }
                    case 3 : {
                        Double newValue = Double.parseDouble(textFieldResult.getText()) + Double.parseDouble(textFieldMemoryData3.getText());
                        textFieldMemoryData3.setText(newValue.toString());
                        break;
                    }
                    default : {
                        break; }
                }
            }
        });
//сброс до 0
        JButton buttonMemoryClear = new JButton("MC");
        buttonMemoryClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(memoryId) {
                    case 1 : {
                        textFieldMemoryData1.setText("0");
                        break;
                    }
                    case 2 : {
                        textFieldMemoryData2.setText("0");
                        break;
                    }
                    case 3 : {
                        textFieldMemoryData3.setText("0");
                        break;
                    }
                    default : {
                        break; }
                }
            }
        });

        // Коробка кнопок с выбором формулы
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.add(Box.createHorizontalStrut(50));
        addRadioButton("Formula 1", 1);
        addRadioButton("Formula 2", 2);
        hboxFormulaType.add(Box.createHorizontalGlue());
        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.PINK));

        // Коробка кнопок с работой с памятью
        hboxMemoryType.add(Box.createHorizontalGlue());
        hboxMemoryType.add(Box.createHorizontalStrut(50));
        addRadioButtonMemory("Memory 1", 1);
        addRadioButtonMemory("Memory 2", 2);
        addRadioButtonMemory("Memory 3", 3);
        hboxMemoryType.add(Box.createHorizontalGlue());
        radioButtonsMemory.setSelected(radioButtonsMemory.getElements().nextElement().getModel(), true);
        hboxMemoryType.add(Box.createHorizontalGlue());
        hboxMemoryType.setBorder(BorderFactory.createLineBorder(Color.PINK));

        Box hboxMemory = Box.createHorizontalBox();
        hboxMemory.add(Box.createHorizontalGlue());
        hboxMemory.add(Box.createHorizontalStrut(100));
        /*hboxMemory.add(Box.createHorizontalGlue());*/
        hboxMemory.add(textFieldMemoryData1);
        hboxMemory.add(Box.createHorizontalStrut(20));
        hboxMemory.add(textFieldMemoryData2);
        hboxMemory.add(Box.createHorizontalStrut(20));
        hboxMemory.add(textFieldMemoryData3);
        hboxMemory.add(Box.createHorizontalStrut(50));
        hboxMemory.add(buttonMemoryPlus);
        hboxMemory.add(buttonMemoryClear);
        hboxMemory.add(Box.createHorizontalGlue());

        hboxMemory.add(Box.createHorizontalGlue());

        // Создать область с полями ввода для X и Y Z
        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());

        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.setBorder(BorderFactory.createLineBorder(Color.PINK));
        //hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        //hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        //hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        //hboxVariables.add(Box.createHorizontalGlue());

        // Создать область для вывода результата
        JLabel labelForResult = new JLabel("Result:");
        textFieldResult = new JTextField("0", 100);
        textFieldResult.setMaximumSize(

                textFieldResult.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.PINK));

        // Создать область для кнопок
        JButton buttonCalc = new JButton("Calculate");
        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    Double result;
                    if (formulaId==1)
                        result = calculate1(x, y,z);
                    else
                        result = calculate2(x, y,z);
                    textFieldResult.setText(result.toString());
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Error", "Error",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton buttonReset = new JButton("Clear fields");
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
            }
        });

        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(10));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.setBorder(BorderFactory.createLineBorder(Color.PINK));


        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(hboxResult);
        contentBox.add(hboxMemoryType);
        /*contentBox.add(hboxMemory);*/
        contentBox.add(hboxButtons);
        contentBox.add(hboxMemory);
        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}