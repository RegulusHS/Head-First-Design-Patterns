# 工厂模式（Factory Pattern）

我们在创建一个对象时，通常都是使用 new() 的方法。这样会导致当发生变化时，我们需要去修改代码，增加具体的实例或者删除不用的实例。而我们不应该针对实现编程，设计应该“对扩展开放，对修改关闭”。

工厂（factory）处理创建对象的细节。

## 简单工厂

简单工厂其实不是一个设计模式，反而比较像是一种编程习惯。

![披萨店类图](https://github.com/RegulusHS/Head-First-Design-Patterns/blob/master/resource/chapter4/披萨店类图.jpg)

## 认识工厂方法模式（P131）

