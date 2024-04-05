package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;

public class FrmDatabase extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	JComboBox comboBox;
	JList list;
	Connection cn;
	
	void ketNoi(String dbName) throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		cn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-94HP78LH\\BTY:1433;databaseName="+dbName+";user=sa;password=123;encrypt=false");
		System.out.println("Da ket noi vao CSDL");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDatabase frame = new FrmDatabase();
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
	public FrmDatabase() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					ketNoi("master");
					String sql = "select name from sys.databases";
					PreparedStatement cmd = cn.prepareStatement(sql);
					ResultSet rs = cmd.executeQuery();
					while(rs.next()) {
						comboBox.addItem(rs.getString(1));
					}
					cn.close();
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_chonDB = new JLabel("Chon Database");
		lblNewLabel_chonDB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_chonDB.setBounds(64, 10, 107, 32);
		contentPane.add(lblNewLabel_chonDB);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					
					String dbName = comboBox.getSelectedItem().toString();
					ketNoi(dbName);
					String sql = "select TABLE_NAME from INFORMATION_SCHEMA.TABLES";
					PreparedStatement cmd = cn.prepareStatement(sql);
					ResultSet rs = cmd.executeQuery();
					ArrayList<String> tableName = new ArrayList<String>();
					while(rs.next()) {
						tableName.add(rs.getString(1));
					}
					list.setListData(tableName.toArray());
					cn.close();
				} catch (Exception E) {
					E.printStackTrace();
				}
				
			}
		});
		comboBox.setBounds(237, 18, 304, 21);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 113, 167, 362);
		contentPane.add(scrollPane);
		
		list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try {
					Object tableName = list.getSelectedValue();
					if(tableName == null) return;
					ketNoi(comboBox.getSelectedItem().toString());
					String sql = "select * from "+tableName.toString();
					PreparedStatement cmd = cn.prepareStatement(sql);
					ResultSet rs = cmd.executeQuery();
					ResultSetMetaData rsm = rs.getMetaData();
					int sc = rsm.getColumnCount();
					DefaultTableModel mh = new DefaultTableModel();
					for(int i = 1; i <= sc; i++) {
						mh.addColumn(rsm.getColumnName(i));
					}
					while(rs.next()) {
						String[] rc = new String[sc];
						for(int i = 1; i <= sc; i++) {
							rc[i-1] = rs.getString(i); 
						}
						mh.addRow(rc);
					}
					table.setModel(mh);
					cn.close();
					
				} catch (Exception E) {
					E.printStackTrace();
				}		
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(237, 113, 486, 362);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane_1, null);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
	}
}
