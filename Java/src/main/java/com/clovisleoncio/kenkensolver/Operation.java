package com.clovisleoncio.kenkensolver;

import java.util.List;

public abstract class Operation {

	public abstract boolean isValid(List<Integer> candidates, int result);

	protected static final Operation SUM = new Operation() {

		@Override
		public boolean isValid(List<Integer> candidates, int result) {
			return candidates.stream().mapToInt(i -> i.intValue()).sum() == result;
		}
		
	};

}
