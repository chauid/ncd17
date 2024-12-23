package day1223;

import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Main extends JFrame {
	private static final long serialVersionUID = -4627792820834920476L;
	static JFrame frame = new JFrame();

	static void exceptionTest(boolean flag) throws CustomException {
		if (flag) {
			throw new CustomException();
		} else {
			throw new NullPointerException();
		}
	}

	public static void main(String[] args) {

		try {
			exceptionTest(true);
		} catch (CustomException e) {
			System.out.println("Custom Exception");
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		frame.setVisible(true);
		frame.setBounds(new Rectangle(100, 100, 100, 100));

		frame.addWindowListener(new WindowListener() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}

			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
}
