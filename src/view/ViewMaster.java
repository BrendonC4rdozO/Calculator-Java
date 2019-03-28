package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;

public abstract class ViewMaster {

	GridBagConstraints c = new GridBagConstraints();

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
