import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.File;  
import java.util.Scanner; 
public class LoginRegistration
{
 
    void reg_page()
    {
        JFrame frame=new JFrame("Register Page");
        frame.setSize(450,400); 
        JLabel msg=new JLabel("TCG USER");
        msg.setBounds(200, 60, 200, 30); 
        msg.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lb_name=new JLabel("UserName: ");
        lb_name.setBounds(50, 100, 100, 30);        

        JTextField  uname=new JTextField(10);         
        uname.setBounds(150, 110, 200, 30);  

        JLabel lb=new JLabel("Mail Id : ");
        lb.setBounds(50, 150, 100, 30);        

        JTextField  mail=new JTextField(10);         
        mail.setBounds(150, 150, 200, 30);       

        JLabel lb2=new JLabel("Password : ");
        lb2.setBounds(50, 190, 100, 30);           
        
        JTextField  pass=new JTextField(10);         
        pass.setBounds(150, 190, 200, 30);        
        
        JButton bt1=new JButton("Register");
        bt1.setBounds(200, 250, 100, 30);     
        Color color=new Color(128, 128, 128); 
        bt1.setBackground(color); 
        bt1.setForeground(color.white);  

        JLabel output=new JLabel();
        output.setBounds(100, 280, 100, 30);
        JLabel result=new JLabel();
        result.setBounds(100, 300, 100, 30);

        frame.add(lb_name);frame.add(msg);frame.add(uname);frame.add(lb);
        frame.add(mail);frame.add(lb2);frame.add(pass);frame.add(bt1);
        frame.add(output);frame.add(result);frame.setLayout(null);  
        frame.setVisible(true);

        ActionListener click=new ActionListener(){         
            public void actionPerformed(ActionEvent e)           
            { 
                  
                try {  if(uname.getText()!="" && mail.getText()!="" && pass.getText()!="")  
                        {
                            FileWriter fw = new FileWriter("data.txt",true);
                            fw.write(uname.getText()+"+"+mail.getText()+"+"+pass.getText()+"\n");           
                            fw.close(); 
                        }  
                              
                       
                } catch (Exception ee) {
                    System.out.println(ee);
                }           
                
                result.setText("Register success..");
                frame.setVisible(false);
                login();
            }
        };
        bt1.addActionListener(click);
    }
   void login()
      {
        JFrame frame=new JFrame(" Login & Registration Page");
        frame.setSize(450,400);  

        JLabel sign=new JLabel("ENTER YOUR CRENDENTIAL FOR SIGNIN ");
        sign.setBounds(100, 20, 300, 30);   
        JLabel msg=new JLabel("Login Details:");
        msg.setBounds(150, 50, 200, 30); 
        JLabel lb=new JLabel("UserName: ");
        lb.setBounds(50, 90, 150, 30);        

        JTextField  mail=new JTextField(10);         
        mail.setBounds(120, 100, 200, 30);       

        JLabel lb2=new JLabel("Password : ");
        lb2.setBounds(50, 140, 150, 30);           
        
        JTextField  pass=new JTextField(10);         
        pass.setBounds(120, 140, 200, 30);        
        
        JButton bt1=new JButton("Login");
        bt1.setBounds(150, 200, 100, 30);  
        Color color=new Color(135,135,128); 
        
        JButton bt2=new JButton("New User Registration");
        bt2.setBounds(100, 250, 200, 30);          
        
        JLabel output=new JLabel();
        output.setBounds(100, 480, 300, 50);
        
        frame.add(sign);frame.add(msg);frame.add(lb);frame.add(mail);
        frame.add(lb2);frame.add(pass);frame.add(bt1);frame.add(bt2);
        frame.add(output);frame.setLayout(null);frame.setVisible(true);

        ActionListener click=new ActionListener(){         
            public void actionPerformed(ActionEvent e)           
            { 
                  
                try {
                    int count=0;
                    File check_data = new File("data.txt");
                    Scanner rd = new Scanner(check_data);
                    while (rd.hasNextLine()) {
                    String data = rd.nextLine();  
                          
                    if(data.contains(mail.getText()) && data.contains(pass.getText()))
                    {
                        count++;
                    }
                    
                    }
                    output.setText(""+count);
                    if(count==1)
                    {
                        output.setText("Login Success ");
                        frame.setVisible(false);
                        home_page(mail.getText());
                    }
                    else if(count==0)
                    {
                        output.setText("Incorrect Details ");                             
                        login();                  
                     }
                    
                } catch (Exception ee) {
                    System.out.println(ee);
                }           
            }
        };
        bt1.addActionListener(click);

        ActionListener reg=new ActionListener(){         
            public void actionPerformed(ActionEvent e)           
            { 
                  reg_page();
                frame.setVisible(false);   
            }
        };
        bt2.addActionListener(reg);
    }
 
  public void home_page(String user_name)
  {
    JFrame frame=new JFrame("Login & Registration Page ");
    frame.setSize(500,600);  

    JLabel name=new JLabel();
    name.setText("Login Successful \n Welcom Mr."+user_name);
    name.setBounds(100, 100, 300, 50);
    
        frame.add(name); frame.setLayout(null);  
        frame.setVisible(true);
  }

     public static void main(String args[])
       {
        LoginRegistration obj=new LoginRegistration();
           obj.login();
         

           
       }
   


 
}