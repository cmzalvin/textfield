package cmz.alvin.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class  Demo extends JFrame{
	JTextField text=null,textshow=null;
	public static void main(String[] args) {
		new Demo();
	}
	
	public Demo(){
		this.setBounds(200,200,300,300);
		this.setLayout(new FlowLayout());
		text=new JTextField(10);
		textshow=new JTextField(10);
		textshow.setEditable(false);
		MonitorListener monitorlistener=new MonitorListener();
		//把textshow传入到monitorListener
		monitorlistener.setTextField(textshow);
		text.addActionListener(monitorlistener);
		this.add(text);
		this.add(textshow);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
class MonitorListener implements ActionListener{
	JTextField text=null;
	//把进入另一个textFiled
	public void setTextField(JTextField text){
		this.text=text;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int n=0,m=0;
		String str=e.getActionCommand();
		try{
			n=Integer.parseInt(str);
			m=n*n;
			//设置引入的TextFiled的内容
			text.setText(""+m);
		}catch(Exception ee){
			System.out.println(ee);
		}
	}
	
}

