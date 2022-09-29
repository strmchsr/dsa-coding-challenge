package com.androidiots.coding

fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    // Write your code here.
    var teams = mutableMapOf<String, Int>()
    var currentBestTeam = ""

    for ((index, competition) in competitions.withIndex()){
        var winningTeam = ""
        if(results[index] == 0){
            winningTeam = competition[1]
            if(teams.containsKey(competition[1])){
                teams[competition[1]] = 3+teams[competition[1]]!!
            } else {
                teams[competition[1]] = 3
            }
        } else {
            winningTeam = competition[0]
            if(teams.containsKey(competition[0])){
                teams[competition[0]] = 3+teams[competition[0]]!!
            } else {
                teams[competition[0]] = 3
            }
        }

        var currentBestTeamScore:Int =  if(teams[currentBestTeam]!=null) teams[currentBestTeam]!! else 0

        var winningTeamScore:Int =  if(teams[winningTeam]!=null) teams[winningTeam]!! else 0

        if(winningTeamScore>currentBestTeamScore){
            currentBestTeam = winningTeam
        }

    }
    return currentBestTeam
}

fun main() {
   print( tournamentWinner(arrayListOf(
       arrayListOf("HTML", "C#"),
       arrayListOf("C#", "Python"),
       arrayListOf("Python", "HTML")
   ), arrayListOf(0, 0, 1)))
}
