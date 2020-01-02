# 装饰者模式

## 开放 - 关闭原则

类应该对扩展开放，对修改关闭。

在选择需要被扩展的代码部分时要小心。每个地方都采用开放-关闭原则，是一种浪费，也没必要，还会导致代码变得复杂且难以理解。

## 认识装饰者模式

我们要以饮料为主体，然后在运行时以调料来“装饰”（decorate）饮料。比方说，如果顾客想要摩卡和奶泡深焙咖啡，那么，要做的是：

1. 拿一个深焙咖啡（DarkRoast）对象
2. 以摩卡（Mocha）对象装饰它
3. 以奶泡（Whip）对象装饰它
4. 调用cost()方法，并依赖委托（delegate）将调料的价钱加上去

## 装饰者的特性

- 装饰者和被装饰者对象有相同的超类型。
- 你可以用一个或多个装饰者包装一个对象。
- 既然装饰者和被装饰者对象有相同的超类型，所以在任何需要原始对象（被包装的）的场合，可以用装饰过的对象代替它。
- **装饰者可以在所委托被装饰者的行为之前与/或之后，加上自己的行为，以达到特定的目的。**
- 对象可以在任何时候被装饰，所以可以在运行时动态地、不限量地用你喜欢的装饰者来装饰对象。

## 定义装饰者模式

**装饰者模式**动态地将责任附加到对象上。若要扩展功能，装饰者提供了比继承更有弹性的替代方案。

![装饰者模式类图](https://github.com/RegulusHS/Head-First-Design-Patterns/blob/master/resource/chapter3/装饰者模式.jpg)

## 星巴兹饮料类图

![星巴兹饮料类图](https://github.com/RegulusHS/Head-First-Design-Patterns/blob/master/resource/chapter3/星巴兹饮料类图.jpg)

**继承Beverage抽象类，是为了有正确的类型，而不是继承它的行为。行为来自装饰者和基础组件，或与其他装饰者之间的组合关系。**

## 真实世界的装饰者：Java I/O

1. FileInputStream 是被装饰的“组件”。Java I/O 程序库提供了几个组件，包括了 FileInputStream、StringBufferInputStream、ByteArrayInputStream……等。这些类都提供了最基本的字节读取功能。
2. BufferedInputStream 是一个具体的“装饰者”，它加入两种行为：利用缓冲输入来改进性能；用一个 readLine()方法（用来一次读取一行文本输入数据）来增强接口。
3. LineNumberInputStream 也是一个具体的“装饰者”。它加上了计算行数的能力。

BufferedInputStream 及 LineNumberInputStream 都扩展自 FilterInputStream，而 FilterInputStream 是一个抽象的装饰类。

![Java I/O类](https://github.com/RegulusHS/Head-First-Design-Patterns/blob/master/resource/chapter3/Java%20I_O.jpg)
