/**
 * 
 */
package main;

import java.awt.EventQueue;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.StokKartController;
import View.StokKartView;

/**
 * @author Elif
 *
 */
public class StokKartMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    StokKartView frame = new StokKartView();
		    StokKartController controller=new StokKartController(frame);
		    controller.execute();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});

	

    }

}
