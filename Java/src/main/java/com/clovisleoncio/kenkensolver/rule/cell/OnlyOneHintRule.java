package com.clovisleoncio.kenkensolver.rule.cell;

import com.clovisleoncio.kenkensolver.Cell;
import com.clovisleoncio.kenkensolver.Line;

public class OnlyOneHintRule extends CellRule {

	@Override
	public boolean apply(Cell subject) {
		
		if (subject.getValue() == null && subject.getHints().size() == 1) {
			subject.setValue(subject.getHints().get(0));
			
			for (Line line : subject.getLines()) {
				line.removeHint(subject.getValue(), subject);
			}
			
			return true;
		}
		return false;
	}

}
