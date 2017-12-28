package com.clovisleoncio.kenkensolver.rule.line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.clovisleoncio.kenkensolver.Cell;
import com.clovisleoncio.kenkensolver.Line;

public class TwoHintsTwoCellsRule extends LineRule {

	@Override
	public boolean apply(Line subject) {
		
		Map<String, List<Cell>> hintsToCells = new HashMap<>();
		for (Cell cell : subject.getCells()) {
			String hintsKey = createKey(cell.getHints());
			
			List<Cell> cells = hintsToCells.get(hintsKey);
			if (cells == null) { // TODO use guava map?
				cells = new ArrayList<>();
				hintsToCells.put(hintsKey, cells);
			}
			cells.add(cell);
		}
		
		boolean changed = false;
		
		for (Entry<String, List<Cell>> entry : hintsToCells.entrySet()) {
			String hints = entry.getKey();
			List<Cell> cells = entry.getValue();
			if (hints.length() == cells.size()) {
				List<Integer> hintsToRemove = cells.get(0).getHints();
				for (Cell cell : subject.getCells()) {
					if (!cells.contains(cell)) {
						changed = cell.removeHints(hintsToRemove) || changed;
					}
				}
			}
		}
		
		return false;
	}

	private String createKey(List<Integer> hints) {
		return hints.stream().map(i -> i.toString()).collect(Collectors.joining(""));
	}

}
