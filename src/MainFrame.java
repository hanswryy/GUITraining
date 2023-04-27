import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainFrame extends JFrame {
    private JPanel jp1;
    private JButton TAMBAHButton;
    private JCheckBox ayamCheckBox;
    private JCheckBox ikanCheckBox;
    private JPanel checkBoxList;
    private JCheckBox sapiCheckBox;
    private JPanel dataCustomer;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextArea textArea1;
    private JTextPane textPane1;

    public MainFrame() {
        checkBoxList.setLayout(new BoxLayout(checkBoxList, BoxLayout.Y_AXIS));
        dataCustomer.setLayout(new BoxLayout(dataCustomer, BoxLayout.Y_AXIS));
        textPane1.setEditable(false);
        textPane1.setText("0.0");
        textArea1.setEditable(false);
        final String[] pesanan = new String[3];
        final double[] total = new double[3];
        ayamCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==1) {
                    pesanan[0] = "Ayam Goreng (15000)\n";
                    total[0] += 15000;
                } else {
                    pesanan[0] = pesanan[0].replace("Ayam Goreng\n", "");
                    total[0] -= 15000;
                }
                double TT = 0;
                for (double t : total) {
                    TT+=t;
                }
                textPane1.setText(TT+"");
            }
        });
        ikanCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==1) {
                    pesanan[1] = "Ikan Goreng (10000)\n";
                    total[1] += 10000;
                } else {
                    pesanan[1] = pesanan[1].replace("Ikan Goreng\n", "");
                    total[1] -= 10000;
                }
                double TT = 0;
                for (double t : total) {
                    TT+=t;
                }
                textPane1.setText(TT+"");
            }
        });
        sapiCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==1) {
                    pesanan[2] = "Sapi Goreng (25000)\n";
                    total[2] += 25000;
                } else {
                    pesanan[2] = pesanan[2].replace("Sapi Goreng\n", "");
                    total[2] -= 25000;
                }
                double TT = 0;
                for (double t : total) {
                    TT+=t;
                }
                textPane1.setText(TT+"");
            }
        });
        TAMBAHButton.addActionListener(e -> {
            String nama = textField1.getText();
            String alamat = textField2.getText();
            String noHp = textField3.getText();
            textArea1.setText("");
            textArea1.append("Nama: " + nama + "\nAlamat: " + alamat + "\nNo. HP: " + noHp);
            textArea1.append("\n-----------------------------\n");
            textArea1.append("Pesanan: \n");
            for (String p : pesanan) {
                textArea1.append(p);
            }
            textArea1.append("-----------------------------\n");
            textArea1.append("Total : \n" + textPane1.getText() + "\n");
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("MainFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setContentPane(new MainFrame().jp1);
        frame.setVisible(true);
    }
}
