package ProblemSolvingFromHackerRank.SockMerchant

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    var totalpairs=0
    var currentSock=1
    ar.sort()
    while(currentSock < n){
        if(ar[currentSock-1]==ar[currentSock]) {
            totalpairs++
            currentSock+=2
        } else{
            currentSock++
        }
    }
    return totalpairs
}

fun main(args: Array<String>){
    val socks= arrayOf(1,1,2,2,1,1)
    println("Total amount if pairs:${sockMerchant(socks.size,socks)}")


}