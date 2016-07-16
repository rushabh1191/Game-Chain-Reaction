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

    ReactionBoard board;

    public Cell(String name, ReactionBoard board) {
        setText("");
        this.board = board;
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
        showCount(count + "");

        if (count == adjacentCellCount) {
            burstCell();
        }
    }

    ;

    private boolean isMaxBallReached() {
        return count == adjacentCellCount;
    }

    private void burstCell() {
        count = 0;
        currentPlayerPossession = 0;
        showCount("");

        if (lCell != null) {
            lCell.addBall();
            if (board.hasAnyOneWon() != -1) {
                return;
            }
        }

        if (rCell != null) {
            rCell.addBall();
            if (board.hasAnyOneWon() != -1) {
                return;
            }
        }

        if (tCell != null) {
            tCell.addBall();
            if (board.hasAnyOneWon() != -1) {
                return;
            }
        }

        if (bCell != null) {
            bCell.addBall();
            if (board.hasAnyOneWon() != -1) {
                return;
            }
        }



    }


    public void showCount(String text) {
        if (count > 0)
            this.setText(count + "");
        else
            this.setText("");
        setBg();
    }

    public void setBg() {

        if (currentPlayerPossession == 1) {
            setBackground(Color.red);
        } else if (currentPlayerPossession == 2)
            setBackground(Color.GREEN);
        else {
            setBackground(Color.WHITE);
        }
        setOpaque(true);
    }


    public int getCurrentPlayerPossession() {
        return currentPlayerPossession;
    }

    public void setCurrentPlayerPossession(int currentPlayerPossession) {
        this.currentPlayerPossession = currentPlayerPossession;
    }

    public void resetCell() {
        count = 0;
        setBackground(Color.WHITE);
        currentPlayerPossession = 0;
        setText("");
    }

}
