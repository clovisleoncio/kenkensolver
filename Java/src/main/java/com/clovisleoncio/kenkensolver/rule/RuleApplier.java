package com.clovisleoncio.kenkensolver.rule;

public class RuleApplier<T> {
	
	private Rule<T>[] rules;
	private T[] subjects;
	
	public RuleApplier(Rule<T>[] rules, T[] subjects) {
		this.rules = rules;
		this.subjects = subjects;
	}

	public boolean apply() {
		boolean changed = false;
		for (Rule<T> rule : rules) {
			for (T subject : subjects) {
				changed = rule.apply(subject) || changed;
			}
		}
		return changed;
	}


}
