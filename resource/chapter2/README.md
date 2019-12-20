# 观察者模式（Observer Pattern）

## 认识观察者模式
我们先来看看生活中的报纸和杂志的订阅是怎么回事：
1. 报社的业务就是出版报纸。
2. 向某家报社订阅报纸后，只要他们有新的报纸出版，就会给你送来。只要你是他们的订户，你就会一直收到新报纸。
3. 当你不想再看报纸的时候，取消订阅就可以。
4. 只要报社还在运营，就会一直有人（或单位）向他们订阅报纸或取消订阅报纸。

出版者（Subject） + 订阅者（Observer） = 观察者模式

## 定义观察者模式
**观察者模式**定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新。

## 设计气象站
![设计气象站UML图](https://github.com/RegulusHS/Head-First-Design-Patterns/blob/master/resource/chapter2/设计气象站UML图.jpg)

## Java内置的观察者模式
修改后的气象站OO设计UML图
![修改后气象站OO设计](https://github.com/RegulusHS/Head-First-Design-Patterns/blob/master/resource/chapter2/修改后气象站OO设计.jpg)

### java.util.Observable存在的缺点
1. Observable是一个类
首先，因为Observable是一个“类”，你必须设计一个类继承它。而Java不支持多重继承。这限制了Observable的复用潜力。
再者，因为没有Observable接口，所以你无法建立自己的实现，和Java内置的Observer API搭配使用，也无法将java.util的实现换成另一套做法的实现。
2. Observable将关键的方法保护起来
如果你看看Observable API，你会发现setChanged()方法被保护起来了（被定义成protected）。这意味着：除非你继承自Observable，否则你无法创建Observable实例并组合到你自己的对象中来。这个设计违反了第二个设计原则：“多用组合，少用继承”。

## JDK中的观察者模式
