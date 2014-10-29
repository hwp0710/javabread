package secondalgorithm.Chap06.merge;

// merge.java
// demonstrates merging two arrays into a third
// to run this program: C>java MergeApp
////////////////////////////////////////////////////////////////
class MergeApp
{
	public static void main(String[] args)
	{
		int[] arrayA = {23, 47, 81, 95};
		int[] arrayB = {7, 14, 39, 55, 62, 74};
		int[] arrayC = new int[10];

		merge(arrayA, 4, arrayB, 6, arrayC);
		display(arrayC, 10);
	} // end main()

	//-----------------------------------------------------------
	// merge A and B into C
	public static void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC)
	{
		int aDex = 0, bDex = 0, cDex = 0;

		while (aDex < sizeA && bDex < sizeB)
			// neither array empty
			if (arrayA[aDex] < arrayB[bDex])
				arrayC[cDex++] = arrayA[aDex++];
			else
				arrayC[cDex++] = arrayB[bDex++];

		while (aDex < sizeA)
			// arrayB is empty,
			arrayC[cDex++] = arrayA[aDex++]; // but arrayA isn't

		while (bDex < sizeB)
			// arrayA is empty,
			arrayC[cDex++] = arrayB[bDex++]; // but arrayB isn't
	} // end merge()

	public static void mergeReWrite(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {
		int aIndex = 0, bIndex = 0, cIndex = 0;
		while (aIndex < sizeA && bIndex < sizeB) {
			if (arrayA[aIndex] < arrayB[bIndex]) {
				arrayC[cIndex++] = arrayA[aIndex++];
			} else {
				arrayC[cIndex++] = arrayB[bIndex++];
			}
		}
		while (aIndex < sizeA) {
			arrayC[cIndex++] = arrayA[aIndex++];
		}
		while (bIndex < sizeB) {
			arrayC[cIndex++] = arrayB[bIndex++];
		}
	}

	//-----------------------------------------------------------
	// display array
	public static void display(int[] theArray, int size)
	{
		for (int j = 0; j < size; j++)
			System.out.print(theArray[j] + " ");
		System.out.println("");
	}
	//-----------------------------------------------------------
} // end class MergeApp
////////////////////////////////////////////////////////////////
