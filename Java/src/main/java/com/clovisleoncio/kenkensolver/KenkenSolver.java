package com.clovisleoncio.kenkensolver;

import java.util.HashMap;
import java.util.Map;

public class KenkenSolver {
	
	public static void main(String[] args) {
		
		String representation = "aad"
							  + "bbd"
							  + "cee";
		
		Map<Character, Group> nameToGroup = new HashMap<Character, Group>(){{
			put('a', new Group(3, Operation.SUM));
			put('b', new Group(5, Operation.SUM));
			put('c', new Group(3, Operation.SUM));
			put('d', new Group(4, Operation.SUM));
			put('e', new Group(3, Operation.SUM));
		}};
		
		Board board = new Board(representation, nameToGroup);
		board.solve();
		
	}

}
