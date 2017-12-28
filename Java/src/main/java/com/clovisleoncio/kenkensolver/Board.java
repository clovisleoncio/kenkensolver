package com.clovisleoncio.kenkensolver;

import java.util.Map;

import com.clovisleoncio.kenkensolver.rule.RuleApplier;
import com.clovisleoncio.kenkensolver.rule.cell.CellRule;
import com.clovisleoncio.kenkensolver.rule.cell.OnlyOneHintRule;
import com.clovisleoncio.kenkensolver.rule.group.GroupRule;
import com.clovisleoncio.kenkensolver.rule.group.OperationResultRule;
import com.clovisleoncio.kenkensolver.rule.line.LineRule;

public class Board {
	
	private static CellRule[] CELL_RULES = {
			new OnlyOneHintRule()
	};

	private static LineRule[] LINE_RULES = {
	};

	private static GroupRule[] GROUP_RULES = {
			new OperationResultRule()
	};

	private int boardSize;

	private Line[] horizontalLines;
	private Line[] verticalLines;
	private Line[] allLines;
	
	private Group[] groups;
	
	private Cell[] cells;

	public Board(String representation, Map<Character, Group> nameToGroup) {
		boardSize = (int) Math.sqrt(representation.length());
		
		horizontalLines = new Line[boardSize];
		verticalLines = new Line[boardSize];
		allLines = new Line[boardSize * 2];
		
		for (int i = 0; i < boardSize; i++) {
			horizontalLines[i] = new Line();
			verticalLines[i] = new Line();
			allLines[i] = horizontalLines[i];
			allLines[i*2] = verticalLines[i];
		}
		
		cells = new Cell[representation.length()];
		
		for (int i = 0; i < representation.length(); i++) {
			char representationChar = representation.charAt(i);
			int horizontalIndex = i / boardSize;
			int verticalIndex = i % boardSize;
			Group group = nameToGroup.get(representationChar);
			
			Cell cell = Cell.cellForBoardSize(boardSize);
			group.add(cell);
			horizontalLines[horizontalIndex].add(cell);
			verticalLines[verticalIndex].add(cell);
			cells[i] = cell;
		}
		
		groups = nameToGroup.values().toArray(new Group[]{});
	}
	
	public void solve() {
		
		boolean changed;

		RuleApplier<Cell> cellRuleApplier = new RuleApplier<Cell>(CELL_RULES, cells);
		RuleApplier<Line> lineRuleApplier = new RuleApplier<Line>(LINE_RULES, allLines);
		RuleApplier<Group> groupRuleApplier = new RuleApplier<Group>(GROUP_RULES, groups);
		
//		while () {
		
			changed = cellRuleApplier.apply();
			
			changed = applyLineRules() || changed;
			
			changed = groupRuleApplier.apply() || changed;
			
//		}
			
		
		for (Group group : groups) {
				System.out.println("GROUP RESULT: " + group.getResult());
				System.out.println(group.getCells());
		}
		
	}

	private boolean applyLineRules() {
		// TODO Auto-generated method stub
		return false;
	}

}
