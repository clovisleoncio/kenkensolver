class GroupSizeOneRule:

	def apply(self, group):
		if len(group.cells) == 1:
			cell = group.cells[0]
			cell.value = group.result

class GroupResultRule:

	def __checkPossibilities(self, group, index, candidates, solutions):
		if index < len(group.cells):
			cell = group.cells[index]
			for hint in cell.hints:
				newCandidates = list(candidates)
				newCandidates.append(hint)
				self.__checkPossibilities(group, index + 1, newCandidates, solutions)
		else:
			if group.operation.isPossibleSolution(candidates, group.result):
				for i in range(len(group.cells)):
					solutions[i].append(candidates[i])


	def apply(self, group):
		if group.operation != None:
			solutions = [[] for i in range(len(group.cells))]
			self.__checkPossibilities(group, 0, [], solutions)
			for i in range(len(group.cells)):
				cell = group.cells[i]
				for hint in cell.hints:
					if hint not in solutions[i]: cell.hints.remove(hint)







from cell import Cell
from group import Group
from operation import Operation

#group = Group(3, Operation.get("+"))
group = Group(4, Operation.get("+"))
cell1 = Cell(3, [])
cell1.hints = [1, 2, 3]
cell2 = Cell(3, [])
cell2.hints = [1, 2, 3]
group.cells = [cell1, cell2]

print cell1.hints
print cell2.hints

rule = GroupResultRule()
rule.apply(group)

print cell1.hints
print cell2.hints

