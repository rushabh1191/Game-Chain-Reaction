package com.rushabh.UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ReactionBoard extends JFrame {
	static int player = 1;

	public void togglePlayer() {
		if (player == 1)
			player = 2;
		else
			player = 1;
		setTitle("Player " + player);

	}

	public ReactionBoard(final int cols, final int rows, String title) {
		JPanel p = new JPanel();
		setSize(300, 300);
		setTitle("Player "+player);
		p.setLayout(new GridLayout(rows, cols));
		final Cell cellMatrix[][] = new Cell[rows][cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				final Cell c = new Cell("");
				cellMatrix[i][j] = c;
				c.setSize(40, 60);
				p.add(c);
			}

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				final Cell c = cellMatrix[i][j];
				int adjacentCellCount = 0;
				if (j - 1 >= 0) {
					c.setlCell(cellMatrix[i][j - 1]);
					adjacentCellCount++;
				}
				if (j + 1 < cols) {
					c.setrCell(cellMatrix[i][j + 1]);
					adjacentCellCount++;
				}
				if (i - 1 >= 0) {
					c.settCell(cellMatrix[i - 1][j]);
					adjacentCellCount++;
				}
				if (i + 1 < rows) {
					c.setbCell(cellMatrix[i + 1][j]);
					adjacentCellCount++;
				}
				c.setAdjacentCellCount(adjacentCellCount);
				c.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						new Thread() {
							public void run() {
								if (c.getCount() == 0
										| (c.getCurrentPlayerPossession() == player)) {
									c.addBall();
									togglePlayer();
								}

							}
						}.start();
					}
				});

			}
		JButton button = new JButton("Reset Game");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < rows; i++)
					for (int j = 0; j < cols; j++)
						cellMatrix[i][j].resetCell();

			}
		});
		setLayout(new BorderLayout());
		p.setSize(275, 275);
		add(p, BorderLayout.CENTER);
		add(button, BorderLayout.AFTER_LAST_LINE);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
