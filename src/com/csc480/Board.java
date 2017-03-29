package com.csc480;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<List<Tile>> board;
	private List<List<Tile>> goal;
	
	private int row;
	private int col;
	
	private String prevAction = "none";

	public Board() {
		this.board = new ArrayList<List<Tile>>();
		initBoard();
		initGoalState();
		getZeroLocation();
	}
	
	public Board(List<List<Tile>> board){
		this.board = board;
		initGoalState();
		getZeroLocation();
	}
	
	public Board(Board board){
		this.board = board.getBoard();
		this.row = board.getRow();
		this.col = board.getCol();
		initGoalState();
		getZeroLocation();
	}
	
	
	
	
	public Board(List<List<Tile>> board, int row, int col, String prevAction) {
		this.board = board;
		this.row = row;
		this.col = col;
		this.prevAction = prevAction;
		initGoalState();
		getZeroLocation();
	}

	public static Board copy(Board board){
		Board cBoard = new Board();
		cBoard.setBoard(board.getBoard());
		cBoard.setRow(board.getRow());
		cBoard.setCol(board.getCol());
		
		cBoard.getZeroLocation();
		cBoard.initGoalState();
		return cBoard;
	}

	private void initBoard() {
		List<Tile> row1 = new ArrayList<Tile>();
		row1.add(new Tile(7));
		row1.add(new Tile(2));
		row1.add(new Tile(4));
		board.add(row1);
		row1 = new ArrayList<Tile>();
		row1.add(new Tile(5));
		row1.add(new Tile(0));
		row1.add(new Tile(6));
		board.add(row1);
		row1 = new ArrayList<Tile>();
		row1.add(new Tile(8));
		row1.add(new Tile(3));
		row1.add(new Tile(1));
		board.add(row1);
	}
	
	private void initGoalState(){
		this.goal = new ArrayList<List<Tile>>();
		List<Tile> row1 = new ArrayList<Tile>();
		row1.add(new Tile(0));
		row1.add(new Tile(1));
		row1.add(new Tile(2));
		goal.add(row1);
		row1 = new ArrayList<Tile>();
		row1.add(new Tile(3));
		row1.add(new Tile(4));
		row1.add(new Tile(5));
		goal.add(row1);
		row1 = new ArrayList<Tile>();
		row1.add(new Tile(6));
		row1.add(new Tile(7));
		row1.add(new Tile(8));
		goal.add(row1);
	}

	public void print() {
		for (List<Tile> lstT : board) {
			for (Tile t : lstT) {
				System.out.print(t.getValue() + "\t");
			}
			System.out.println("\r");
		}
	}
	
	public void printGoal() {
		for (List<Tile> lstT : goal) {
			for (Tile t : lstT) {
				System.out.print(t.getValue() + "\t");
			}
			System.out.println("\r");
		}
	}

	public boolean isGoalState() {
		for (int i = 0; i < board.size(); i++) {
			for (int j = 0; j < board.get(i).size(); j++) {
//				System.out.println("board: " + board.get(i).get(j).getValue()+ "Goal: " + goal.get(i).get(j).getValue());
				if(board.get(i).get(j).getValue()!=goal.get(i).get(j).getValue()){
					return false;
				}

			}
		}
		return true;
	}
	
	
	public List<List<Tile>> getBoard() {
		return board;
	}

	public void setBoard(List<List<Tile>> board) {
		this.board = board;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	public void getZeroLocation(){
		for (int i = 0; i < board.size(); i++) {
			for (int j = 0; j < board.get(i).size(); j++) {
				if(board.get(i).get(j).getValue()==0){
					row = i;
					col = j;
					return;
				}

			}
		}
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	public void swapUp(){
	
		
		
		int temp = row-1;
		int value = board.get(temp).get(col).getValue();
		board.get(temp).get(col).setValue(0);
		board.get(row).get(col).setValue(value);
		prevAction = "up";
		
//		print();

		
	}
	public void swapDown(){
//		print();
		int temp = row+1;
		int value = board.get(temp).get(col).getValue();
		board.get(temp).get(col).setValue(0);
		board.get(row).get(col).setValue(value);
		prevAction = "down";
//		print();
	}
	public void swapLeft(){
//		print();
		int temp = col-1;
		int value = board.get(row).get(temp).getValue();
		board.get(row).get(temp).setValue(0);
		board.get(row).get(col).setValue(value);
		prevAction = "left";
//		print();
	}
	public void swapRight(){
//		print();
		int temp = col+1;
		int value = board.get(row).get(temp).getValue();
		board.get(row).get(temp).setValue(0);
		board.get(row).get(col).setValue(value);
		prevAction = "right";
//		print();
	}

	public String getPrevAction() {
		return prevAction;
	}

	public void setPrevAction(String prevAction) {
		this.prevAction = prevAction;
	}

	public static  void main(String[] args) {
		Board b = new Board();
//		b.print();
		System.out.println("---");
		b.print();
		
		List<List<Tile>> goal = new ArrayList<List<Tile>>();
		List<Tile> row1 = new ArrayList<Tile>();
		row1.add(new Tile(0));
		row1.add(new Tile(1));
		row1.add(new Tile(2));
		goal.add(row1);
		row1 = new ArrayList<Tile>();
		row1.add(new Tile(3));
		row1.add(new Tile(4));
		row1.add(new Tile(5));
		goal.add(row1);
		row1 = new ArrayList<Tile>();
		row1.add(new Tile(6));
		row1.add(new Tile(7));
		row1.add(new Tile(8));
		goal.add(row1);
		
		
		
		Board g = new Board(goal);
		
		if(g.isGoalState()){
			System.out.println("true");
			g.print();
		}else{
			System.out.println("false");
		}
		
	}

}
