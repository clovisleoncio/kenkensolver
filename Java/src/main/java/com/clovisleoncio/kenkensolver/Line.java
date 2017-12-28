package com.clovisleoncio.kenkensolver;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Line {
	
	private List<Cell> cells = new ArrayList<>();

	public void add(Cell cell) {
		cells.add(cell);
	}

	public void removeHint(Integer value, Cell subject) {
		for (Cell cell : cells) {
			if (cell != subject) {
				cell.removeHint(value);
			}
		}
	}

}
