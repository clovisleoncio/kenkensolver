class GroupSizeOneRule:

	def apply(self, group):
		if len(group.cells) == 1:
			cell = group.cells[0]
			cell.value = group.result

class GroupResultRule:

	def apply(self, group):
		if group.operation != None:
			print group.operation