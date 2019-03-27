package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;

public abstract class ViewMaster {

	GridBagConstraints c = new GridBagConstraints();

	Font fontText = new Font("Verdana", Font.LAYOUT_RIGHT_TO_LEFT, 24);
	Font fontButton = new Font("Verdana", Font.BOLD, 20);

	Color color1 = Color.decode("#FFFFFF"); // Branco
	Color color2 = Color.decode("#000000"); // Preto
	Color color3 = Color.decode("#E1E1E1"); // Cinza Claro
	Color color4 = Color.decode("#FF6A00"); // Laranja

	public ViewMaster() {
		c.weightx = 0.5;
		c.weighty = 0.5;
	}

	public GridBagConstraints setGridBagConstraints(int gridy, int gridx, int gridheight, int gridwidth, String text) {

		c.gridy = gridy;
		c.gridx = gridx;
		c.gridheight = gridheight;
		c.gridwidth = gridwidth;

		if (text.equals("HORIZONTAL")) {
			c.fill = GridBagConstraints.HORIZONTAL;
		} else if (text.equals("BOTH")) {
			c.fill = GridBagConstraints.BOTH;
		}

		return c;

	}
}
