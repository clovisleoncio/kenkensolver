class CellOneHintRule

	def apply(cell)
		if cell.hints.size == 1
			cell.value = cell.hints[0]
			return true
		end
		return false
	end

end