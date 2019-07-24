# kotlinDemo
kotlinDemo

练习kotlin所写的demo

高阶函数
-----
参考链接 https://blog.csdn.net/u013064109/article/details/78786646#3<br>
forEach 遍历集合对象的功能<br>
let 1、实际上是一个作用域函数，定义一个变量在一个特定的作用域范围内 2、表示object不为null的条件下，才会去执行let函数体<br>
with 将某对象作为函数的参数，在函数块内可以通过 this 指代该对象<br>
~~~
val result = with(user) {
        //直接调用即可
        println("my name is $name, I am $age years old, my phone number is $phoneNum")
    }
~~~
until  相当于闭区间 从0到size-1<br>
mapTo将给定的变换函数应用于原始数组的每个元素，并将结果附加到给定目标。<br>
~~~
 (0 until mTitles.size)
            .mapTo(mTabEntities) {
                TabEntity(mTitles[it], mIconSelectIds[it], mIconUnSelectIds[it])
            }
~~~

kotlin语法
=====
常量：val(标识符)：（类型）= （初始化值）<br>
变量：var（标识符）：（类型） = （初始化值）<br>
注：常量与变量都可以没有初始化值，但是在引用前必须初始化，声明是可不指定类型，编译器支持自动类型判断如：<br>
    val b = 1 系统自动推断变量类型为Int

函数定义
----
使用关键字fun，参数格式为：参数：类型<br>

有返回值：
~~~
fun sum（a:Int，b:Int）:Int{
             return a+b
          }
~~~
无返回值：
~~~
fun printSum(a:Int,b:Int):Unit{
              print(a+b)
          }
~~~
表达式作为函数体，返回类型自动推断：<br>
          fun sum(a:Int,b:Int) = a+b

注：public方法则必须明确写出返回类型<br>
          public fun sum (a:Int,b:Int):Int = a+b<br>
    如果返回Unit类型，则可以省略，public方法也一样

可变长参数函数
-----
函数变长参数可以用vararg关键字进行标识：<br>
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
Kotlin的基本数据类型包括Byte、Short、Int、Long、Float、Double,字符不属于数值类型，是一个独立的数据类型<br>
Kotlin中，只有封装的数字类型，每定义一个变量，kotlin帮你封装了一个对象，可以保证不会出现空指针，
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
* toByte(): Byte<br>
* toShort(): Short<br>
* toInt(): Int<br>
* toLong(): Long<br>
* toFloat(): Float<br>
* toDouble(): Double<br>
* toChar(): Char<br>
注：某些情况下可以使用自动类型转化，前提是可根据上下文推断出正确的数据类型而且数学操作符会做相应的重载。例如下面是正确的：<br>
val l = 1L + 3 // Long + Int => Long

数组
-----
数组的创建两种方式：一种是使用函数arrayOf()；另外一种是使用工厂函数。如下所示，我们分别是两种方式创建了两个数组：<br>
~~~
fun main(args: Array<String>) {
    //[1,2,3]<br>
    val a = arrayOf(1, 2, 3)<br>
    //[0,2,4]  i相当于索引位置从0开始，3应该是数组长度
    val b = Array(3, { i -> (i * 2) })

    //读取数组内容<br>
    println(a[0])    // 输出结果：1
    println(b[1])    // 输出结果：2
}
~~~
字符串()
----
Kotlin 支持三个引号 """ 扩起来的字符串，支持多行字符串，比如：<br>
 val text = """<br>
    多行字符串<br>
    多行字符串<br>
    """<br>
字符串可以包含模板表达式。模板表达式以美元符（$）开头，由一个简单的名字构成:<br>
 >val i = 10<br>
 >val s = "i = $i" // 求值结果为 "i = 10"<br>

 >val s = "runoob"<br>
 >val str = "$s.length is ${s.length}" // 求值结果为 "runoob.length is 6"<br>

 原生字符串和转义字符串内部都支持模板。需要在原生字符串中表示字面值 $ 字符（它不支持反斜杠转义），你可以用下列语法：<br>
  val price = """<br>
     ${'$'}9.99<br>
     """<br>
     println(price)  // 求值结果为 $9.99

kotlin条件控制语句
-----
~~~
var max: Int
if (a > b) {
    max = a
} else {
    max = b
}
~~~
// 作为表达式（kotlin没有三元运算符，这个可以代替）<br>
val max = if (a > b) a else b

* 使用区间：（运算符 in，格式x..y）
使用 in 运算符来检测某个数字是否在指定区间内，区间格式为 x..y ：<br>
~~~
 val x = 5
    val y = 9
    if (x in 1..8) {
        println("x 在区间内")
    }
~~~
* When表达式
when 将它的参数和所有的分支条件顺序比较，直到某个分支满足条件。<br>
when 既可以被当做表达式使用也可以被当做语句使用。如果它被当做表达式，符合条件的分支的值就是整个表达式的值，如果当做语句使用， 则忽略个别分支的值。<br>
when 类似其他语言的 switch 操作符。其最简单的形式如下：<br>
~~~
when (x) {
    1 -> print("x == 1")
    2 -> print("x == 2")
    else -> { //else 同 switch 的 default
        print("x 不是 1 ，也不是 2")
    }
}
~~~
如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔：<br>
~~~
when (x) {
    1,2 -> print("x == 1 or x == 2")
    else -> {
        print("x 不是 1 ，也不是 2")
    }
}
~~~
检测一个值在（in）或者不在（!in）一个区间或者集合中：<br>
~~~
when (x) {
    in 1..10 -> print("x is in the range")
    in validNumbers -> print("x is valid")
    !in 10..20 -> print("x is outside the range")
    else -> print("none of the above")
}
~~~
检测一个值是（is）或者不是（!is）一个特定类型的值。
~~~
  val res: Any? = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else ->  deSerialization(getString(name,serialize(default)))
        }
~~~
kotlin循环控制语句
-----
* for 循环可以对任何提供迭代器（iterator）的对象进行遍历，语法如下:
~~~
for (item in collection) print(item)
~~~
这种"在区间上遍历"会编译成优化的实现而不会创建额外对象。<br>
~~~
for (i in array.indices) {
    print(array[i])
}
~~~
示例：
~~~
fun main(args: Array<String>) {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}
~~~
输出结果
apple<br>
banana<br>
kiwi<br>
item at 0 is apple<br>
item at 1 is banana<br>
item at 2 is kiwi<br>
* while 与 do...while 循环
while是最基本的循环，while语句，如果不满足条件，则不能进入循环，它的结构为：
~~~
while( 布尔表达式 ) {
  //循环内容
}
~~~
do…while循环和 while循环相似，不同的是，do…while 循环至少会执行一次。
~~~
do {
       //代码语句
}while(布尔表达式);
~~~
正常循环：<br>
for (i in 1..4) print(i) // 打印结果为: "1234"<br>

需要按反序遍历整数可以使用标准库中的 downTo() 函数:<br>
for (i in 4 downTo 1) print(i) // 打印结果为: "4321"<br>

也支持指定步长：<br>
for (i in 1..4 step 2) print(i) // 打印结果为: "13"<br>
for (i in 4 downTo 1 step 2) print(i) // 打印结果为: "42"<br>

循环中不要最后一个范围区间的值可以使用 until 函数:<br>
for (i in 1 until 10) { // i in [1, 10), 不包含 10<br>
     println(i)<br>
}<br>

类
------
* 类：class<br>
~~~
 class Runoob {
    // 大括号内是类体构成
}
~~~
创建实例：val site = Runoob()<br>

* 属性：var/val<br>
~~~
 var name: String = ……
 var url: String = ……
 var city: String = ……
~~~
* 构造器：constructor<br>
通过constructor关键字来标明的，且对于Primary Constructor(主构造器)，它的位置是在类的首部（class header）当constructor关键字没有注解和可见性修饰符作用于它时
constructor关键字可以省略,若有，则不可省略,并且位于修饰符后面<br>
class Person(firstName: String) {}<br>
class Person internal constructor(firstName: String) {}<br>

* 初始化代码块
主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀<br>
~~~
init {
   println("FirstName is $firstName")
 }
~~~
次构造器
定义在类体中，可以有多个，如果有主构造器需要使用this来调用主构造器，也可以使用super关键字来调用父类构造器
~~~
 constructor(fm: FragmentManager, fragmentList: List<Fragment>) : super(fm) {
        this.fragmentList = fragmentList
    }
~~~
或
~~~
 constructor (name: String, age:Int) : this(name) {
        // 初始化...
    }
~~~

抽象类
----

~~~
abstract class HolderImageLoader(val path: String) {
        abstract fun loadImage(iv: ImageView, path: String)
    }
    ~~~

嵌套类
------

~~~
class Outer {                  // 外部类
    private val bar: Int = 1
    class Nested {             // 嵌套类
        fun foo() = 2
    }
}
~~~


内部类
----
内部类使用 inner 关键字来表示<br>
内部类会带有一个对外部类的对象的引用，所以内部类可以访问外部类成员属性和成员函数。

~~~
class Outer {
    private val bar: Int = 1
    var v = "成员属性"
    /**嵌套内部类**/
    inner class Inner {
        fun foo() = bar  // 访问外部类成员
        fun innerTest() {
            var o = this@Outer //获取外部类的成员变量,@label代指 this 来源的标签。
            println("内部类可以引用外部类的成员，例如：" + o.v)
        }
    }
}
~~~


修饰符
------
* 属性修饰符
abstract    // 抽象类  <br>
final       // 类不可继承，默认属性<br>
enum        // 枚举类<br>
open        // 类可继承，类默认是final的<br>
annotation  // 注解类<br>

* 权限修饰符
private    // 仅在同一个文件中可见<br>
protected  // 同一个文件中或子类可见<br>
public     // 所有调用的地方都可见<br>
internal   // 同一个模块中可见<br>