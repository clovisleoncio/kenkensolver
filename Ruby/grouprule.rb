class GroupResultRule

	def initialize(size)
		@size = size
	end

	def __isPossibeSolution(group, candidates)
		group.operation.isPossibleSolution(candidates, group.result)
	end

#	def __isPossibeSolution(self, group, candidates):
#		if group.operation.isPossibleSolution(candidates, group.result):
#			candidatesPerValue = {(i+1): [] for i in range(self.size)}
#			for i in range(len(candidates)):
#				candidatesPerValue[candidates[i]].append(group.cells[i])
#			for cellsWithRepetition in candidatesPerValue.values():
#				if len(cellsWithRepetition) > 1:
#					lines = []
#					for cell in cellsWithRepetition:
#						lines.extend(cell.lines)
#					lineCounting = collections.Counter(lines)
#					for value in lineCounting.values():
#						if value > 1:
#							return False
#			return True
#		return False

	def __checkPossibilities(group, index, candidates, solutions)
		if index < group.cells.size
			cell = group.cells[index]
			options = cell.value ? [cell] : cell.hints
			options.each do |option|
				newCandidates = Array.new(candidates)
				newCandidates << option
				__checkPossibilities(group, index + 1, newCandidates, solutions)
			end
		else
			if __isPossibeSolution(group, candidates)
				for i in 0...group.cells.size
					solutions[i] << candidates[i]
				end
			end
		end
	end

	def apply(group)
		changed = false
		if group.operation
			solutions = Array.new(group.cells.size){[]}
			__checkPossibilities(group, 0, [], solutions)

			for i in 0...group.cells.length
				cell = group.cells[i]
				Array.new(cell.hints).each do |hint|
					if not solutions[i].include? hint
						cell.hints.delete(hint)
						changed = true
					end
				end
			end
		end
		changed
	end

end