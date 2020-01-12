import java.awt.*;
import javax.swing.*;

/**
 * Models the about panel in the main application JFrame
 * 
 * @author Akshat Bansal
 */
public class AboutPanel extends JPanel {
	/**
	 * Constructs an instance of the about panel
	 */
	public AboutPanel() {
//		JLabel a = new JLabel();
//		a.setText("Akshat Bansal 			Github: https://github.com/akshat2610");
//		JLabel ap = new JLabel();
//		ap.setIcon(new ImageIcon("./images/aboutPics/akshatAbout.JPEG"));
//		JLabel j = new JLabel();
//		j.setText("Jyoti Suri 				Github: https://github.com/JyotiSuri");
//		JLabel jp = new JLabel();
//		jp.setIcon(new ImageIcon("./images/aboutPics/jyotiAbout.JPEG"));
//		JLabel s = new JLabel();
//		s.setText("Shruti Panchal 			Github: https://github.com/shrutipanchal7699");
//		JLabel sp = new JLabel();
//		sp.setIcon(new ImageIcon("./images/aboutPics/shrutiAbout.JPG"));
//		JLabel t = new JLabel();
//		t.setText("Tirth Patel 				Github: https://github.com/tirthnpatel");
//		JLabel tp = new JLabel();
//		tp.setIcon(new ImageIcon("./images/aboutPics/tirthAbout.JPG"));

		aboutAPanel q = new aboutAPanel();
		aboutJPanel w = new aboutJPanel();
		aboutSPanel e = new aboutSPanel();
		aboutTPanel r = new aboutTPanel();
		add(q);
		add(w);
		add(e);
		add(r);
		setLayout(new GridLayout(2, 2));
		// add(textArea);
		setVisible(true);
	}

	/**
	 * Tester for about panel. Test for different layouts and sizes here.
	 */
	public static void main(String[] args) {
		JPanel aboutPanel = new AboutPanel();
		JFrame app = new JFrame();

		app.setPreferredSize(new Dimension(500, 300));
		app.add(aboutPanel);
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.pack();
	}

	class aboutAPanel extends JPanel {
		public aboutAPanel() {
			JPanel akshatPanel = new JPanel();
			JLabel info = new JLabel("<html>AKSHAT BANSAL<br/>Github: https://github.com/akshat2610<br/>LinkedIn: https://www.linkedin.com/in/-akshat-bansal/</html>",SwingConstants.CENTER);
			info.setFont(info.getFont ().deriveFont (15.0f));
			JLabel pic = new JLabel(new ImageIcon("./images/aboutPics/akshatAbout.JPEG"), SwingConstants.CENTER);
			add(pic);
			add(info);
			setLayout(new GridLayout(2,1));
			setBackground(Color.LIGHT_GRAY);
			setVisible(true);
		}
	}
	class aboutJPanel extends JPanel {
		public aboutJPanel() {
			JPanel jyotiPanel = new JPanel();
			JLabel info = new JLabel("<html>JYOTI SURI<br/>Github: https://github.com/JyotiSuri<br/>LinkedIn: https://www.linkedin.com/in/jyotisuri/</html>",SwingConstants.CENTER);
			info.setFont(info.getFont ().deriveFont (15.0f));
			JLabel pic = new JLabel(new ImageIcon("./images/aboutPics/jyotiAbout.JPEG"), SwingConstants.CENTER);
			add(pic);
			add(info);
			setLayout(new GridLayout(2,1));
			setVisible(true);
		}
	}
	class aboutSPanel extends JPanel {
		public aboutSPanel() {
			JPanel shrutiPanel = new JPanel();
			JLabel info = new JLabel("<html>SHRUTI PANCHAL<br/>Github: https://github.com/shrutipanchal7699<br/>LinkedIn: https://www.linkedin.com/in/shruti-panchal-25a7ab157/</html>",SwingConstants.CENTER);
			info.setFont(info.getFont ().deriveFont (15.0f));
			JLabel pic = new JLabel(new ImageIcon("./images/aboutPics/shrutiAbout.JPG"), SwingConstants.CENTER);
			add(pic);
			add(info);
			setLayout(new GridLayout(2,1));
			setVisible(true);
		}
	}
	class aboutTPanel extends JPanel {
		public aboutTPanel() {
			JPanel tirthPanel = new JPanel();

			JLabel info = new JLabel("<html>TIRTH PATEL<br/>Github: https://github.com/tirthnpatel<br/>LinkedIn: https://www.linkedin.com/in/tirthnpatel/</html>",SwingConstants.CENTER);
			info.setFont(info.getFont ().deriveFont (15.0f));
			JLabel pic = new JLabel(new ImageIcon("./images/aboutPics/tirthAbout.JPG"), SwingConstants.CENTER);
			add(pic);
			add(info);
			setLayout(new GridLayout(2,1));
			setBackground(Color.LIGHT_GRAY);
			setVisible(true);
		}
	}

//	private JTextArea textArea;
//	public final static int TEXT_AREA_WITDH = 50;
//	public final static int TEXT_AREA_HEIGHT = 100;
//	public final static int PANEL_NUM_ROWS = 1;
//	public final static int PANEL_NUM_COLS = 4;
}
