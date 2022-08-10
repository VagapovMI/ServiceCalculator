package tsu.pr;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Simp extends JFrame {
    private final JTextField inputlabel = new JTextField("");
    private final JTextField inputfunk = new JTextField("");
    private final JFormattedTextField inputwaterh = new JFormattedTextField(32);
    private final JFormattedTextField inputtarwaterh = new JFormattedTextField(39);
    private final JFormattedTextField inputwaterc = new JFormattedTextField(45);
    private final JFormattedTextField inputtarwaterc = new JFormattedTextField(38);
    private final JFormattedTextField inputlight = new JFormattedTextField(132);
    private final JFormattedTextField inputtarlight = new JFormattedTextField(5);
    private final JFormattedTextField inputconsum = new JFormattedTextField(0);
    private final JFormattedTextField inputtarconsum = new JFormattedTextField(0);
    private final JLabel funk = new JLabel("Добавить услугу:");
    private final JRadioButton flatone = new JRadioButton("Квартира №1");
    private final JRadioButton flattwo = new JRadioButton("Квартира №2");
    private final JRadioButton another = new JRadioButton("Другое");
    private final JCheckBox waterh = new JCheckBox("Горячая вода", false);
    private final JCheckBox waterc = new JCheckBox("Холодная вода", true);
    private final JCheckBox light = new JCheckBox("Свет", true);

    public Simp() {
        super("Кварплата");
        this.setBounds(500, 100, 600, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(14, 3, 15, 4));
        JLabel label = new JLabel("Добавить объект: ");
        container.add(label);
        JLabel spacelabel = new JLabel(" ");
        container.add(spacelabel);
        container.add(inputlabel);
        ButtonGroup group = new ButtonGroup();
        group.add(flatone);
        group.add(flattwo);
        group.add(another);
        container.add(flatone);
        container.add(flattwo);
        container.add(another);
        another.setSelected(true);
        JLabel people = new JLabel("Кол-во прописанных чел.:");
        container.add(people);
        JLabel spacepeople = new JLabel(" ");
        container.add(spacepeople);
        JFormattedTextField inputpeople = new JFormattedTextField(3);
        container.add(inputpeople);
        JLabel square = new JLabel("Площадь Кв.М.:");
        container.add(square);
        JLabel spacesquare = new JLabel(" ");
        container.add(spacesquare);
        JFormattedTextField inputsquare = new JFormattedTextField(56);
        container.add(inputsquare);
        container.add(waterh);
        JLabel waterpotrh = new JLabel("Куб.М.:");
        container.add(waterpotrh);
        container.add(inputwaterh);
        JLabel spacewaterh = new JLabel(" ");
        container.add(spacewaterh);
        JLabel tarwaterh = new JLabel("Тариф за ед.:");
        container.add(tarwaterh);
        container.add(inputtarwaterh);
        container.add(waterc);
        JLabel waterpotrc = new JLabel("Куб.М.:");
        container.add(waterpotrc);
        container.add(inputwaterc);
        JLabel spacewaterc = new JLabel(" ");
        container.add(spacewaterc);
        JLabel tarwaterc = new JLabel("Тариф за ед.:");
        container.add(tarwaterc);
        container.add(inputtarwaterc);
        container.add(light);
        JLabel lightpotr = new JLabel("кВт/ч:");
        container.add(lightpotr);
        container.add(inputlight);
        JLabel spacelight = new JLabel(" ");
        container.add(spacelight);
        JLabel tarlight = new JLabel("Тариф за ед.:");
        container.add(tarlight);
        container.add(inputtarlight);
        container.add(funk);
        JLabel spacefunk = new JLabel(" ");
        container.add(spacefunk);
        container.add(inputfunk);
        JLabel consum = new JLabel("Потребление ед.:");
        container.add(consum);
        JLabel spaceconsum = new JLabel(" ");
        container.add(spaceconsum);
        container.add(inputconsum);
        JLabel tarconsum = new JLabel("Тариф за ед.:");
        container.add(tarconsum);
        JLabel spacetarconsum = new JLabel(" ");
        container.add(spacetarconsum);
        container.add(inputtarconsum);

        JButton button = new JButton("Рассчитать");
        button.addActionListener(new ButtonEve());
        container.add(button);
    }

    class ButtonEve implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "Недвижимость:\n";
            if (!(inputlabel.getText().isEmpty())) {
                message += "Добавлен объект: " + inputlabel.getText() + "\n";
            }
                if (inputlabel.getText().isEmpty()) {
                }
                    if (another.isSelected() & inputlabel.getText().isEmpty() ) {
                        message += ("Объект не указан.\n");
                    }

                    if (flatone.isSelected()) {
                        message += ("Выбрана Квартира №1.\n");
                    }
                    if (flattwo.isSelected()) {
                        message += ("Выбрана Квартира №2.\n");
                    }
                    message += "Горячая вода" + " " + ((waterh.isSelected()) ? "подключена" : "отключена") + ".\n";
                    if (waterh.isSelected()) {
                        message += "Рассчёт за горячую воду: " + Integer.parseInt(inputwaterh.getText()) * Integer.parseInt(inputtarwaterh.getText()) + "р.\n";
                    }
                    message += "Холодная вода" + " " + ((waterc.isSelected()) ? "подключена" : "отключена") + ".\n";
                    if (waterc.isSelected()) {
                        message += "Рассчёт за холодную воду: " + Integer.parseInt(inputwaterc.getText()) * Integer.parseInt(inputtarwaterc.getText()) + "р.\n";
                    }
                    message += "Свет" + " " + ((light.isSelected()) ? "подключен" : "отключен") + ".\n";
                    if (light.isSelected()) {
                        message += "Рассчёт электричество: " + Integer.parseInt(inputlight.getText()) * Integer.parseInt(inputtarlight.getText()) + "р.\n";
                    }
                    if (!(inputfunk.getText().isEmpty())) {
                        message += "Добавлено " + inputfunk.getText() + ".\n";
                    }
                    if (!(inputfunk.getText().isEmpty())) {
                        message += "Рассчёт за услугу: " + Integer.parseInt(inputconsum.getText()) * Integer.parseInt(inputtarconsum.getText()) + "р.\n";
                    }
                    if (waterh.isSelected() & waterc.isSelected() & light.isSelected() & !(funk.getText().isEmpty())) {
                        message += "Итоговая сумма: " + ((Integer.parseInt(inputwaterh.getText()) * Integer.parseInt(inputtarwaterh.getText())) +
                                (Integer.parseInt(inputwaterc.getText()) * Integer.parseInt(inputtarwaterc.getText())) +
                                (Integer.parseInt(inputlight.getText()) * Integer.parseInt(inputtarlight.getText())) +
                                (Integer.parseInt(inputconsum.getText()) * Integer.parseInt(inputtarconsum.getText()))) + "р.\n";
                    }
                    if (waterh.isSelected() & waterc.isSelected() & light.isSelected() & (funk.getText().isEmpty())) {
                        message += "Итоговая сумма: " + ((Integer.parseInt(inputwaterh.getText()) * Integer.parseInt(inputtarwaterh.getText())) +
                                (Integer.parseInt(inputwaterc.getText()) * Integer.parseInt(inputtarwaterc.getText())) +
                                (Integer.parseInt(inputlight.getText()) * Integer.parseInt(inputtarlight.getText()))) + "р.\n";
                    }
                    if (waterh.isSelected() & waterc.isSelected() & !(light.isSelected()) & !(funk.getText().isEmpty())) {
                        message += "Итоговая сумма: " + ((Integer.parseInt(inputwaterh.getText()) * Integer.parseInt(inputtarwaterh.getText())) +
                                (Integer.parseInt(inputwaterc.getText()) * Integer.parseInt(inputtarwaterc.getText())) +
                                (Integer.parseInt(inputconsum.getText()) * Integer.parseInt(inputtarconsum.getText()))) + "р.\n";
                    }
                    if (waterh.isSelected() & !(waterc.isSelected()) & light.isSelected() & !(funk.getText().isEmpty())) {
                        message += "Итоговая сумма: " + ((Integer.parseInt(inputwaterh.getText()) * Integer.parseInt(inputtarwaterh.getText())) +
                                (Integer.parseInt(inputlight.getText()) * Integer.parseInt(inputtarlight.getText())) +
                                (Integer.parseInt(inputconsum.getText()) * Integer.parseInt(inputtarconsum.getText()))) + "р.\n";
                    }
                    if (!(waterh.isSelected()) & waterc.isSelected() & light.isSelected() & !(funk.getText().isEmpty())) {
                        message += "Итоговая сумма: " + ((Integer.parseInt(inputwaterc.getText()) * Integer.parseInt(inputtarwaterc.getText())) +
                                (Integer.parseInt(inputlight.getText()) * Integer.parseInt(inputtarlight.getText())) +
                                (Integer.parseInt(inputconsum.getText()) * Integer.parseInt(inputtarconsum.getText()))) + "р.\n";
                    }
                    JOptionPane.showMessageDialog(null, message, "Рассчёт", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
