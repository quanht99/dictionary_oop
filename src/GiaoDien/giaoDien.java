package GiaoDien;

import controller.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class giaoDien extends Frame implements ActionListener {
    private TextField textField;
    private Label label;

    public giaoDien()
    {
        Button button = new Button("OK");
        button.setBounds(50,150,60,30);

        label = new Label();
        label.setBounds(50,100,250,30);

        textField = new TextField();
        textField.setBounds(50,50,150,30);

        button.addActionListener(this);

        add(button);
        add(label);
        add(textField);

        setSize(400,500);
        setLayout(null);
        setVisible(true);
        thoatChuongTrinh();

    }
    //cop
    public void thoatChuongTrinh()
    {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                JOptionPane.showConfirmDialog(null, "Không có gì xảy ra với sự kiện này nếu tự đối tượng bắt sự kiện này?",
                        null, JOptionPane.YES_NO_OPTION);
            }
            public void windowClosing(WindowEvent e) {
                int hoi = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình không?",
                        null, JOptionPane.YES_NO_OPTION);
                if (hoi == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            String text = textField.getText();
            String detail = controller.findWord(text);
            label.setText(detail);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

//    public static void main(String args[])
//    {
//        new giaoDien();
//    }

}
