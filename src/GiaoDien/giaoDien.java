package GiaoDien;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.awt.event.KeyEvent;

import static controller.controller.findWord;
import static controller.controller.suggestionWord;

public class giaoDien extends Component implements ActionListener, KeyListener {
    private JFrame jFrame;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;

    private JTextField jTextField1;
    private JList jList;
    private JScrollPane jScrollPane;


    public giaoDien() {
        jFrame = new JFrame();
        prepareGUI();
        setDisplay();
    }

    /**
     * set display for JFrame
     */
    public void prepareGUI()
    {
        jFrame.add(getTabbedPanel());
    }
    public void setDisplay() {
        //jFrame.setSize(1000,600);

        jFrame.setTitle("Dictionary");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    /**
     * add JTabbedPane into JFrame
     */

    public JTabbedPane getTabbedPanel()
    {
        JTabbedPane tabbedPane = new JTabbedPane();


        JPanel jPanel1 = getJPanel();
        JPanel jPanel2 = createJPanel("content of panel 2");

        tabbedPane.addTab("Search", null, jPanel1,"page 1");
        tabbedPane.addTab("Edit", null, jPanel2, "click to show panel 2");

        //tabbedPane.setSize(600,500);
        tabbedPane.setVisible(true);
        return tabbedPane;
    }
    public JPanel createJPanel(String text) {
        JPanel panel = new JPanel(new GridLayout(100, 200));
        JLabel lb = new JLabel(text);
        lb.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lb);
        return panel;
    }
    public JPanel getJPanel(){

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        //panel.setSize(1000,600);
        panel.setLayout(new FlowLayout());

        jButton1 = new JButton("OK");
        jLabel1 = new JLabel("Find");
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jLabel3 = new JLabel();
        jList = new JList();
        jScrollPane = new JScrollPane(jList);
        jTextField1.setFont(new Font("Serif", Font.PLAIN, 16));

        jButton1.setBounds(250, 50, 60, 30);
        jTextField1.setBounds(50,50,200,30);
        //jTextField1.setSize(200,30);
        jLabel1.setBounds(10,50,30,30);
        jLabel2.setBounds(400,150,200,30);
        jLabel3.setBounds(400,70,200,30);
        jList.setBounds(50,90,200,500);
        jScrollPane.setBounds(50,90,230,500);

        jButton1.addActionListener(this);
        jTextField1.addKeyListener(this);


        panel.add(jButton1);
        panel.add(jTextField1);
        panel.add(jLabel1);
        panel.add(jLabel2);
        panel.add(jLabel3);
        panel.add(jList);
        panel.add(jScrollPane);

        return panel;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        abc();//sua
    }

    public void listWord(){
        String text = jTextField1.getText();
        String word[] = {""};
        try {
            word = suggestionWord(text);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i=0; i<word.length; i++){
            System.out.println(word[i]);
        }
        jList.setListData(word);
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //nhan
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            abc();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //nha
        if(( e.getKeyCode() >= 65 && e.getKeyCode()<=90 )
                || e.getKeyCode() ==8
                || ( e.getKeyCode()>=48 && e.getKeyCode() <=57)
                || e.getKeyCode()==32){
            listWord();
        }
    }

    private void abc(){
        String text = jTextField1.getText();
        String s = "";
        try {
            s = findWord(text);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        if(s.equals("")){
            JOptionPane.showConfirmDialog(this,"Từ bạn nhập không có trong từ điển", "Thông báo", JOptionPane.DEFAULT_OPTION);
        }
        else{
            System.out.println(s);
            jLabel3.setText(text);
            jLabel2.setText(s);
        }
    }
}
