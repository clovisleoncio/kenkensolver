from cell import Cell
from line import Line
from grouprule import *

class Board:

	def __init__(self, size):
		self.size = size
		self.rows = [Line() for i in range(size)]
		self.columns = [Line() for i in range(size)]
		self.cells = []
		for i in range(size):
			for j in range(size):
				row = self.rows[i]
				column = self.columns[j]
				cell = Cell(size, [row, column])
				row.cells.append(cell)
				column.cells.append(cell)
				self.cells.append(cell)

	def solve(self):
		ruleSizeOne = GroupSizeOneRule()
		for group in self.groups:
			ruleSizeOne.apply(group)