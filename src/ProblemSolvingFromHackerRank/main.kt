package ProblemSolvingFromHackerRank

import kotlin.test.assertEquals

fun arraySum(ar:Array<Int>):Long{

    return ar.fold(0L,{sum,element->sum+element})

}
fun compareTriplets(a:Array<Int>,b:Array<Int>):Array<Int>{
    var firstScore=0
    var secondScore=0
    assertEquals(0,a.size-b.size)
    for (x in a.indices){
        when{
            a[x]>b[x] ->firstScore++
            a[x]<b[x] ->secondScore++
        }
    }
    return arrayOf(firstScore,secondScore)
}
fun primaryDiagonal(matrix:Array<Array<Int>>):List<Int>{
    var diagonal= mutableListOf<Int>()
    for(x in matrix[0].indices){
        diagonal.add(matrix[x][x])
    }
    return diagonal
}
fun secondaryDiagonal(matrix:Array<Array<Int>>):List<Int>{
    var diagonal= mutableListOf<Int>()
    var x=0;
    for (y in (matrix[0].size -1) downTo 0 ){
       diagonal.add((matrix[y][x]))
        ++x
    }
    return diagonal
}
fun fractionsOfElements(vet:Array<Int>):List<Float>{
    var positive=0F
    var negative=0F
    var zeros=0F
    val size=vet.size

    for(x in vet){
        when {
            x > 0 ->++positive
            x < 0 ->++negative
            else -> zeros++
        }

    }
    val ret= mutableListOf<Float>()
    ret.add((positive/size))
    ret.add((negative/size))
    ret.add((zeros/size))

    return ret
}

fun printStair(num:Int):Unit{
    for (i in 1..num){
        println(printSteps(i,num))
    }
}

fun printSteps(howMany:Int,totalNum:Int):String{
    var steps:String=""
    for(x in totalNum downTo 1){
        when{
            x>howMany -> steps+=" "
            x<=howMany-> steps+="#"
        }
    }
    return steps
}
fun minMaxSum(arr:Array<Int>){
    arr.sort()
    var sum=0L
    for (x in 0..3){
        sum+=arr[x]
    }
    print("${sum} ")
    sum=0
    arr.sortDescending()
    for (x in 0..3){
        sum+=arr[x]
    }
    print(sum)

}

fun minMaxUsingFold(arr:Array<Int>){
    arr.sort()
    var sum:Long=0
    sum=arr.foldIndexed(0L){idx,sum,element ->if (idx <=3) sum+element else sum}
    print("${sum} ")
    sum=0
    arr.sortDescending()
    sum=arr.foldIndexed(0L){idx,sum,element ->if (idx <=3) sum+element else sum}
    print(sum)
}

fun main():Unit {
    // big sum of arrays
    val ints= arrayOf(1000000001,1000000002,1000000003,1000000004,1000000005)
    println(arraySum(ints))

    //Alice and Bob ranks
    val a= arrayOf(1,1,4)
    val b= arrayOf(2,1,3)
    for(x in compareTriplets(a,b)){println(x)}

    //sum of diagonal
    val matrix= arrayOf(arrayOf(11,2,4),
                        arrayOf(4,5,6),
                        arrayOf(10,8,-12))
    println(primaryDiagonal(matrix).sum())
    println(secondaryDiagonal(matrix).sum())

    //fractions of elements
    println(fractionsOfElements(arrayOf(-4,3,-9,0,4,1)))

    //staircase from numbers
    printStair(10)

    //sum of sorted numbers
    val vet= arrayOf(100001,200002,30003,40002,500001)
    minMaxSum(vet)



}