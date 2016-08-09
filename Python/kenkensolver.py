#!/usr/bin/env python

from board import Board
from group import Group
from operation import Operation

size = 4

groups = {
	"a": Group(9, Operation.get("+")),
	"b": Group(1, Operation.get("+")),
	"c": Group(5, Operation.get("+")),
	"d": Group(3, Operation.get("+")),
	"e": Group(5, Operation.get("+")),
	"f": Group(7, Operation.get("+")),
	"g": Group(5, Operation.get("+")),
	"h": Group(5, Operation.get("+"))
}

#accg
#adeg
#adeh
#bffh

pattern = 'accgadegadehbffh'

board = Board(size)

for i in range(0, size * size):
	groupName = pattern[i]
	group = groups[groupName]
	cell = board.cells[i]
	group.add(cell)

board.groups = groups.values()

board.solve()