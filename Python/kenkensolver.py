#!/usr/bin/env python

from board import Board
from group import Group
from operation import Operation

size = 4

groups = {
	"a": Group(5, Operation.get("+")),
	"b": Group(5, Operation.get("+")),
	"c": Group(7, Operation.get("+")),
	"d": Group(8, Operation.get("+")),
	"e": Group(1),
	"f": Group(10, Operation.get("+")),
	"g": Group(4, Operation.get("+"))
}

#aabb
#cddd
#ccfe
#ggff

pattern = 'aabbcdddccfeggff'

board = Board(size)

for i in range(0, size * size):
	groupName = pattern[i]
	group = groups[groupName]
	cell = board.cells[i]
	group.add(cell)

board.groups = groups.values()

board.solve()

for cell in board.cells:
	print cell.value, cell.hints