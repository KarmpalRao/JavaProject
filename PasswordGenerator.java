import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

class Password
{  
    static int num;
    static String pass;
    void generate()
    {
        int length = num;
        String capitalLetter ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetter= "abcdefghijklmnopqrstuvwxyz";
        String specialChar ="!@#$";
        String number = "1234567890";
        String combined = capitalLetter + smallLetter + specialChar + number;

        Random random = new Random();
        char[] password = new char[length];
        password[0]=capitalLetter.charAt(random.nextInt(capitalLetter.length()));
        password[1] = smallLetter.charAt(random.nextInt(smallLetter.length()));
        password[2] = specialChar.charAt(random.nextInt(specialChar.length()));
        password[3] = number.charAt(random.nextInt(number.length()));
        

        for(int i=4;i<length;i++)
        {
            password[i] = combined.charAt(random.nextInt(combined.length()));
        }
        String str = new String();
        pass = str.valueOf(password);
        System.out.println(pass);
    }

    void framee()
    {
        JFrame frame = new JFrame();
        frame.setBounds(10,25,300,350);

        JLabel title = new JLabel("Random Password Generator");
        title.setBounds(50,10,200,25);
        frame.add(title);

        JLabel length = new JLabel("Password Length");
        length.setBounds(10,50,100,25);
        frame.add(length);


        JTextArea tlength = new JTextArea();
        tlength.setBounds(120,50,100,25);
        tlength.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(tlength);


        JButton get = new JButton("Get Password");
        get.setBounds(80,100,120,30);
        frame.add(get);

        JLabel l = new JLabel();
        l.setBounds(25,200,300,15);
        frame.add(l);

        ActionListener click = new ActionListener()
        {
            
            public void actionPerformed(ActionEvent ee)
            {
                String count=tlength.getText();
                num =Integer.parseInt(count);

                generate();

                l.setText("Your Password=  "+pass);
            }
        };

        get.addActionListener(click);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

public class PasswordGenerator
{
    public static void main(String[] args)
    {
        Password obj = new Password();
        obj.framee();
    }
}
