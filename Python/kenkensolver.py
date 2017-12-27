#!/usr/bin/env python

from board import Board
from group import Group
from operation import Operation

size = 4
groups = {
	"a": Group(6, Operation.get("+")),
	"b": Group(7, Operation.get("+")),
	"c": Group(4, Operation.get("+")),
	"d": Group(7, Operation.get("+")),
	"e": Group(7, Operation.get("+")),
	"f": Group(9, Operation.get("+"))
}
#acee
#adef
#addf
#bbbf
pattern = 'aceeadefaddfbbbf'

board = Board(size)

for i in range(0, size * size):
	groupName = pattern[i]
	group = groups[groupName]
	cell = board.cells[i]
	group.add(cell)

board.groups = groups.values()

board.solve()
