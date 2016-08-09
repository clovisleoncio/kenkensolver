class CellOneHintRule:

	def apply(self, cell):
		if len(cell.hints):
			cell.value = cell.hints[0]