package KotlinStudy

fun main(args: Array<String>){
    println("Hello Word")

    println( sum(1,2))
    sum2(3,4)
}

fun sum(a:Int, b:Int): Int{
    return a+b
}

fun sum2(a:Int,b:Int){
    println(a+b)
}