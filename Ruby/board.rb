require './line'
require './cell'
require './grouprule'
require './cellrule'

class Board

	def initialize(size)
		@size = size
		@rows = Array.new(size) {Line.new}
		@columns = Array.new(size) {Line.new}
		@cells = []

		for i in 0...size
			for j in 0...size
				row = @rows[i]
				column = @columns[i]
				cell = Cell.new(size, [row, column])
				row << cell
				column << cell
				@cells << cell
			end
		end
	end

	def cells
		@cells
	end

	def groups=(groups)
		@groups = groups
	end

	def printBoard()
		for i in 0...@size
			initialIndex = i * @size
			puts @cells[initialIndex, @size].collect{|cell| cell.value ? cell.value : '*'}.join(' ')
		end
		for cell in @cells
			puts cell.hints.join(',')
		end
	end

	def solve()
		
		changed = true

		groupResultRule = GroupResultRule.new(@size)
		cellOneHintRule = CellOneHintRule.new

		while changed

			changed = false

			@groups.each {|group| changed = groupResultRule.apply(group) or changed }

			@cells.each{|cell| changed = cellOneHintRule.apply(cell) or changed}

		end

		printBoard

	end

end

__END__


class Board:

	def solve(self):
		ruleSizeOne = GroupSizeOneRule()
		for group in self.groups:
			ruleSizeOne.apply(group)

		changed = True

		groupResultRule = GroupResultRule(self.size)
		cellOneHintRule = CellOneHintRule()
		twoCellsLineTwoHints = TwoCellsLineTwoHints(self.size)

		lines = []
		lines.extend(self.rows)
		lines.extend(self.columns)

		while changed:
			changed = False

			for group in self.groups:
				applyingResult = groupResultRule.apply(group) or changed
				changed = changed or applyingResult

			for cell in self.cells:
				applyingResult = cellOneHintRule.apply(cell)
				changed = changed or applyingResult

			for line in lines:
				twoCellsLineTwoHints.apply(line)

		self.__printBoard();