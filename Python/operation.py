class OperationSum:
	def isPossibleSolution(self, values, result):
		return sum(values) == result

class Operation(object):

	@staticmethod
	def get(name):
		sum = OperationSum()
		return sum