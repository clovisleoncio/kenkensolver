require './line'
require './cell'
require './grouprule'
require './cellrule'
require './linerule'

class Board

	def initialize(size)
		@size = size
		@rows = Array.new(size) {Line.new}
		@columns = Array.new(size) {Line.new}
		@cells = []

		for i in 0...size
			for j in 0...size
				row = @rows[i]
				column = @columns[j]
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
		twoCellsLineTwoHints = TwoCellsLineTwoHints.new

		lines = Array.new.concat(@rows).concat(@columns)

		while changed
			changed = false

			@groups.each {|group| changed = groupResultRule.apply(group) || changed }
			
			@cells.each{|cell| changed = cellOneHintRule.apply(cell) || changed }

			lines.each{|line| changed = twoCellsLineTwoHints.apply(line) || changed}
		end

		printBoard

	end

end