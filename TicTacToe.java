import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class TicTacToe implements ActionListener {

	static JFrame f;
	static JTextField tf1;
	int r=0,u;
	//int a[][]= new int[3][3];
	static JButton b[]=new JButton[9];
	static JButton jb,jb1,jb2,jb3;	
	TicTacToe(){
		
		for(int i=0;i<b.length;i++)
		{
			b[i]= new JButton();
			b[i].setEnabled(false);
			b[i].addActionListener(this);
		}
		int k=-1;
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=3;j++)
			{
				JButton y=b[++k];
				y.setBounds(i*150,j*150,150,150);
				f.add(y);
			}
		}
		jb = new JButton("PLAY AGAINST HUMAN");
		jb.addActionListener(this);
		jb.setBounds(50,650,200,50);
		f.add(jb);
		
		jb1 = new JButton("PAUSE");
		jb1.addActionListener(this);
		jb1.setBounds(300,650,100,50);
		f.add(jb1);
		jb1.setEnabled(false);
		
		jb2 = new JButton("RESUME");
		jb2.addActionListener(this);
		jb2.setBounds(450,650,100,50);
		f.add(jb2);
		jb2.setEnabled(false);
		
		jb3 = new JButton("PLAY AGAINST COMPUTER");
		jb3.addActionListener(this);
		jb3.setBounds(600,650,200,50);
		f.add(jb3);
		
		tf1=new JTextField("FIRST PLAYER IS O AND SECOND PLAYER IS X");
		tf1.setBounds(150,10,450,40);
		tf1.setEnabled(false);
		
		f.add(tf1);
		
		f.setLayout(null);
		f.setSize(900,900);
		f.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		f = new JFrame("TicTacToe");
		new TicTacToe();

	}
	public static void check(String s){
		for(int i=0;i<3;i++)
		{
			if(b[3*i].getText()==s && b[3*i+1].getText()==s && b[3*i+2].getText()==s)
			{
				for(int j=0;j<9;j++)
				{
					b[j].setBackground(Color.WHITE);
					b[j].setEnabled(false);
				}
				jb1.setEnabled(false);
				jb2.setEnabled(false);
				b[3*i].setBorder(new LineBorder(Color.RED));
				b[3*i+1].setBorder(new LineBorder(Color.RED));
				b[3*i+2].setBorder(new LineBorder(Color.RED));
				b[3*i].setBackground(Color.GREEN);
				b[3*i+1].setBackground(Color.GREEN);
				b[3*i+2].setBackground(Color.GREEN);
				
				tf1.setText("team "+s+" won");
			}
		}
	}
	public static void check1(String s){
		for(int i=0;i<3;i++)
		{
			if(b[i].getText()==s && b[i+3].getText()==s && b[i+6].getText()==s)
			{
				for(int j=0;j<9;j++)
				{
					b[j].setBackground(Color.WHITE);
					b[j].setEnabled(false);
				}
				jb1.setEnabled(false);
				jb2.setEnabled(false);
				b[i].setBorder(new LineBorder(Color.RED));
				b[i+3].setBorder(new LineBorder(Color.RED));
				b[i+6].setBorder(new LineBorder(Color.RED));
				b[i].setBackground(Color.GREEN);
				b[i+3].setBackground(Color.GREEN);
				b[i+6].setBackground(Color.GREEN);
				
				tf1.setText("team "+s+" won");
			}
		}
	}
	public static void canIWin(){
		for(int i=0;i<9;i++)
		{
			
		}
	}
	public static void disable(JButton b){
		b.setText("X");
		b.setBackground(Color.white);
		b.setEnabled(false);
		
	}
	public static void computer(){
		
		canIWin();
		check("X");
		check("O");
		check1("X");
		check1("O");
		 Diagonalcheck1("O");
		 Diagonalcheck1("X");
		matchOver();
	}
	public static void Diagonalcheck1(String s){
			if(b[0].getText()==s && b[4].getText()==s && b[8].getText()==s)
			{
				for(int j=0;j<9;j++)
				{
					b[j].setBackground(Color.WHITE);
					b[j].setEnabled(false);
				}
				jb1.setEnabled(false);
				jb2.setEnabled(false);
				b[0].setBorder(new LineBorder(Color.RED));
				b[4].setBorder(new LineBorder(Color.RED));
				b[8].setBorder(new LineBorder(Color.RED));
				b[0].setBackground(Color.GREEN);
				b[4].setBackground(Color.GREEN);
				b[8].setBackground(Color.GREEN);
				
				tf1.setText("team "+s+" won");
			}
			if(b[2].getText()==s && b[4].getText()==s && b[6].getText()==s)
			{
				for(int j=0;j<9;j++)
				{
					b[j].setBackground(Color.WHITE);
					b[j].setEnabled(false);
				}
				jb1.setEnabled(false);
				jb2.setEnabled(false);
				b[2].setBorder(new LineBorder(Color.RED));
				b[4].setBorder(new LineBorder(Color.RED));
				b[6].setBorder(new LineBorder(Color.RED));
				b[2].setBackground(Color.GREEN);
				b[4].setBackground(Color.GREEN);
				b[6].setBackground(Color.GREEN);
				
				tf1.setText("team "+s+" won");
			}
			
			
	}
	public static void matchOver()
	{int k=0;
		for(int i=0;i<9;i++)
		 {
			 if(b[i].getText().equals(""))
			 {
				 
			 }
			 else{
				 k++;
			 }
		 }
		 if(k==9)
		 {
			jb1.setEnabled(false);
			tf1.setText("MATCH DRAW");
		 }
	}
	public static void win(){
		check("X");
		check("O");
		check1("X");
		check1("O");
		 Diagonalcheck1("O");
		 Diagonalcheck1("X");
		 matchOver();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb)
		{
			r=0;
			u=0;
			tf1.setText("FIRST PLAYER IS O AND SECOND PLAYER IS X");
			for(int i=0;i<9;i++)
			{
				b[i].setBackground(new Color(12, 247, 235));
				b[i].setText("");
				b[i].setEnabled(true);
				b[i].setBorder(new LineBorder(Color.BLACK));
			}
			jb1.setEnabled(true);
			
			
		}
		if(e.getSource()==jb1)
		{
			for(int i=0;i<9;i++)
			{
				b[i].setEnabled(false);
			}
			jb2.setEnabled(true);
			jb1.setEnabled(false);
			
		}
		if(e.getSource()==jb2)
		{
			for(int i=0;i<9;i++)
			{
				if(b[i].getText()=="")
				b[i].setEnabled(true);
			}
			jb2.setEnabled(false);
			jb1.setEnabled(true);
			
		}
		//lets play against computer 
		if(e.getSource()==jb3)
		{
		u=1;		
		tf1.setText("PLAYING AGAINST COMPUTER ,YOUR TEAM IS O");
		for(int i=0;i<9;i++)
		{
			b[i].setBackground(new Color(12, 247, 235));
			b[i].setText("");
			b[i].setEnabled(true);
			b[i].setBorder(new LineBorder(Color.BLACK));
		}
		jb1.setEnabled(true);
		
					
					
					
		}
				
		if(u==0)
		{
			for(int i=0;i<9;i++)
			{
				
				if(e.getSource()==b[i])
				{
					b[i].setBackground(Color.WHITE);
					b[i].setEnabled(false);
					if(r==0)
					{
						b[i].setText("O");
						r=1;
					}
					else{
						b[i].setText("X");
						r=0;
					}
				}
			}
			win();
		}
		if(u==1)
		{
			for(int i=0;i<9;i++)
			{
				if(e.getSource()==b[i])
				{
					b[i].setBackground(Color.WHITE);
					b[i].setEnabled(false);
					b[i].setText("O");
					computer();
				}
			}
		}
		
	}

}
