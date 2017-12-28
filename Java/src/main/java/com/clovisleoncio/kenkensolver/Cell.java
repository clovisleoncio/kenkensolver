package com.clovisleoncio.kenkensolver;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "lines")
public class Cell {
	
	public static final Cell cellForBoardSize(int boardSize) {
		Cell cell = new Cell();
		for (int i = 0; i < boardSize; i++) {
			cell.hints.add(i + 1);
		}
		return cell;
	}
	
	private Integer value;
	private Set<Integer> hints = new HashSet<>();
	private Line[] lines;
	
	public void setLines(Line... lines) {
		this.lines = lines;
	}
	
	public Line[] getLines() {
		return lines;
	}

	public void removeHint(Integer hint) {
		hints.remove(hint);
	}
	
}
