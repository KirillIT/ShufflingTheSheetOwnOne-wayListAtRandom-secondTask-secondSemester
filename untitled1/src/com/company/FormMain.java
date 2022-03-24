package com.company;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class FormMain extends JFrame {

    private JButton ButtonToFile;

    private JButton ButtonFromFile;

    private JPanel FormMain;

    private JTable tableMain;

    private JScrollPane ScrollMain;

    private JButton sdvigArray;

    public FormMain() {

        $$$setupUI$$$();

        this.setTitle("Чуркин Кирилл, таск 2, задание 25");

        this.setContentPane(FormMain);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();

        ru.vsu.cs.util.JTableUtils.initJTableForArray(tableMain, 40, true, true, false, true);

        ru.vsu.cs.util.JTableUtils.resizeJTable(tableMain, 1, 9);

        ButtonToFile.addActionListener(e -> {

            simpleList list = new simpleList();

            for (int i = 0; i < tableMain.getColumnCount(); i++) {

                try {

                    list.add(ru.vsu.cs.util.JTableUtils.readIntArrayFromJTable(tableMain)[i]); //копируем в лист из jtable


                }

                catch (Exception ex) {

                    ex.getMessage();

                }
            }

            ToFile toFile = new ToFile();

            toFile.ToFile(list, "C:\\Users\\newli\\IdeaProjects\\untitled1\\src\\com\\company\\FormMain.txt"); //а теперь записываем из листа в файл

        });

        ButtonFromFile.addActionListener(new ActionListener() { //кнопка чтения данных из файла в лист

            @Override

            public void actionPerformed(ActionEvent e) {

                FromFile fromFile = new FromFile();

                simpleList list = fromFile.FromFile("C:\\Users\\newli\\IdeaProjects\\untitled1\\src\\com\\company\\FormMain.txt"); //из файла в лист

                int arr[] = new int[list.size()];

                for (int i = 0; i < list.size(); i++) {

                    arr[i] = list.get(i); //из листа в массива, нужно для библиотеки, т.к. она работает только с ними

                }

                ru.vsu.cs.util.JTableUtils.writeArrayToJTable(tableMain, arr); //вызываем метод записи листа в таблицу

            }
        });

        sdvigArray.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                simpleList list = new simpleList();

                for (int i = 0; i < tableMain.getColumnCount(); i++) {

                    try {

                        list.add(ru.vsu.cs.util.JTableUtils.readIntArrayFromJTable(tableMain)[i]); //копируем в лист из jtable


                    }

                    catch (Exception ex) {

                        ex.getMessage();

                    }
                }

                simpleList randomNumber = new simpleList();

                for (int i = 0; i < list.size(); i++){

                    randomNumber.add(-1);

                }

                boolean temp;

                for (int i = 0; i < list.size();){

                    randomNumber.set(i, (int)(Math.random() * list.size()));

                    temp = false;

                    for (int j = 0; j < i; j++) {

                        if (randomNumber.get(i) == randomNumber.get(j)){

                            temp = true;

                            break;

                        }
                    }

                    if (temp == true) {

                        continue;

                    }

                    else{

                        i++;

                    }
                }

                int [] finalArray = new int[list.size()];

                int i = 0, j = 0;

                while (j < list.size()){

                     if(i == randomNumber.get(j)){

                         finalArray[j] = list.get(i);

                         i = 0;

                         j++;

                     }

                     else {

                         i++;

                     }
                }

                ru.vsu.cs.util.JTableUtils.writeArrayToJTable(tableMain, finalArray); //вызываем метод записи листа в таблицу

            }
        });
    }

    //дальше барахолка

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        FormMain = new JPanel();
        FormMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 4, new Insets(10, 10, 10, 10), 10, 10));
        ButtonToFile = new JButton();
        ButtonToFile.setText("Загрузить в файл");
        FormMain.add(ButtonToFile, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(275, 30), null, 0, false));
        ButtonFromFile = new JButton();
        ButtonFromFile.setText("Загрузить из файла");
        FormMain.add(ButtonFromFile, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ScrollMain = new JScrollPane();
        FormMain.add(ScrollMain, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tableMain = new JTable();
        ScrollMain.setViewportView(tableMain);
        sdvigArray = new JButton();
        sdvigArray.setText("Сдвинуть массив");
        FormMain.add(sdvigArray, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(275, 30), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return FormMain;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
