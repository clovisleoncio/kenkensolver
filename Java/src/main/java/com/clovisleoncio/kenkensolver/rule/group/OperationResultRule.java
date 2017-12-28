package com.clovisleoncio.kenkensolver.rule.group;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.clovisleoncio.kenkensolver.Cell;
import com.clovisleoncio.kenkensolver.Group;

public class OperationResultRule extends GroupRule {

	@Override
	public boolean apply(Group subject) {
		if (subject.getOperation() != null) {
			
			List<Cell> cells = subject.getCells();
			Set<Integer>[] validHints = new Set[cells.size()];
			for (int i = 0; i < validHints.length; i++) {
				validHints[i] = new HashSet<Integer>();
			}
			
			checkValidHints(new ArrayList<Integer>(), subject, validHints);
			
			for (int i = 0; i < validHints.length; i++) {
				Cell cell = subject.getCells().get(i);
				cell.setHints(validHints[i]);
			}
			
			// TODO changed rule
			
		}
		return false;
	}

	private void checkValidHints(List<Integer> availableHints, Group group, Set<Integer>[] validHints) {
		
		int position = availableHints.size();
		
		if (position < group.getCells().size()) {
			Cell cell = group.getCells().get(position);
			for (Integer hint : cell.getHints()) {
				List<Integer> newAvailable = new ArrayList<Integer>(availableHints);
				newAvailable.add(hint);
				checkValidHints(newAvailable, group, validHints);
			}
		}
		else if (group.getOperation().isValid(availableHints, group.getResult())) {
			
			for (int i = 0; i < availableHints.size(); i++) {
				validHints[i].add(availableHints.get(i));
			}
			
		}
	}

}
