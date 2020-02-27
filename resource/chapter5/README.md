# 单件模式（Singleton Pattern）

有一些对象其实我们只需要一个，比如说：线程池（threadpool）、缓存（cache）、对话框、处理偏好设置和注册表（registry）的对象、日志对象，充当打印机、显卡等设备的驱动程序的对象。事实上，这类对象只能有一个实例，如果制造出多个实例，就会导致许多问题产生，例如：程序的行为异常、资源使用过量，或者是不一致的结果。

## 剖析经典的单件模式实现

```java
public class Singleton {
    //利用一个静态变量来记录Singleton类的唯一实例
    private static Singleton uniqueInstance;
    
    //这里是其他的有用实例化变量
    
    //把构造器声明为私有的,只有自Singleton类内才可以调用构造器
    private Singleton() {}
    
    //用getInstance()方法实例化对象,并返回这个实例
    public static Singleton getInstance() {
        //如果uniqueInstance是空的,表示还没有创建实例……
        if (uniqueInstance == null) {
            //利用私有的构造器产生一个Singleton实例并把它赋值到uniqueInstance静态变量中(延迟实例化)
            uniqueInstance = new Singleton();
        }
        //如果uniqueInstance不是null,就表示之前已经创建过对象。我们就直接跳到return语句
        return uniqueInstance;
    }
    
    //这里是其他的有用方法
}
```

## 定义单件模式

**单件模式确保一个类只有一个实例，并提供一个全局访问点。**

![单件模式类图](https://github.com/RegulusHS/Head-First-Design-Patterns/blob/master/resource/chapter5/单件模式类图.jpg)

## 处理多线程

![多线程下的单件模式](https://github.com/RegulusHS/Head-First-Design-Patterns/blob/master/resource/chapter5/多线程下的单件模式.jpg)

只要把`getInstance()`变成同步（synchronized）方法，多线程灾难几乎就可以轻易地解决了：

```java
public class Singleton {
    private static Singleton uniqueInstance;
    
    // 其他有用的实例化的变量
    
    private Singleton() {}
    
    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
    
    // 其他有用的方法
}
```

但是同步会降低性能。只有第一次执行此方法时，才真正需要同步。换句话说，一旦设置好 `uniqueInstance` 变量，就不再需要同步这个方法了。之后每次调用这个方法，同步是一种累赘。

## 多线程改善

1. 如果`getInstance()`的性能对应用程序不是很关键，就什么都别做

   如果你的应用程序可以接受`getInstance()`造成的额外负担，同步`getInstance()`的方法既简单又有效。但是你必须知道，同步一个方法可能造成程序执行效率下降100倍。如果将`getInstance()`的程序使用在频繁运行的地方，你可能就得重新考虑了。

2. 使用“急切”创建实例，而不用延迟实例化的做法

   如果应用程序总是创建并使用单件实例，或者在创建和运行时方面的负担不太繁重，你可能想要急切（eagerly）创建此单件，如下所示：

   ```java
   public class Singleton {
       //在静态初始化器(static initializer)中创建单件,这段代码保证了线程安全(thread safe)
       private static Singleton uniqueInstance = new Singleton();
       
       private Singleton() {}
       
       public static Singleton getInstance() {
           return uniqueInstance;
       }
   }
   ```

3. 用“双重检查加锁”，在`getInstance()`中减少使用同步

   利用双重检查加锁（double-checked locking），首先检查是否实例已经创建了，如果尚未创建，“才”进行同步。这样一来，只有第一次会同步，这正是我们想要的。

   ```java
   public class Singleton {
       private volatile static Singleton uniqueInstance;
       
       private Singleton() {}
       
       public static Singleton getInstance() {
           //检查实例,如果不存在,就进入同步区块
           if (uniqueInstance == null) {
               //注意,只有第一次才彻底执行这里的代码
               synchronized (Singleton.class) {
                   //进入区块后,再检查一次.如果仍是null,才创建实例
                   if (uniqueInstance == null) {
                       uniqueInstance = new Singleton();
                   }
               }
           }
           return uniqueInstance;
       }
   }
   ```

   ⭐ volatile 关键词确保：当`uniqueInstance`变量被初始化成`Singleton`实例时，多个线程正确地处理`uniqueInstance`变量。

   如果性能是你关心的重点，那么这个做法可以帮你大大地减少`getInstance()`的时间耗费。