class Line

	def initialize
		@cells = []
	end

	def << (cell)
		@cells << cell
	end

	def removeHint(hint)
		@cells.each {|cell| cell.removeHint(hint)}
	end

end