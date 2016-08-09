class CellOneHintRule:

	def apply(self, cell):
#		print cell.value, cell.hints, len(cell.hints), len(cell.hints) == 1
		if len(cell.hints) == 1:
			cell.value = cell.hints[0]
			return True
		return False