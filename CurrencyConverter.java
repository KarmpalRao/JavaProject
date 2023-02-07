
import javax.swing.*;
import java.awt.event.*;
public class CurrencyConverter{
 static void curreny_change()
 {
    JLabel input_msg,output_msg;
    JTextField input_data;
    JButton INR,DOLLER;
    JFrame frame=new JFrame("Converter Currency"); 
        frame.setSize(400, 500);
        
        input_msg=new JLabel("Enter Your Amount :");
        input_msg.setBounds(50, 50, 200, 30);

        input_data=new JTextField();
        input_data.setBounds(50, 100, 200, 30);

        INR=new JButton("Convert INR");
        INR.setBounds(50, 150, 120, 30);

        DOLLER=new JButton("Convert Doller");
        DOLLER.setBounds(220, 150, 120, 30);

        output_msg=new JLabel("OUTPUT :-");
        output_msg.setBounds(80, 220, 150, 30);
        frame.add(input_msg);frame.add(input_data);
        frame.add(INR); frame.add(DOLLER);frame.add(output_msg);
        frame.setLayout(null);
        frame.setVisible(true);
        ActionListener click=new ActionListener(){
            public void actionPerformed(ActionEvent e)
            { 
                Double data;
                data=Double.parseDouble(input_data.getText());
                data=data*81.70;
                output_msg.setText("INR:- "+String.valueOf(data)+" RS");

            }
        };
        ActionListener change_dollr=new ActionListener(){
            public void actionPerformed(ActionEvent e)
            { 
                Double data;
                data=Double.parseDouble(input_data.getText());
                data=data/81.70;
                output_msg.setText("Dollar:- "+String.valueOf(data)+" $");

            }
        };
        INR.addActionListener(click);
        DOLLER.addActionListener(change_dollr);
       
 }
    public static void main(String[] args) {
        curreny_change();
    }
}
