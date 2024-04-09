package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import been.Hang;
import bo.Hangbo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmQLH extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_MH;
	private JTextField textField_TH;
	private JTextField textField_NNH;
	private JTextField textField_SL;
	private JTextField textField_gia;
	private JTable table;
	Hangbo hbo = new Hangbo();

	void napBang(ArrayList<Hang> ds) {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Ma hang");
		mh.addColumn("Ten hang");
		mh.addColumn("Ngay nhap hang");
		mh.addColumn("So Luong");
		mh.addColumn("Gia");
		for(Hang h : ds) {
			Object[] tmp = new Object[5];
			tmp[0] = h.getMaHang();
			tmp[1] = h.getTenHang();
			tmp[2] = f.format(h.getNgayNhapHang());
			tmp[3] = h.getSoLuong();
			tmp[4] = h.getGia();
			mh.addRow(tmp);
		}
		table.setModel(mh);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQLH frame = new FrmQLH();
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
	public FrmQLH() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					hbo.luuVaoCSDL("hang.txt");
					napBang(hbo.getDS());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ma hang");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(32, 10, 65, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblTenHang = new JLabel("Ten hang");
		lblTenHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenHang.setBounds(32, 46, 65, 26);
		contentPane.add(lblTenHang);
		
		JLabel lblNgayNhapHang = new JLabel("Ngay nhap hang");
		lblNgayNhapHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgayNhapHang.setBounds(32, 82, 113, 26);
		contentPane.add(lblNgayNhapHang);
		
		JLabel lblSoLuong = new JLabel("So luong");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoLuong.setBounds(32, 118, 65, 26);
		contentPane.add(lblSoLuong);
		
		JLabel lblGia = new JLabel("Gia");
		lblGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGia.setBounds(32, 154, 65, 26);
		contentPane.add(lblGia);
		
		textField_MH = new JTextField();
		textField_MH.setBounds(160, 16, 297, 19);
		contentPane.add(textField_MH);
		textField_MH.setColumns(10);
		
		textField_TH = new JTextField();
		textField_TH.setColumns(10);
		textField_TH.setBounds(160, 52, 297, 19);
		contentPane.add(textField_TH);
		
		textField_NNH = new JTextField();
		textField_NNH.setColumns(10);
		textField_NNH.setBounds(160, 88, 297, 19);
		contentPane.add(textField_NNH);
		
		textField_SL = new JTextField();
		textField_SL.setColumns(10);
		textField_SL.setBounds(160, 124, 297, 19);
		contentPane.add(textField_SL);
		
		textField_gia = new JTextField();
		textField_gia.setColumns(10);
		textField_gia.setBounds(160, 160, 297, 19);
		contentPane.add(textField_gia);
		
		JButton btnNewButton_them = new JButton("Them");
		btnNewButton_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
				    String maHang = textField_MH.getText();
				    if(maHang.equals("")) {
				    	JOptionPane.showMessageDialog(null, "Vui long nhap ma hang!");
				    	return;
				    }
				    String tenHang = textField_TH.getText();
				    Date ngayNhapHang = textField_NNH.getText().equals("")? new Date() : f.parse(textField_NNH.getText());
				    int soLuong = textField_SL.getText().equals("")? 0 : Integer.parseInt(textField_SL.getText());
				    float gia = textField_gia.getText().equals("")? 0 : Float.parseFloat(textField_gia.getText());
				    hbo.them(maHang, tenHang, ngayNhapHang, soLuong, gia);
				    napBang(hbo.getDS());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		btnNewButton_them.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_them.setBounds(559, 15, 104, 21);
		contentPane.add(btnNewButton_them);
		
		JButton btnNewButton_xoa = new JButton("Xoa");
		btnNewButton_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String maHang = textField_MH.getText();
					if(maHang.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui long nhap ma hang!");
						return;
					}
					hbo.xoa(maHang);
					napBang(hbo.getDS());
				} catch (Exception E) {
					E.printStackTrace();
				}
				
			}
		});
		btnNewButton_xoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_xoa.setBounds(559, 51, 104, 21);
		contentPane.add(btnNewButton_xoa);
		
		JButton btnNewButton_sua = new JButton("Sua");
		btnNewButton_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
					String maHang = textField_MH.getText();
					if(maHang.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui long nhap ma hang!");
						return;
					}
					for(Hang h : hbo.getDS()) {
						if(h.getMaHang().equals(maHang)) {
						    String tenHang = textField_TH.getText().equals("")? h.getTenHang() : textField_TH.getText();
						    Date ngayNhapHang = textField_NNH.getText().equals("")? h.getNgayNhapHang() : f.parse(textField_NNH.getText());;
						    int soLuong = textField_SL.getText().equals("")? h.getSoLuong() : Integer.parseInt(textField_SL.getText());
						    float gia = textField_gia.getText().equals("")? h.getGia() : Float.parseFloat(textField_gia.getText());
						    hbo.sua(maHang, tenHang, ngayNhapHang, soLuong, gia);
						    break;
						}
					}
					napBang(hbo.getDS());
				} catch (Exception E) {
					E.printStackTrace();
				}
	
			}
		});
		btnNewButton_sua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_sua.setBounds(559, 88, 104, 21);
		contentPane.add(btnNewButton_sua);
		
		JButton btnNewButton_timKiem = new JButton("Tim kiem");
		btnNewButton_timKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(btnNewButton_timKiem.getText().equals("Huy tim")) {
						napBang(hbo.getDS());
						btnNewButton_timKiem.setText("Tim kiem");
						return;
					}
					String tenHang = textField_TH.getText();
					if(tenHang.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui long nhap ten hang can tim!");
						return;
					}
					napBang(hbo.timKiem(tenHang));
					btnNewButton_timKiem.setText("Huy tim");
					
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		btnNewButton_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_timKiem.setBounds(559, 123, 104, 21);
		contentPane.add(btnNewButton_timKiem);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(32, 233, 702, 302);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
