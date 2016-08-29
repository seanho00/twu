def transpose(matrix):
	"""Return the transpose of a matrix (2D list).
	pre: m must be a rectangular 2D list, all rows of same length."""
	numRows = len(matrix[0])
	numCols = len(matrix)

	tpose = [0] * numRows
	for row in range(numRows):
		tpose[row] = [0] * numCols
		for col in range(numCols):
			tpose[row][col] = matrix[col][row]
	return tpose
