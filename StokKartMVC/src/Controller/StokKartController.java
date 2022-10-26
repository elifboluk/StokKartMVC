package Controller;

import Model.StokKartModel;
import View.StokKartView;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connect.DatabaseConnect;

public class StokKartController {

    public static DefaultTableModel modelim;
    static Object[] kolonlar = { "stok_kodu", "stok_adi", "stok_tipi", "birimi", "barkodu", "kdv_tipi", "aciklama", "olusturma_tarihi" };
    static Object[] satirlar = new Object[8];
    

    public static void Ekle() {
	StokKartModel.stok_kodu = StokKartView.stokkodu.getText();
	StokKartModel.stok_adi = StokKartView.stokadi.getText();
	StokKartModel.stok_tipi = Integer.valueOf(StokKartView.stoktipi.getSelectedItem().toString());
	StokKartModel.birimi = StokKartView.stokbirimi.getSelectedItem().toString();
	StokKartModel.barkodu = StokKartView.stokbarkodu.getText();
	StokKartModel.kdv_tipi = Double.valueOf(StokKartView.stokkdvtipi.getSelectedItem().toString());
	StokKartModel.aciklama = StokKartView.stokaciklama.getText();
	StokKartModel.olusturma_tarihi = Date.valueOf(StokKartView.stokolusturmatarihi.getText());

	StokKartModel.insert();
    }

    public static void Guncelle() {
	StokKartModel.stok_kodu = StokKartView.stokkodu.getText();
	StokKartModel.stok_adi = StokKartView.stokadi.getText();
	StokKartModel.stok_tipi = Integer.valueOf(StokKartView.stoktipi.getSelectedItem().toString());
	StokKartModel.birimi = StokKartView.stokbirimi.getSelectedItem().toString();
	StokKartModel.barkodu = StokKartView.stokbarkodu.getText();
	StokKartModel.kdv_tipi = Double.valueOf(StokKartView.stokkdvtipi.getSelectedItem().toString());
	StokKartModel.aciklama = StokKartView.stokaciklama.getText();
	StokKartModel.olusturma_tarihi = Date.valueOf(StokKartView.stokolusturmatarihi.getText());

	StokKartModel.update();
    }

    public static void Sil() {
	StokKartModel.stok_kodu = StokKartView.stokkodu.getText();
	StokKartModel.delete();
    }

    public static void Listele() {
	try {
	    StokKartModel.conn = DatabaseConnect.getConnection();
	    Statement st = StokKartModel.conn.createStatement();
	    ResultSet rs = st.executeQuery("SELECT * FROM tblStoklar");
	    modelim = new DefaultTableModel();
	    modelim.setRowCount(0);
	    modelim.setColumnCount(0);
	    modelim.setColumnIdentifiers(kolonlar);
	    StokKartView.table.setModel(modelim);
	    while (rs.next()) {
		satirlar[0] = rs.getString("stok_kodu");
		satirlar[1] = rs.getString("stok_adi");
		satirlar[2] = rs.getString("stok_tipi");
		satirlar[3] = rs.getString("birimi");
		satirlar[4] = rs.getString("barkodu");
		satirlar[5] = rs.getString("kdv_tipi");
		satirlar[6] = rs.getString("aciklama");
		satirlar[7] = rs.getString("olusturma_tarihi");
		modelim.addRow(satirlar);
	    }
	    StokKartModel.conn.close();
	   
	} 
	
	catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    public static void Ara() //çalışıyor
    {
	int index=0;
	for(int i=0; i<StokKartView.table.getRowCount(); i++)
	{
	    if(StokKartView.table.getModel().getValueAt(i, 0).equals(StokKartView.stokkodu.getText()))
	    {
		index=i;
	    }
	}
	    
	    StokKartView.stokadi.setText(
		    (String) StokKartController.modelim.getValueAt(index, 1));
	    StokKartView.stokbarkodu.setText(
		    (String) StokKartController.modelim.getValueAt(index, 4));
	    StokKartView.stoktipi.setSelectedItem(
		    StokKartController.modelim.getValueAt(index, 2));
	    StokKartView.stokbirimi.setSelectedItem(
		    StokKartController.modelim.getValueAt(index, 3));
	    StokKartView.stokkdvtipi.setSelectedItem(
		    StokKartController.modelim.getValueAt(index, 5));
	    StokKartView.stokaciklama.setText(
		    (String) StokKartController.modelim.getValueAt(index, 6));
	    StokKartView.stokolusturmatarihi.setText(
		    (String) StokKartController.modelim.getValueAt(index, 7));
	    
	    StokKartView.table.changeSelection(index, 0, false, false);
	    
	    
    }
    
    public static void Kopyala() {
	StokKartModel.stok_kodu=StokKartView.stokkodukop;
	StokKartModel.stok_adi = StokKartView.stokadi.getText();
	StokKartModel.stok_tipi = Integer.valueOf(StokKartView.stoktipi.getSelectedItem().toString());
	StokKartModel.birimi = StokKartView.stokbirimi.getSelectedItem().toString();
	StokKartModel.barkodu = StokKartView.stokbarkodu.getText();
	StokKartModel.kdv_tipi = Double.valueOf(StokKartView.stokkdvtipi.getSelectedItem().toString());
	StokKartModel.aciklama = StokKartView.stokaciklama.getText();
	StokKartModel.olusturma_tarihi = Date.valueOf(StokKartView.stokolusturmatarihi.getText());

	StokKartModel.insert();
    }

}
