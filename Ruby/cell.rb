class Cell

	def initialize(size, lines)
		@hints = (1..size).to_a
		@lines = lines
	end

	def value
		@value
	end

	def value=(value)
		@value = value
		@hints.clear
		@lines.each {|line| line.removeHint(value)}
	end

	def hints
		@hints
	end

	def removeHint(hint)
		@hints.delete(hint)
	end

	def lines
		@lines
	end

end

__END__

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
		if hint in self.hints:
			self.hints.remove(hint)
			return True
		return False

	def removeHints(self, hints):
		removed = False
		for hint in hints:
			removed = self.removeHint(hint) or removed
		return removed