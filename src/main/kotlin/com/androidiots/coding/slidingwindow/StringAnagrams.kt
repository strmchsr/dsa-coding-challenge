package com.androidiots.coding.slidingwindow

object StringAnagrams {
    fun findStringAnagram(str: String, pattern: String): List<Int> {
        var indices = mutableListOf<Int>();
        var frequencyMap = mutableMapOf<Char, Int>()
        pattern.forEach {
            frequencyMap[it] = frequencyMap.getOrDefault(it, 0) + 1
        }
        var matches = 0
        var windowStart = 0
        str.forEachIndexed { windowEnd, value ->
            if (frequencyMap.containsKey(value)) {
                frequencyMap[value] = frequencyMap.getOrDefault(value, 0) - 1
                if (frequencyMap[value] == 0) {
                    matches++
                }
            }
            if (matches == frequencyMap.size) {
                indices.add(windowStart);
            }

            if (windowEnd >= pattern.length - 1) {
                var leftChar = str.toCharArray()[windowStart++]
                if (frequencyMap[leftChar] == 0) {
                    matches--
                }
                frequencyMap[leftChar] = frequencyMap.getOrDefault(leftChar, 0) + 1
            }

        }

        return indices;
    }
}

fun main() {
    var result = StringAnagrams.findStringAnagram("abbcabc","abc")
    var i = 0
    var list = arrayOf("Shashank", "Ravi")
    println(list[i++])
    print(result)
}