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

__END__

class Line(object):

	def __init__(self):
		self.cells = []

	def removeHint(self, hint):
		for cell in self.cells:
			cell.removeHint(hint)