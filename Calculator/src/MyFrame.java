import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class MyFrame extends JFrame {

	private JPanel contentPane;
	
	static String display="0";
	static int symbol;
	static boolean point=false;
	static double ten=10;
	static double result=0;
	static double next=0;
	private JTextField txtResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button_2 = new Button("%");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(symbol==0||symbol==5) result/=100;
				else next/=100;
				display+="%";
				txtResult.setText(display);
			}
		});
		button_2.setBounds(200, 100, 100,100);
		contentPane.add(button_2);
		
		Button button = new Button("AC");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display="0";
				result=0;
				next=0;

				txtResult.setText(display);
			}
		});
		button.setBounds(0, 100, 100, 100);
		contentPane.add(button);
		
		Button button_3 = new Button("\u00F7");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch(symbol){
				case 1:result+=next;break;
				case 2:result-=next;break;
				case 3:result*=next;break;
				case 4:result/=next;break;
				}
				
				display+="\u00F7";
				symbol=4;
				ten=10;
				next=0;
				point=false;
				txtResult.setText(display);
			}
		});
		button_3.setBounds(300, 100, 100, 100);
		contentPane.add(button_3);
		
		Button button_1 = new Button("\u00B1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(symbol==0) result=-result;
				else next=-next;
				txtResult.setText(display);
			}
		});
		button_1.setBounds(100, 100, 100, 100);
		contentPane.add(button_1);
		
		Button button_4 = new Button("7");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(symbol==5||display=="0"){display="7";symbol=0;result=0;}
				else display+=7;
				
				if(symbol==0) {
					if(!point) result=result*10+7;
					else {
						result+=7/ten;
						ten*=10;
					}
				}
				else {
					if(!point) next=next*10+7;
					else {
						next=next+7/ten;
						ten*=10;
					}
				}
				txtResult.setText(display);
			}
		});
		button_4.setBounds(0, 200, 100, 100);
		contentPane.add(button_4);
		
		Button button_5 = new Button("8");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(symbol==5||display=="0"){display="8";symbol=0;result=0;}
				else display+=8;
				
				if(symbol==0) {
					if(!point) result=result*10+8;
					else {
						result+=8/ten;
						ten*=10;
					}
				}
				else {
					if(!point) next=next*10+8;
					else {
						next=next+8/ten;
						ten*=10;
					}
				}
				txtResult.setText(display);
			}
		});
		button_5.setBounds(100, 200, 100, 100);
		contentPane.add(button_5);
		
		Button button_6 = new Button("9");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(symbol==5||display=="0"){display="9";symbol=0;result=0;}
				else display+=9;
				
				if(symbol==0) {
					if(!point) result=result*10+9;
					else {
						result+=9/ten;
						ten*=10;
					}
				}
				else {
					if(!point) next=next*10+9;
					else {
						next=next+9/ten;
						ten*=10;
					}
				}
				txtResult.setText(display);
			}
		});
		button_6.setBounds(200, 200, 100, 100);
		contentPane.add(button_6);
		
		Button button_7 = new Button("\u00D7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(symbol){
				case 1:result+=next;break;
				case 2:result-=next;break;
				case 3:result*=next;break;
				case 4:result/=next;break;
				}
				display+="\u00D7";
				symbol=3;
				ten=10;
				next=0;
				point=false;
				txtResult.setText(display);
			}
		});
		button_7.setBounds(300, 200, 100, 100);
		contentPane.add(button_7);
		
		Button button_8 = new Button("4");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(symbol==5||display=="0"){display="4";symbol=0;result=0;}
				else display+=4;
				
				if(symbol==0) {
					if(!point) result=result*10+4;
					else {
						result+=4/ten;
						ten*=10;
					}
				}
				else {
					if(!point) next=next*10+4;
					else {
						next=next+4/ten;
						ten*=10;
					}
				}
				txtResult.setText(display);
			}
		});
		button_8.setBounds(0, 300, 100, 100);
		contentPane.add(button_8);
		
		Button button_9 = new Button("5");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(symbol==5||display=="0"){display="5";symbol=0;result=0;}
				else display+=5;
				
				if(symbol==0) {
					if(!point) result=result*10+5;
					else {
						result+=5/ten;
						ten*=10;
					}
				}
				else {
					if(!point) next=next*10+5;
					else {
						next=next+5/ten;
						ten*=10;
					}
				}
				txtResult.setText(display);
			}
		});
		button_9.setBounds(100, 300, 100, 100);
		contentPane.add(button_9);
		
		Button button_10 = new Button("6");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(symbol==5||display=="0"){display="6";symbol=0;result=0;}
				else display+=6;
				
				if(symbol==0) {
					if(!point) result=result*10+6;
					else {
						result+=6/ten;
						ten*=10;
					}
				}
				else {
					if(!point) next=next*10+6;
					else {
						next=next+6/ten;
						ten*=10;
					}
				}
				txtResult.setText(display);
			}
		});
		button_10.setBounds(200, 300, 100, 100);
		contentPane.add(button_10);
		
		Button button_12 = new Button("1");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(symbol==5||display=="0"){display="1";symbol=0;result=0;}
				else display+=1;
				
				if(symbol==0) {
					if(!point) result=result*10+1;
					else {
						result+=1/ten;
						ten*=10;
					}
				}
				else {
					if(!point) next=next*10+1;
					else {
						next=next+1/ten;
						ten*=10;
					}
				}
				txtResult.setText(display);
			}
		});
		button_12.setBounds(0, 400, 100, 100);
		contentPane.add(button_12);
		
		Button button_11 = new Button("-");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(symbol){
				case 1:result+=next;break;
				case 2:result-=next;break;
				case 3:result*=next;break;
				case 4:result/=next;break;
				default:break;
				}
				display+="-";
				symbol=2;
				ten=10;
				next=0;
				point=false;
				txtResult.setText(display);
			}
		});
		button_11.setBounds(300, 300, 100, 100);
		contentPane.add(button_11);
		
		Button button_13 = new Button("2");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(symbol==5||display=="0"){display="2";symbol=0;result=0;}
				else display+=2;
				
				if(symbol==0) {
					if(!point) result=result*10+2;
					else {
						result+=2/ten;
						ten*=10;
					}
				}
				else {
					if(!point) next=next*10+2;
					else {
						next=next+2/ten;
						ten*=10;
					}
				}
				txtResult.setText(display);
			}
		});
		button_13.setBounds(100, 400, 100, 100);
		contentPane.add(button_13);
		
		Button button_15 = new Button("+");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(symbol){
				case 1:result+=next;break;
				case 2:result-=next;break;
				case 3:result*=next;break;
				case 4:result/=next;break;
				}
				display+="+";
				symbol=1;
				next=0;
				ten=10;
				point=false;
				txtResult.setText(display);
			}
		});
		button_15.setBounds(300, 400, 100, 100);
		contentPane.add(button_15);
		
		Button button_14 = new Button("3");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(symbol==5||display=="0"){display="3";symbol=0;result=0;}
				else display+=3;
				
				if(symbol==0) {
					if(!point) result=result*10+3;
					else {
						result+=3/ten;
						ten*=10;
					}
				}
				else {
					if(!point) next=next*10+3;
					else {
						next=next+3/ten;
						ten*=10;
					}
				}
				txtResult.setText(display);
			}
		});
		button_14.setBounds(200, 400, 100, 100);
		contentPane.add(button_14);
		
		Button button_16 = new Button("0");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(symbol==5||display=="0"){display="0";symbol=0;result=0;}
				else display+=0;
				
				if(symbol==0) {
					if(!point) result=result*10+0;
					else {
						result+=0/ten;
						ten*=10;
					}
				}
				else {
					if(!point) next=next*10+0;
					else {
						next=next+0/ten;
						ten*=10;
					}
				}
				txtResult.setText(display);
			}
		});
		button_16.setBounds(0, 500, 200, 100);
		contentPane.add(button_16);
		
		Button button_17 = new Button(".");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display+=".";
				point=true;
				txtResult.setText(display);
			}
		});
		button_17.setBounds(200, 500, 100, 100);
		contentPane.add(button_17);
		
		Button button_18 = new Button("=");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(next!=0){
					switch(symbol){
				case 1:result+=next;break;
				case 2:result-=next;break;
				case 3:result*=next;break;
				case 4:result/=next;break;
				}
				}
				txtResult.setText((float)result+"");
				display=result+"";
				next=0;
				ten=10;
				symbol=5;
				point=false;
			}
		});
		button_18.setBounds(300, 500, 100, 100);
		contentPane.add(button_18);
		
		txtResult = new JTextField();
		txtResult.setForeground(Color.WHITE);
		txtResult.setBackground(Color.BLACK);
		txtResult.setBounds(0, -6, 400, 100);
		contentPane.add(txtResult);
		txtResult.setColumns(10);
	}
}
