import collections

class GroupSizeOneRule:

	def apply(self, group):
		if len(group.cells) == 1:
			cell = group.cells[0]
			cell.value = group.result
			return True
		return False

class GroupResultRule:

	def __init__(self, size):
		self.size = size

	def __isPossibeSolution(self, group, candidates):
		if group.operation.isPossibleSolution(candidates, group.result):
			candidatesPerValue = {(i+1): [] for i in range(self.size)}
			for i in range(len(candidates)):
				candidatesPerValue[candidates[i]].append(group.cells[i])
			for cellsWithRepetition in candidatesPerValue.values():
				if len(cellsWithRepetition) > 1:
					lines = []
					for cell in cellsWithRepetition:
						lines.extend(cell.lines)
					lineCounting = collections.Counter(lines)
					for value in lineCounting.values():
						if value > 1:
							return False
			return True
		return False


	def __checkPossibilities(self, group, index, candidates, solutions):
		if index < len(group.cells):
			cell = group.cells[index]
			options = cell.hints
			if cell.value != None:
				options = [cell.value]
			for option in options:
				newCandidates = list(candidates)
				newCandidates.append(option)
				self.__checkPossibilities(group, index + 1, newCandidates, solutions)
		else:
			if self.__isPossibeSolution(group, candidates):
				for i in range(len(group.cells)):
					solutions[i].append(candidates[i])


	def apply(self, group):
		changed = False
		if group.operation != None:
			solutions = [[] for i in range(len(group.cells))]
			self.__checkPossibilities(group, 0, [], solutions)
			for i in range(len(group.cells)):
				cell = group.cells[i]
				for hint in cell.hints:
					if hint not in solutions[i]:
						cell.hints.remove(hint)
						changed = True
		return changed