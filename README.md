# kotlinDemo
kotlinDemo

练习kotlin所写的demo

kotlin语法
=====
常量：val(标识符)：（类型）= （初始化值）<br>
变量：var（标识符）：（类型） = （初始化值）<br>
注：常量与变量都可以没有初始化值，但是在引用前必须初始化，声明是可不指定类型，编译器支持自动类型判断如：<br>
    val b = 1 系统自动推断变量类型为Int

函数定义
----
使用关键字fun，参数格式为：参数：类型<br>

有返回值：fun sum（a:Int，b:Int）:Int{
             return a+b
          }
无返回值：fun printSum(a:Int,b:Int):Unit{
              print(a+b)
          }
表达式作为函数体，返回类型自动推断：
          fun sum(a:Int,b:Int) = a+b

注：public方法则必须明确写出返回类型
          public fun sum (a:Int,b:Int):Int = a+b
    如果返回Unit类型，则可以省略，public方法也一样

可变长参数函数
-----
函数变长参数可以用vararg关键字进行标识：
fun vars(vararg v:Int){
}

字符串
----
$表示一个变量名或变量值
$varName表示变量值
${varName.fun()}表示变量的方法返回值

NULL检查机制
----
两种方式：字段后加!!会像java一样抛出空异常，字段后加?可不做处理返回值为null或配合?:做空判断处理<br>
//类型后加?表示可为空<br>
var age :String? = "23"<br>
//抛出空指针异常<br>
val age = age!!.toInt()<br>
//age为空时返回-1<br>
val ages = age?.toInt()?:-1<br>
//不做处理<br>
val age = age?.toInt()

基本数据类型
----
Kotlin的基本数据类型包括Byte、Short、Int、Long、Float、Double，字符不属于数值类型，是一个独立的数据类型。Kotlin中，只有封装的数字类型，没定义一个变量，kotlin帮你封装了一个对象，可以保证不会出现空指针，
数字类型也一样，所有在比较两个数字的时候，就有比较数据大小和比较两个对象是否相同的区别了。
在kotlin中，三个等号===表示比较对象地址，两个==表示比较两个值大小。<br>
val a : Int = 10<br>
val b : Int = 10<br>
a==b //true,值相等<br>
a===b //false,值相等，对象地址不一样<br>

类型转换
-----
较小类型并不是较大类型的子类型，较小的类型不能隐式转换为较大的类型。也就是说不进行显示转换不能把Byte型值赋给一个Int变量
需要通过toInt方法。每种数据类型都有下面这些方法，可以转换为其他类型：<br>
*toByte(): Byte<br>
*toShort(): Short<br>
*toInt(): Int<br>
*toLong(): Long<br>
*toFloat(): Float<br>
*toDouble(): Double<br>
*toChar(): Char<br>
注：某些情况下可以使用自动类型转化，前提是可根据上下文推断出正确的数据类型而且数学操作符会做相应的重载。例如下面是正确的：<br>
val l = 1L + 3 // Long + Int => Long
