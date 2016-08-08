class Group:

	def __init__(self, result, operation = None):
		self.result = result
		self.operation = operation
		self.cells = []

	def add(self, cell):
		self.cells.append(cell)