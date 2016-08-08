class Cell(object):

	def __init__(self, size, lines):
		self.hints = [i + 1 for i in range(size)]
		self.lines = lines
		self._value = None

	@property
	def value(self):
		return self._value

	@value.setter
	def value(self, value):
		self._value = value
		del self.hints[:]
		for line in self.lines:
			line.removeHint(value)

	def removeHint(self, hint):
		if hint in self.hints: self.hints.remove(hint)