#!/usr/bin/env ruby

require './board'
require './group'
require './operation'

size = 3
groups = {
	"a": Group.new(3, Operation.+),
	"b": Group.new(5, Operation.+),
	"c": Group.new(3, Operation.+),
	"d": Group.new(4, Operation.+),
	"e": Group.new(3, Operation.+)
}
#aad
#bbd
#cee
pattern = "aadbbdcee"

board = Board.new(size)

for i in 0...size*size
	groupName = pattern[i].to_sym
	group = groups[groupName]
	cell = board.cells[i]
	group.cells << cell
end

board.groups = groups.values

board.solve()