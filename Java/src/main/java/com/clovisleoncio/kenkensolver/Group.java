package com.clovisleoncio.kenkensolver;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Group {

	private int result;
	private Operation operation;
	private List<Cell> cells = new ArrayList<Cell>();

	public Group(int result, Operation operation) {
		this.result = result;
		this.operation = operation;
	}

	public void add(Cell cell) {
		cells.add(cell);
	}

}
