package main;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Frame extends JFrame implements MouseListener{

	static final String title = "ÅõÅ~ÉQÅ[ÉÄ";
	static final int x = 128 * 3,y = 128 * 3;
	private int px,py,turn = 0;
	private int[] flg = { 10,11,12,13,14,15,16,17,18}; 
	ImageIcon maru = new ImageIcon("C:/Users/n1220145.STCN/workspace/marubatu/src/main/maru.png");
	ImageIcon batu = new ImageIcon("C:/Users/n1220145.STCN/workspace/marubatu/src/main/batu.png");
	JLabel lab[] = new JLabel[10];
	
	public Frame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setSize(x,y);
		this.addMouseListener(this);
		frame_ini();
	}
	private void frame_ini(){
		JPanel p = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		p.setLayout(layout);
		
		ImageIcon icon = new ImageIcon("C:/Users/n1220145.STCN/workspace/marubatu/src/main/mu.png");
		
		JLabel lab1 = new JLabel(icon);
		JLabel lab2 = new JLabel(icon);
		JLabel lab3 = new JLabel(icon);
		JLabel lab4 = new JLabel(icon);
		JLabel lab5 = new JLabel(icon);
		JLabel lab6 = new JLabel(icon);
		JLabel lab7 = new JLabel(icon);
		JLabel lab8 = new JLabel(icon);
		JLabel lab9 = new JLabel(icon);
		
		lab[0] = lab1;
		lab[1] = lab2;
		lab[2] = lab3;
		lab[3] = lab4;
		lab[4] = lab5;
		lab[5] = lab6;
		lab[6] = lab7;
		lab[7] = lab8;
		lab[8] = lab9;
		
		int gx = 0, gy = 0,i = 0;
		GridBagConstraints gbc = new GridBagConstraints();
		for(i = 0; i < 9; i++){
			gbc.gridx = gx;
			gbc.gridy = gy;
			layout.setConstraints(lab[i], gbc);
			gx++;
			if(gx > 2){
				gx = 0;
				gy++;
			}
		}
		i = 0;
		while(i < 9){
			p.add(lab[i]);
			i++;
		}
		getContentPane().add(p, BorderLayout.CENTER);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Point point = e.getPoint();
		if(point.x < 129){
			px = 0;
		}else if(point.x < 257){
			px = 1;
		}else {
			px = 2;
		}
		
		if(point.y < 129){
			py = 0;
		}else if(point.y < 257){
			py = 1;
		}else {
			py = 2;
		}
		int pos = px + (py * 3);
		if(flg[pos] >= 10){
			if(turn == 0){
				lab[pos].setIcon(maru);
				flg[pos] = 1;
			}else{
				lab[pos].setIcon(batu);
				flg[pos] = 2;
			}
			int i = 0;
			while(i < 9){
				if(flg[i] > 10){
					break;
				}
				i++;
			}
			if(i == 9){
				JOptionPane.showMessageDialog(null,"à¯Ç´ï™ÇØ");
				System.exit(0);
			}
			if(flg[0] == flg[1] && flg[1] == flg[2] ||
					flg[0] == flg[3] && flg[3] == flg[6] ||
					flg[2] ==flg[5] && flg[5] == flg[8]  ||
					flg[6] == flg[7] && flg[7] == flg[8] ||
					flg[0] == flg[4] && flg[4] ==flg[8]  ||
					flg[2] == flg[4] && flg[4] == flg[6] ||
					flg[1] == flg[4] && flg[4] == flg[7] ||
					flg[3] == flg[4] && flg[4] == flg[5]){
				if(turn == 0){
					JOptionPane.showMessageDialog(null,"ÅõÇÃèüÇø");
					System.exit(0);
				}else{
					JOptionPane.showMessageDialog(null,"Å~ÇÃèüÇø");
					System.exit(0);
				}
			}
			turn = (turn+1)%2;
		}
		}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
