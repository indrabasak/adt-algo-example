Template method pattern is a behavioral design pattern which provide base method for algorithm,
called template method which defers some of its steps to subclasses So algorithm structure is 
same but some of its steps can be redefined by subclasses according to context.

Template means Preset format like HTML templates which has fixed preset format.
Similarly in template method pattern,we have a preset structure method called template 
method which consists of steps.This steps can be abstract method which will be implemented by its subclasses.

So in short you can say,In template method pattern,there is template method which defines set of steps 
and implementation of steps can be deferred to subclasses.Thus template method defines algorithm but exact steps 
can be defined in subclasses.

When to use it: 
When you have a preset format or steps for algorithm but implementation of steps may vary.
When you want to avoid code duplication,implementing common code in base class and variation in subclass.

Read more at http://javapostsforlearning.blogspot.com/2013/03/template-method-design-pattern-in-java.html#T3bLZpvytgRsEjqH.99