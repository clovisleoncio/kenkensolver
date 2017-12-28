package com.clovisleoncio.kenkensolver.rule.cell;

import com.clovisleoncio.kenkensolver.Cell;

public class OnlyOneHintRule extends CellRule {

	@Override
	public boolean apply(Cell subject) {
		
		if (subject.getValue() == null && subject.getHints().size() == 1) {
			subject.setValue(subject.getHints().iterator().next());
			
			// TODO clear lines for this hint
		}
		return false;
	}

}
