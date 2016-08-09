class Group

	def initialize(result, operation)
		@result = result
		@operation = operation
		@cells = []
	end

	def cells
		@cells
	end

	def operation
		@operation
	end

	def result
		@result
	end

end

__END__
class Group:

	def __init__(self, result, operation = None):
		self.result = result
		self.operation = operation
		self.cells = []

	def add(self, cell):
		self.cells.append(cell)