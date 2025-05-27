import javax.swing.*;
import java.awt.event.*;
import java.net.*;

public class IPFinder extends JFrame {
    private JTextField websiteField;
    private JButton findIPButton;
    private JLabel resultLabel;

    public IPFinder() {
        setTitle("IP Finder");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel websiteLabel = new JLabel("Enter Website URL:");
        websiteLabel.setBounds(20, 20, 150, 25);
        add(websiteLabel);

        websiteField = new JTextField();
        websiteField.setBounds(150, 20, 200, 25);
        add(websiteField);

        findIPButton = new JButton("Find IP");
        findIPButton.setBounds(150, 50, 100, 30);
        add(findIPButton);

        resultLabel = new JLabel("IP Address will appear here");
        resultLabel.setBounds(20, 90, 350, 25);
        add(resultLabel);

        // Add action listener to button
        findIPButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String website = websiteField.getText();
                try {
                    InetAddress inetAddress = InetAddress.getByName(website);
                    resultLabel.setText("IP: " + inetAddress.getHostAddress());
                } catch (UnknownHostException ex) {
                    resultLabel.setText("Invalid URL or network issue.");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new IPFinder();
    }
}
