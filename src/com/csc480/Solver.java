package com.csc480;

import java.util.ArrayList;
import java.util.List;



public class Solver {
	
	private Board initState;
	
	public Solver(){
		initState=new Board();
	}
	
	public Board findGoalState() {
		return findGoalState(initState,26);
	}
	
	/**
	 * Recursive function to find the goal state
	 * 
	 * @param state current state of the 
	 * @param limit max depth we are going for
	 * @return return the goal state
	 */
	public Board findGoalState(Board state, int limit) {
		if (state.isGoalState()) {
			return state;
		} else if (limit == 0) {
			return null;
		} else {
//			System.out.println("-------PARENT--------");
//			state.print();
//			System.out.println("-------PARENT--------");
			List<Board> successors = possibleMoves(state);
//			for (Board child : successors) {
//				child.getZeroLocation();
//				Board result = findGoalState(child, limit - 1);
//				if (null != result) {
//					return result;
//				}
//			}
			for (Board child : successors) {
				child.getZeroLocation();
				Board result = findGoalState(child, limit - 1);
				if (null != result) {
					return result;
				}
			}
			return null;
		}
	}
	
	public List<List<Tile>> copyBoard(List<List<Tile>> board){
		List<List<Tile>> copyBrd = new ArrayList<List<Tile>>();
		List<Tile> copyRow;
		
		for(List<Tile> lstT : board){
			copyRow = new ArrayList<Tile>();
			for(Tile t : lstT){
				copyRow.add(new Tile(t.getValue()));
			}
			copyBrd.add(copyRow);
		}
		return copyBrd;
	}
	
	private List<Board> possibleMoves(Board board){
		List<Board> move = new ArrayList<Board>();
		board.getZeroLocation();
		
		Board b;
	
		try{
			if(!board.getPrevAction().equals("down")){
				int tempRow = board.getRow();
				int tempCol = board.getCol();
				String tempMoved = board.getPrevAction();
				b = new Board(copyBoard(board.getBoard()), tempRow, tempCol, tempMoved);
	
	//			System.out.println("swapUp");
				b.swapUp();
				move.add(b);
	//			System.out.println("swapUp");
	//			b.print();
				b =null;
			}
		}catch(Exception e){
			b =null;
		}
		
		try{
			if(!board.getPrevAction().equals("up")){
				int tempRow = board.getRow();
				int tempCol = board.getCol();
				String tempMoved = board.getPrevAction();
				b = new Board(copyBoard(board.getBoard()), tempRow, tempCol, tempMoved);
	//			System.out.println("swapDown");
				b.swapDown();
				move.add(b);
	//			System.out.println("swapDown");
	//			b.print();
				b =null;
			}
		}catch(Exception e){
			b =null;
		}
	
		try{
			if(!board.getPrevAction().equals("right")){
				int tempRow = board.getRow();
				int tempCol = board.getCol();
				String tempMoved = board.getPrevAction();
				b = new Board(copyBoard(board.getBoard()), tempRow, tempCol, tempMoved);
	//			System.out.println("swapLeft");
				b.getZeroLocation();
				b.swapLeft();
				move.add(b);
	//			System.out.println("swapLeft");
	//			b.print();
				b =null;
			}
		}catch(Exception e){
			b =null;
		}
		
		try{
			if(!board.getPrevAction().equals("left")){
				int tempRow = board.getRow();
				int tempCol = board.getCol();
				String tempMoved = board.getPrevAction();
				b = new Board(copyBoard(board.getBoard()), tempRow, tempCol, tempMoved);
	//			System.out.println("swapRight");
				b.getZeroLocation();
				b.swapRight();
				move.add(b);
	//			System.out.println("swapRight");
	//			b.print();
				b =null;
			}
		}catch(Exception e){
			b =null;
		}
		
		return move;
	}
	


}
