class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val foundCandidates = mutableMapOf<Map<Int, Int>, List<Int>>()

        fun sumHelper(testCandidatesMap: Map<Int, Int>, testCandidatesList: List<Int>, target: Int) {
            if (target == 0)  {
                val foundCandidatesList = foundCandidates[testCandidatesMap]
                if (foundCandidatesList == null) {
                    foundCandidates[testCandidatesMap] = testCandidatesList
                }
            } else {
                candidates.forEach { candidate ->
                    if (target - candidate >= 0) {
                        val newTestCandidates = testCandidatesMap.toMutableMap()
                        val foundCandidate = newTestCandidates[candidate]
                        if (foundCandidate != null) {
                            newTestCandidates[candidate] = foundCandidate + 1
                        } else {
                            newTestCandidates[candidate] = 1
                        }
                        sumHelper(newTestCandidates, testCandidatesList + candidate, target - candidate)
                    }
                }
            }
        }

        sumHelper(emptyMap(), emptyList(), target)

        val candidatesList = mutableListOf<List<Int>>()
        return foundCandidates.values.toList()
    }
}