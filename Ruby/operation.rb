class OperationSum

	def isPossibleSolution(values, result)
		return values.inject(0){|sum,x| sum + x} == result
	end

end

class Operation

	def self.+
		OperationSum.new
	end

end