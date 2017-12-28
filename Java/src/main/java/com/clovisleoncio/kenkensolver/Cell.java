package com.clovisleoncio.kenkensolver;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = "lines")
@EqualsAndHashCode(exclude = "lines")
public class Cell {
	
	public static final Cell cellForBoardSize(int boardSize) {
		Cell cell = new Cell();
		for (int i = 0; i < boardSize; i++) {
			cell.hints.add(i + 1);
		}
		return cell;
	}
	
	private Integer value;
	private List<Integer> hints = new ArrayList();
	private Line[] lines;
	
	public void setLines(Line... lines) {
		this.lines = lines;
	}
	
	public Line[] getLines() {
		return lines;
	}

	public boolean removeHint(Integer hint) {
		return hints.remove(hint);
	}

	public boolean removeHints(List<Integer> hintsToRemove) {
		return hints.removeAll(hintsToRemove);
	}
	
}
