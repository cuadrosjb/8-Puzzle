package com.csc480;

import java.util.ArrayList;
import java.util.List;

public class Solver {

	private Board initState;

	/**
	 * Empty constructor
	 */
	public Solver() {
		initState = new Board();
	}

	/**
	 * @return the goal state or null
	 */
	public Board findGoalState() {
		return findGoalState(initState, 26);
	}


	/**
	 * @param state current state of the board
	 * @param limit maximum amount of depth
	 * @return goal state or null
	 */
	public Board findGoalState(Board state, int limit) {
		if (state.isGoalState()) {
			return state;
		} else if (limit == 0) {
			return null;
		} else {
			List<Board> successors = possibleMoves(state);
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

	/**
	 * @param board 
	 * @return a deep copy of the passed board
	 */
	public List<List<Tile>> copyBoard(List<List<Tile>> board) {
		List<List<Tile>> copyBrd = new ArrayList<List<Tile>>();
		List<Tile> copyRow;

		for (List<Tile> lstT : board) {
			copyRow = new ArrayList<Tile>();
			for (Tile t : lstT) {
				copyRow.add(new Tile(t.getValue()));
			}
			copyBrd.add(copyRow);
		}
		return copyBrd;
	}

	/**
	 * @param board current state of the board
	 * @return list of possible children from current board
	 */
	private List<Board> possibleMoves(Board board) {
		List<Board> move = new ArrayList<Board>();
		board.getZeroLocation();

		Board b;

		try {
			if (!board.getPrevAction().equals("down")) {
				int tempRow = board.getRow();
				int tempCol = board.getCol();
				String tempMoved = board.getPrevAction();
				b = new Board(copyBoard(board.getBoard()), tempRow, tempCol, tempMoved);

				b.swapUp();
				move.add(b);
				b = null;
			}
		} catch (Exception e) {
			b = null;
		}

		try {
			if (!board.getPrevAction().equals("up")) {
				int tempRow = board.getRow();
				int tempCol = board.getCol();
				String tempMoved = board.getPrevAction();
				b = new Board(copyBoard(board.getBoard()), tempRow, tempCol, tempMoved);
				b.swapDown();
				move.add(b);
				b = null;
			}
		} catch (Exception e) {
			b = null;
		}

		try {
			if (!board.getPrevAction().equals("right")) {
				int tempRow = board.getRow();
				int tempCol = board.getCol();
				String tempMoved = board.getPrevAction();
				b = new Board(copyBoard(board.getBoard()), tempRow, tempCol, tempMoved);
				b.getZeroLocation();
				b.swapLeft();
				move.add(b);
				b = null;
			}
		} catch (Exception e) {
			b = null;
		}

		try {
			if (!board.getPrevAction().equals("left")) {
				int tempRow = board.getRow();
				int tempCol = board.getCol();
				String tempMoved = board.getPrevAction();
				b = new Board(copyBoard(board.getBoard()), tempRow, tempCol, tempMoved);
				b.getZeroLocation();
				b.swapRight();
				move.add(b);
				b = null;
			}
		} catch (Exception e) {
			b = null;
		}

		return move;
	}

}
