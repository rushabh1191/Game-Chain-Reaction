package com.rushabh.UI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.UIManager;

public class Cell extends JButton {
	private int count;
	private Cell lCell;
	private Cell rCell;
	private Cell tCell;
	private Cell bCell;
	private int adjacentCellCount;
	private int currentPlayerPossession;

	public Cell(String name) {
		setText("");
		setBackground(Color.WHITE);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Cell getlCell() {
		return lCell;
	}

	public void setlCell(Cell lCell) {
		this.lCell = lCell;
	}

	public Cell getrCell() {
		return rCell;
	}

	public void setrCell(Cell rCell) {
		this.rCell = rCell;
	}

	public Cell gettCell() {
		return tCell;
	}

	public void settCell(Cell tCell) {
		this.tCell = tCell;
	}

	public Cell getbCell() {
		return bCell;
	}

	public void setbCell(Cell bCell) {
		this.bCell = bCell;
	}

	public int getAdjacentCellCount() {
		return adjacentCellCount;
	}

	public void setAdjacentCellCount(int adjacentCellCount) {
		this.adjacentCellCount = adjacentCellCount;
	}

	public void addBall() {
		count++;
		currentPlayerPossession = ReactionBoard.player;
		setText(count + "");
		if (count == adjacentCellCount) {
			burstCell();
		}
		setText("");
	}

	private void burstCell() {
		count = 0;
		currentPlayerPossession = 0;
		
		if (lCell != null)
			lCell.addBall();
		if (rCell != null)
			rCell.addBall();
		if (tCell != null)
			tCell.addBall();
		if (bCell != null)
			bCell.addBall();

		
		setText("");
	}

	@Override
	public void setText(String text) {
		if (count > 0)
			super.setText(count + "");
		else
			super.setText("");
		setBg();
	}

	public void setBg() {

		if (currentPlayerPossession == 1)
			setBackground(Color.red);
		else if (currentPlayerPossession == 2)
			setBackground(Color.GREEN);
		else {
			setBackground(Color.WHITE);
		}
	}

	public int getCurrentPlayerPossession() {
		return currentPlayerPossession;
	}

	public void setCurrentPlayerPossession(int currentPlayerPossession) {
		this.currentPlayerPossession = currentPlayerPossession;
	}
	
	public void resetCell()
	{
		count=0;
		setBackground(Color.WHITE);
		currentPlayerPossession=0;
		setText("");
	}

}
