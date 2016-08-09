from cell import Cell
from line import Line
from grouprule import *
from cellrule import *
from linerule import *

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

		changed = True

		for cell in self.cells:
			print cell.value, cell.hints
		print

		groupResultRule = GroupResultRule()
		cellOneHintRule = CellOneHintRule()
		twoCellsLineTwoHints = TwoCellsLineTwoHints(self.size)

		lines = []
		lines.extend(self.rows)
		lines.extend(self.columns)

		while changed:
			changed = False

			for group in self.groups:
				applyingResult = groupResultRule.apply(group)
				changed = changed or applyingResult
#			print 'Aftter group result rule'
#			for cell in self.cells:
#				print cell.value, cell.hints
#			print

			for cell in self.cells:
				applyingResult = cellOneHintRule.apply(cell)
				changed = changed or applyingResult

#			print 'After one hint per cell rule'
#			for cell in self.cells:
#				print cell.value, cell.hints
#			print

			for line in lines:
				twoCellsLineTwoHints.apply(line)