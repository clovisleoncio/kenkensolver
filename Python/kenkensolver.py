#!/usr/bin/env python

from board import Board
from group import Group
from operation import Operation

size = 3

groups = {
	"a": Group(3, Operation.get("+")),
	"b": Group(4, Operation.get("+")),
	"c": Group(5, Operation.get("+")),
	"d": Group(3),
	"e": Group(3, Operation.get("+"))
}

pattern = 'aabccbdde'

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