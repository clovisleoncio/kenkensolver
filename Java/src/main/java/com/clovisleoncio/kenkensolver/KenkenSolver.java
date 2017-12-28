package com.clovisleoncio.kenkensolver;

import java.util.HashMap;
import java.util.Map;

public class KenkenSolver {
	
	public static void main(String[] args) {
		
//		String representation = "aad"
//							  + "bbd"
//							  + "cee";
//		
//		Map<Character, Group> nameToGroup = new HashMap<Character, Group>(){{
//			put('a', new Group(3, Operation.SUM));
//			put('b', new Group(5, Operation.SUM));
//			put('c', new Group(3, Operation.SUM));
//			put('d', new Group(4, Operation.SUM));
//			put('e', new Group(3, Operation.SUM));
//		}};
		
		//http://www.kenkenpuzzle.com/game 92612
		
		String representation =
				"addjjm" +
				"adhkmm" +
				"behkoo" +
				"beiino" +
				"cfflno" +
				"cgglpp";
		
		Map<Character, Group> nameToGroup = new HashMap<Character, Group>() {{
			put('a', new Group(3, Operation.SUM));
			put('b', new Group(8, Operation.SUM));
			put('c', new Group(10, Operation.SUM));
			put('d', new Group(17, Operation.SUM));
			put('e', new Group(6, Operation.SUM));
			put('f', new Group(3, Operation.SUM));
			put('g', new Group(4, Operation.SUM));
			put('h', new Group(7, Operation.SUM));
			put('i', new Group(7, Operation.SUM));
			put('j', new Group(5, Operation.SUM));
			put('k', new Group(11, Operation.SUM));
			put('l', new Group(7, Operation.SUM));
			put('m', new Group(8, Operation.SUM));
			put('n', new Group(11, Operation.SUM));
			put('o', new Group(12, Operation.SUM));
			put('p', new Group(7, Operation.SUM));
		}};
		
		Board board = new Board(representation, nameToGroup);
		board.solve();
		
	}

}
