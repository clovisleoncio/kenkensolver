class GroupResultRule

	def initialize(size)
		@size = size
	end

	def __isPossibeSolution(group, candidates)
		if group.operation.isPossibleSolution(candidates, group.result)
			candidatesPerValue = {}
			(1..@size).each{|i| candidatesPerValue[i] = []}
			(0...candidates.size).each {|i| candidatesPerValue[candidates[i]] << group.cells[i]}
			candidatesPerValue.values().each do |cells|
				if cells.length > 1
					lines = Array.new()
					cells.each {|cell| lines.concat(cell.lines)}
					lineCounting = Hash.new 0
					lines.each { |line| lineCounting[line] += 1 }
					lineCounting.values.each {|value| return false if value > 1}
				end
			end
			return true
		end
		return false
	end

	def __checkPossibilities(group, index, candidates, solutions)
		if index < group.cells.size
			cell = group.cells[index]
			options = cell.value ? [cell.value] : cell.hints
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