import java.awt.Dimension;

import javax.swing.JFrame;

public class Evolution {

	public static void main(String[] args) {
		EvolutionView view = new EvolutionView();
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(new Dimension(800, 600));
		view.setResizable(false);
		view.setVisible(true);
	}
}