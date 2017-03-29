package com.csc480;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<List<Tile>> board;
	private List<List<Tile>> goal;

	public Board() {
		this.board = new ArrayList<List<Tile>>();
		initBoard();
		initGoalState();
	}
	
	public Board(List<List<Tile>> board){
		this.board = board;
		initGoalState();
	}

	private void initBoard() {
		List<Tile> row1 = new ArrayList<Tile>();
		row1.add(new Tile(7));
		row1.add(new Tile(2));
		row1.add(new Tile(3));
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
				System.out.println("board: " + board.get(i).get(j).getValue()+ "Goal: " + goal.get(i).get(j).getValue());
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

	public static  void main(String[] args) {
		Board b = new Board();
		b.print();
		System.out.println("---");
		b.printGoal();
		
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
		
		if(b.isGoalState()){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		
	}

}
