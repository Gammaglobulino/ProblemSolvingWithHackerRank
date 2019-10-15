package ProblemSolvingFromHackerRank.CountingValleys

fun countingValleys(n: Int, s: String): Int {
    var seaLevel=0
    var valleys= 0

    for(step in s){
        when{
            step=='U'->{
                if(seaLevel==-1)valleys++
                seaLevel++
            }
            step=='D'->{
                seaLevel--
            }
        }
    }
    return valleys

}
fun main(args:Array<String>):Unit{
    val path="UDDDUDUU"
    println("Number of valleys:${countingValleys(path.length,path)}")


}