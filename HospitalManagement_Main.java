package HospitalProject;

import java.awt.EventQueue;

public class HospitalManagement_Main
{

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
					//tempFrame temp = new tempFrame();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}); 
	
	}

}


/**
*	1-999 ==> Doctor accounts
*	1001-9999 ==> Administrator accounts
*	10001-99999 ==> Patient accounts
*
*/



