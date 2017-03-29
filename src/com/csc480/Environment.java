package com.csc480;

public class Environment {

	public static void main(String[] args) {
		Solver s = new Solver();
		Board b = s.findGoalState();
		b.print();

	}

}
