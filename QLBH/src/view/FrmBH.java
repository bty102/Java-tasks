package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import been.Hang;
import bo.Hangbo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmBH extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_SL;
	private JTextField textField_SLC;
	private JTextField textField_gia;
	private JTextField textField_TT;
	JComboBox comboBox_hang;
	Hangbo hbo = new Hangbo();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBH frame = new FrmBH();
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
	public FrmBH() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					for(Hang h : hbo.getDS()) {
						comboBox_hang.addItem(h.getTenHang());
					}
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chon hang");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(83, 34, 74, 34);
		contentPane.add(lblNewLabel);
		
		comboBox_hang = new JComboBox();
		comboBox_hang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					String tenHang = comboBox_hang.getSelectedItem().toString();
					for(Hang h : hbo.getDS()) {
						if(h.getTenHang().equals(tenHang)) {
							textField_SL.setText(String.valueOf(h.getSoLuong()));
							textField_gia.setText(String.valueOf(h.getGia()));
						}
					}
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		comboBox_hang.setBounds(217, 43, 311, 21);
		contentPane.add(comboBox_hang);
		
		JLabel lblSoLuong = new JLabel("So luong");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoLuong.setBounds(98, 110, 59, 34);
		contentPane.add(lblSoLuong);
		
		textField_SL = new JTextField();
		textField_SL.setEditable(false);
		textField_SL.setBounds(217, 120, 311, 19);
		contentPane.add(textField_SL);
		textField_SL.setColumns(10);
		
		JLabel lblSoLuongCan = new JLabel("So luong can");
		lblSoLuongCan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoLuongCan.setBounds(69, 177, 88, 34);
		contentPane.add(lblSoLuongCan);
		
		textField_SLC = new JTextField();
		textField_SLC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					if(e.getKeyChar() < '0' || e.getKeyChar() > '9') {
						JOptionPane.showMessageDialog(null, "Gia tri khong hop le!");
						textField_SLC.setText("");
						textField_TT.setText("");
						return;
					}
					int SLC = Integer.parseInt(textField_SLC.getText()+String.valueOf(e.getKeyChar()));
					int SL = Integer.parseInt(textField_SL.getText());
					if(SLC > SL) {
						JOptionPane.showMessageDialog(null, "Vuot qua so luong con lai!\nVui long nhap lai!");
						textField_SLC.setText("");
						textField_TT.setText("");
						return;
					}
					float gia = Float.parseFloat(textField_gia.getText());
					textField_TT.setText(String.valueOf(gia*SLC));

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		textField_SLC.setBounds(217, 187, 311, 19);
		contentPane.add(textField_SLC);
		textField_SLC.setColumns(10);
		
		JLabel lblGia = new JLabel("Gia");
		lblGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGia.setBounds(135, 243, 22, 34);
		contentPane.add(lblGia);
		
		textField_gia = new JTextField();
		textField_gia.setEditable(false);
		textField_gia.setColumns(10);
		textField_gia.setBounds(217, 253, 311, 19);
		contentPane.add(textField_gia);
		
		JLabel lblThanhTien = new JLabel("Thanh tien");
		lblThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThanhTien.setBounds(84, 305, 73, 34);
		contentPane.add(lblThanhTien);
		
		textField_TT = new JTextField();
		textField_TT.setEditable(false);
		textField_TT.setColumns(10);
		textField_TT.setBounds(217, 315, 311, 19);
		contentPane.add(textField_TT);
		
		JButton btnNewButton_mua = new JButton("Mua");
		btnNewButton_mua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField_SLC.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Chua co so luong can!!");
						return;
					}
					int SLC = Integer.parseInt(textField_SLC.getText());
					String tenHang = comboBox_hang.getSelectedItem().toString();
					for(Hang h : hbo.getDS()) {
						if(h.getTenHang().equals(tenHang)) {
							int tmp = h.getSoLuong();
							hbo.sua(h.getMaHang(), h.getTenHang(), h.getNgayNhapHang(), h.getSoLuong()-SLC, h.getGia());
							JOptionPane.showMessageDialog(null, "Da mua thanh cong!!!");
							textField_SL.setText(String.valueOf(tmp-SLC));
							break;
						}
					}
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		btnNewButton_mua.setBounds(323, 392, 85, 50);
		contentPane.add(btnNewButton_mua);
	}
}
