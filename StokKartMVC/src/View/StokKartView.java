package View;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import Controller.StokKartController;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;



public class StokKartView extends JFrame {

    public static JPanel ctpMain;
    public static JTextField stokkodu;
    public static JTextField stokadi;
    public static JTextField stokbarkodu;
    public static JTable table;
    public static JComboBox stoktipi,stokbirimi,stokkdvtipi;
    public static JTextArea stokaciklama;
    public static JFormattedTextField stokolusturmatarihi;
    public static JFrame StokKoduPaneli;
    public static JTextField stokkodukopyala;
    public static String stokkodukop;
    public static JPanel contentPane;
    /**
     * Launch the application.
     */
   

    /**
     * Create the frame.
     */
    public StokKartView() {
    	setTitle("STOK KARTI");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1110, 530);
	ctpMain = new JPanel();
	ctpMain.setBackground(new Color(192, 192, 192));
	ctpMain.setBorder(new EmptyBorder(10, 10, 10, 10));
	setContentPane(ctpMain);
	
	
	
	JButton btnNewButton = new JButton("Ara");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    StokKartController.Ara();
		}
	});
	
	JButton btnNewButton_1 = new JButton("Ekle");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    StokKartController.Ekle();
		    StokKartController.Listele();
		}
	});
	
	JButton btnNewButton_2 = new JButton("Güncelle");
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    StokKartController.Guncelle();
		    StokKartController.Listele();
		}
	});
	
	JButton btnNewButton_3 = new JButton("Listele");
	btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    StokKartController.Listele();
		}
	});
	
	JButton btnNewButton_4 = new JButton("Sil");
	btnNewButton_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    StokKartController.Sil();
		    StokKartController.Listele();
		}
	});
	btnNewButton_4.setHorizontalAlignment(SwingConstants.LEADING);
	
	JLabel lblNewLabel = new JLabel("Stok Kodu");
	
	JLabel lblNewLabel_1 = new JLabel("Stok Adı");
	
	stokkodu = new JTextField();
	stokkodu.setColumns(10);
	
	stokadi = new JTextField();
	stokadi.setColumns(10);
	stokadi.setEditable(true);
	
	JLabel lblNewLabel_2 = new JLabel("Stok Tipi");
	
	stoktipi = new JComboBox();
	stoktipi.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));

	
	JLabel lblNewLabel_3 = new JLabel("Birimi");
	
	stokbirimi = new JComboBox();
	stokbirimi.setModel(new DefaultComboBoxModel(new String[] {"Kg", "Adet", "Ton", "Kutu", "Metre"}));
	
	JLabel lblNewLabel_4 = new JLabel("Barkodu");
	
	stokbarkodu = new JTextField();
	stokbarkodu.setColumns(10);
	
	JLabel lblNewLabel_5 = new JLabel("KDV Tipi");
	
	stokkdvtipi = new JComboBox();
	stokkdvtipi.setModel(new DefaultComboBoxModel(new String[] {"0.18", "0.08", "0.01"}));
	
	JLabel lblNewLabel_6 = new JLabel("Açıklama");
	
	stokaciklama = new JTextArea();
	
	JLabel lblNewLabel_7 = new JLabel("Tarih");
	
	stokolusturmatarihi = new JFormattedTextField();
	
	table = new JTable();
	
	table.addKeyListener(new KeyAdapter() { // Klavye ile aşağı yukarı
		@Override
		public void keyPressed(KeyEvent e) {
		    if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			StokKartView.stokkodu.setText(
				    (String) StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow()+1, 0));
			    StokKartView.stokadi.setText(
				    (String) StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow()+1, 1));
			    StokKartView.stokbarkodu.setText(
				    (String) StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow()+1, 4));
			    StokKartView.stoktipi.setSelectedItem(
				    StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow()+1, 2));
			    StokKartView.stokbirimi.setSelectedItem(
				    StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow()+1, 3));
			    StokKartView.stokkdvtipi.setSelectedItem(
				    StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow()+1, 5));
			    StokKartView.stokaciklama.setText(
				    (String) StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow()+1, 6));
			    StokKartView.stokolusturmatarihi.setText(
				    (String) StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow()+1, 7));
		    }
		    
		    else if(e.getKeyCode()==KeyEvent.VK_UP) {
			
			StokKartView.stokkodu.setText(
				    (String) StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow()-1, 0));
			    StokKartView.stokadi.setText(
				    (String) StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow()-1, 1));
			    StokKartView.stokbarkodu.setText(
				    (String) StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow()-1, 4));
			    StokKartView.stoktipi.setSelectedItem(
				    StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow()-1, 2));
			    StokKartView.stokbirimi.setSelectedItem(
				    StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow()-1, 3));
			    StokKartView.stokkdvtipi.setSelectedItem(
				    StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow(), 5));
			    StokKartView.stokaciklama.setText(
				    (String) StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow()-1, 6));
			    StokKartView.stokolusturmatarihi.setText(
				    (String) StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow()-1, 7));
		    } 
		}
	});
	table.setSurrendersFocusOnKeystroke(true);
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	table.setRowSelectionAllowed(true);
	table.setShowVerticalLines(true);
	table.setShowHorizontalLines(true);
	table.setShowGrid(true);
	table.setVisible(true);
	table.getRowSelectionAllowed();
	
	
	
	
	
	
	    StokKartView.table.addMouseListener(new MouseAdapter() { // Mouse tıklama
		    public void mouseClicked( MouseEvent event) {
			
			    
			    StokKartView.stokkodu.setText(
				    (String) StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow(), 0));
			    StokKartView.stokadi.setText(
				    (String) StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow(), 1));
			    StokKartView.stokbarkodu.setText(
				    (String) StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow(), 4));
			    StokKartView.stoktipi.setSelectedItem(
				    StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow(), 2));
			    StokKartView.stokbirimi.setSelectedItem(
				    StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow(), 3));
			    StokKartView.stokkdvtipi.setSelectedItem(
				    StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow(), 5));
			    StokKartView.stokaciklama.setText(
				    (String) StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow(), 6));
			    StokKartView.stokolusturmatarihi.setText(
				    (String) StokKartController.modelim.getValueAt(StokKartView.table.getSelectedRow(), 7));
			    
			
		    }

		    
		});
		
	 
	
	stokkodu.setVisible(true);
	stokadi.setVisible(true);
	stoktipi.setVisible(true);
	stokbirimi.setVisible(true);
	stokbarkodu.setVisible(true);
	stokkdvtipi.setVisible(true);
	stokaciklama.setVisible(true);
	stokolusturmatarihi.setVisible(true);
	JButton btnNewButton_5 = new JButton("Kopyala");
	btnNewButton_5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    StokKoduPanel();
		    
		}
	});
	
	JLabel lblNewLabel_8 = new JLabel("Stok Kod");
	lblNewLabel_8.setPreferredSize(new Dimension(135, 30));
	
	JLabel lblNewLabel_8_1 = new JLabel("Stok Adı");
	lblNewLabel_8_1.setPreferredSize(new Dimension(135, 30));
	
	JLabel lblNewLabel_8_2 = new JLabel("Stok Tipi");
	lblNewLabel_8_2.setPreferredSize(new Dimension(135, 30));
	
	JLabel lblNewLabel_8_1_1 = new JLabel("Birimi");
	lblNewLabel_8_1_1.setPreferredSize(new Dimension(135, 30));
	
	JLabel lblNewLabel_8_3 = new JLabel("Barkodu");
	lblNewLabel_8_3.setPreferredSize(new Dimension(135, 30));
	
	JLabel lblNewLabel_8_2_1 = new JLabel("KDV Tipi");
	lblNewLabel_8_2_1.setPreferredSize(new Dimension(135, 30));
	
	JLabel lblNewLabel_8_2_1_1 = new JLabel("Tarih");
	lblNewLabel_8_2_1_1.setPreferredSize(new Dimension(135, 30));
	
	JLabel lblNewLabel_8_1_1_1 = new JLabel("Açıklama");
	lblNewLabel_8_1_1_1.setPreferredSize(new Dimension(135, 30));
	GroupLayout gl_ctpMain = new GroupLayout(ctpMain);
	gl_ctpMain.setHorizontalGroup(
		gl_ctpMain.createParallelGroup(Alignment.TRAILING)
			.addGroup(gl_ctpMain.createSequentialGroup()
				.addContainerGap()
				.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_ctpMain.createSequentialGroup()
						.addComponent(lblNewLabel)
						.addGap(18)
						.addComponent(stokkodu, 239, 239, 239))
					.addGroup(gl_ctpMain.createSequentialGroup()
						.addComponent(lblNewLabel_6)
						.addGap(25)
						.addComponent(stokaciklama, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
					.addGroup(gl_ctpMain.createSequentialGroup()
						.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_1)
							.addComponent(lblNewLabel_2)
							.addComponent(lblNewLabel_3)
							.addComponent(lblNewLabel_4)
							.addComponent(lblNewLabel_5))
						.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
						.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(stokkdvtipi, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(stokbarkodu, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
							.addComponent(stokbirimi, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(stoktipi, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(stokadi, Alignment.LEADING, 239, 239, Short.MAX_VALUE)))
					.addGroup(gl_ctpMain.createSequentialGroup()
						.addComponent(lblNewLabel_7)
						.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
						.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_ctpMain.createSequentialGroup()
								.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton_3))
								.addGap(26)
								.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton_1))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton_5)))
							.addComponent(stokolusturmatarihi, 239, 239, 239))))
				.addGap(18)
				.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_ctpMain.createSequentialGroup()
						.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_8_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNewLabel_8_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblNewLabel_8_3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblNewLabel_8_1_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addGap(25)
						.addComponent(lblNewLabel_8_2_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_8_1_1_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_8_2_1_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	);
	gl_ctpMain.setVerticalGroup(
		gl_ctpMain.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_ctpMain.createSequentialGroup()
				.addGap(36)
				.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(stokkodu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addComponent(lblNewLabel_8_2_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNewLabel_8_1_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8_2_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
					.addComponent(table, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
					.addGroup(gl_ctpMain.createSequentialGroup()
						.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(stokadi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2)
							.addComponent(stoktipi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_3)
							.addComponent(stokbirimi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_4)
							.addComponent(stokbarkodu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_5)
							.addComponent(stokkdvtipi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_6)
							.addComponent(stokaciklama, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_7)
							.addComponent(stokolusturmatarihi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
						.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_ctpMain.createSequentialGroup()
								.addComponent(btnNewButton_1)
								.addGap(11)
								.addComponent(btnNewButton_4))
							.addGroup(gl_ctpMain.createSequentialGroup()
								.addComponent(btnNewButton)
								.addGap(11)
								.addComponent(btnNewButton_3))
							.addGroup(gl_ctpMain.createSequentialGroup()
								.addComponent(btnNewButton_2)
								.addGap(11)
								.addComponent(btnNewButton_5)))))
				.addGap(11))
	);
	ctpMain.setLayout(gl_ctpMain);
	
    }
    
    
    public void StokKoduPanel() { // Kopyala için mini panel
	
	StokKoduPaneli = new JFrame();
	StokKoduPaneli.setBounds(100, 100, 280, 120);
	StokKoduPaneli.setVisible(true);
	StokKoduPaneli.setTitle("Stok Kodu Giriniz");
	
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	StokKoduPaneli.setContentPane(contentPane);
	
	stokkodukopyala = new JTextField();
	contentPane.add(stokkodukopyala);
	stokkodukopyala.setColumns(20);
	
	JButton kopyala = new JButton("New button");
	contentPane.add(kopyala);
	
	kopyala.setText("Tamam");
	kopyala.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    
		    stokkodukop=stokkodukopyala.getText(); //dispose ile kapatmak için içerideki text'i değişkene atadım.
		    StokKartController.Kopyala();
		    StokKartController.Listele();
		    StokKoduPaneli.dispose();
		}
	});
	
    } 
}


