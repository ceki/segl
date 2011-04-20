
Given the class hierarchy in the gt201104 package, your task, if you choose to
accept it, is to create a parallel class hierarchy in Scala offering new
functionality on top of the existing Java classes. The meaning of
"new functionality" is explained below.

Let us assume that for Java class A its Scala counterpart is called TamedA.

New functionality 1)
====================
TamedA must offer all the methods as those offered by A. In addition however,
for every field 'foo' of type FOO, where FOO is any type other than List,
a Scala getter and setter for foo should be offered as well. Thus, for some
instance 'tamedA' of type TamedA, one should be able to write:

  tamedA.foo = aFoo  // same as: tamedA.setFoo(aFoo)
  val otherFoo = tamedA.foo  // same as: val otherFoo = tamedA.getFoo()

New functionality 2)
====================

For a field returning a java.util.List of foos (foo of type FOO), TamedA should
offer a  method fooList() returning an object of type TamedList.
TamedList must be list-like.

Let 'tamedList' designate a TamedList instance.

To be list-like, TamedList must:

1) offer an accessor for accessing elements by index. For example,

tamedList(0) must return the 1st element in the list. The type of the returned
object should be TamedFoo.

2) TamedList should offer the method add(f: Foo). Moreover, any additions to a
TamedList must impact the original java.util.List as well.

3) TamedList must offer the method
exists(p: TamedFoo => Boolean): Boolean which tests whether a predicate 'p'
holds for some of the elements of the list.

This exercise was inspired from a real-world problem where a class hierarchy
consisting of 50+ classes needed to be decorated with new functionality.