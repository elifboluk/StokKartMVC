package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import connect.DatabaseConnect;

//Kod hizalama Ctrl + Shift + F
public class StokKartModel {
    public static String stok_kodu;
    public static String stok_adi;
    public static int stok_tipi;
    public static String birimi;
    public static String barkodu;
    public static double kdv_tipi;
    public static String aciklama;
    public static Date olusturma_tarihi;
    public static Connection conn;
    public static PreparedStatement preSt = null;

    public static void insert() {
	String sqlSorgu = "INSERT INTO tblStoklar (stok_kodu,stok_adi, stok_tipi, birimi, barkodu, kdv_tipi, aciklama, olusturma_tarihi)"
		+ "values(?,?,?,?,?,?,?,?)";
	try {
	    conn = DatabaseConnect.getConnection();
	    preSt = conn.prepareStatement(sqlSorgu);

	    preSt.setString(1, stok_kodu);
	    preSt.setString(2, stok_adi);
	    preSt.setInt(3, stok_tipi);
	    preSt.setString(4, birimi);
	    preSt.setString(5, barkodu);
	    preSt.setDouble(6, kdv_tipi);
	    preSt.setString(7, aciklama);
	    preSt.setDate(8, olusturma_tarihi);

	    preSt.executeUpdate();
	    JOptionPane.showMessageDialog(null, "Yeni stok eklendi!");
	    conn.close();
	}

	catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public static void update() {
	String sqlSorgu = "UPDATE tblStoklar SET stok_adi=?, stok_tipi=?, birimi=?, barkodu=?, kdv_tipi=?, aciklama=?, olusturma_tarihi=? WHERE stok_kodu=?";
	try {
	    conn = DatabaseConnect.getConnection();
	    preSt = conn.prepareStatement(sqlSorgu);

	    preSt.setString(8, stok_kodu);
	    preSt.setString(1, stok_adi);
	    preSt.setInt(2, stok_tipi);
	    preSt.setString(3, birimi);
	    preSt.setString(4, barkodu);
	    preSt.setDouble(5, kdv_tipi);
	    preSt.setString(6, aciklama);
	    preSt.setDate(7, olusturma_tarihi);

	    preSt.executeUpdate();
	    JOptionPane.showMessageDialog(null, "Seçilen stok güncellendi!");
	    conn.close();
	}

	catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public static void delete() {
	String sqlSorgu = "DELETE FROM tblStoklar WHERE stok_kodu = ?";
	try {
	    conn = DatabaseConnect.getConnection();
	    preSt = conn.prepareStatement(sqlSorgu);
	    preSt.setString(1, stok_kodu);

	    preSt.executeUpdate();
	    JOptionPane.showMessageDialog(null, "Seçilen stok silindi!");
	    conn.close();
	}

	catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
