class Solution {
    // This could be cleaned up a good bit
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val foundCandidates = mutableMapOf<Map<Int, Int>, List<Int>>()
        val seenCandidates = mutableMapOf<Map<Int, Int>, MutableSet<Int>>()

        fun sumHelper(seenIndexes: Set<Int>, testCandidatesMap: Map<Int, Int>, testCandidatesList: List<Int>, target: Int) {
            val foundSeenCandidates = seenCandidates[testCandidatesMap]
            if (foundSeenCandidates != null && foundSeenCandidates.contains(target)) {
                return
            } else if (foundSeenCandidates == null) {
                seenCandidates[testCandidatesMap] = mutableSetOf(target)
            } else {
                foundSeenCandidates.add(target)
            }
            if (target == 0)  {
                val foundCandidatesList = foundCandidates[testCandidatesMap]
                if (foundCandidatesList == null) {
                    foundCandidates[testCandidatesMap] = testCandidatesList
                }
            } else {
                candidates.forEachIndexed { index, candidate ->
                    if (!seenIndexes.contains(index) && target - candidate >= 0) {
                        val newTestCandidates = testCandidatesMap.toMutableMap()
                        val foundCandidate = newTestCandidates[candidate]
                        if (foundCandidate != null) {
                            newTestCandidates[candidate] = foundCandidate + 1
                        } else {
                            newTestCandidates[candidate] = 1
                        }
                        sumHelper(seenIndexes + index, newTestCandidates, testCandidatesList + candidate, target - candidate)
                    }
                }
            }
        }

        sumHelper(emptySet(), emptyMap(), emptyList(), target)

        return foundCandidates.values.toList()
    }
}