import collections

class TwoCellsLineTwoHints:

	def __init__(self, size):
		self.size = size

	def apply(self, line):
		changed = False
		cellPerHints = {}
		for cell in line.cells:
			key = "".join(str(hint) for hint in cell.hints)
			if key in cellPerHints:
				cellPerHints[key].append(cell)
			else:
				cellPerHints[key] = [cell]
		for hints, cells in cellPerHints.items():
			if len(hints) == len(cells):
				hintsToRemove = cells[0].hints
				for cell in line.cells:
					if cell not in cells:
						changed = cell.removeHints(hintsToRemove) or changed

		return changed