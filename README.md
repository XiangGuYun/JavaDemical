<h1>Java BigDecimal</h1>

BigDecimal类使用户完全控制舍入行为。如果未指定舍入模式，并且无法表示准确结果，则抛出一个异常；

否则，通过向该操作提供适当的MathContext对象，可以对已选择的精度和舍入模式执行计算。

在商业计算中要用BigDecimal。BigDecimal所创建的是对象，

我们不能使用传统的+、-、*、/等算术运算符直接对其对象进行数学运算，

而必须调用其相对应的方法。方法中的参数也必须是BigDecimal的对象。

构造器是类的特殊方法，专门用来创建对象，特别是带有参数的对象。

常用构造方法：可以将String类型的数字，int,double,long作为构造方法的参数传入进行构造一个BigDecimal对象。

常用方法：

加减乘除

    add(BigDecimal)        BigDecimal对象中的值相加，然后返回这个对象。
    subtract(BigDecimal) BigDecimal对象中的值相减，然后返回这个对象。
    multiply(BigDecimal)  BigDecimal对象中的值相乘，然后返回这个对象。
    divide(BigDecimal)     BigDecimal对象中的值相除，然后返回这个对象。

    toString()                将BigDecimal对象的数值转换成字符串。
    doubleValue()          将BigDecimal对象中的值以双精度数返回。
    floatValue()             将BigDecimal对象中的值以单精度数返回。
    longValue()             将BigDecimal对象中的值以长整数返回。
    intValue()               将BigDecimal对象中的值以整数返回。

