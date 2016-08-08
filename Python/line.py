class Line(object):

	def __init__(self):
		self.cells = []

	def removeHint(self, hint):
		for cell in self.cells:
			cell.removeHint(hint)