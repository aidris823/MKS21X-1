import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TemperatureWindow extends JFrame implements ActionListener {
    
    private Container pane;
    private JTextField t;
    private JButton FtoC;
    private JButton CtoF;
    private JTextField t2;
     
    public TemperatureWindow() {
	
	this.setTitle("Temperature Converter");
	this.setSize(300,200);
	this.setLocation(100,50);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	t = new JTextField(20);
	FtoC = new JButton("Fahrenheit to Celsius");
	CtoF = new JButton("Celsius to Fahrenheit");
	t2 = new JTextField(20);
	
	FtoC.addActionListener(this);
	CtoF.addActionListener(this);

	pane.add(t);
	pane.add(FtoC);
	pane.add(CtoF);
	pane.add(t2);
	
    }
    
    public static double CtoF(double t) {
	return (t - 32) / 1.8;
    }
    
    public static double FtoC(double t) {
	return t * 1.8 + 32;
    }

    public void actionPerformed(ActionEvent e) {
	String event = e.getActionCommand();
	try {
	    t2.setText("");
	    double temp = Double.parseDouble(t.getText());
	    
	    if (event.equals("Fahrenheit to Celsius")) {
		t2.setText((FtoC(temp))+ " C");
	    }
	    if (event.equals("Celsius to Fahrenheit")) {
		t2.setText((CtoF(temp))+ " F");
	    }
	} catch (NumberFormatException x) {
	    t.setText("Enter a Valid Number");
	}
    }
    
    public static void main(String[] args) {
	TemperatureWindow a = new TemperatureWindow();
	a.setVisible(true);
    }
}
