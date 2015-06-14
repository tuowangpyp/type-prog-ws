# type-prog-ws
Type Programming in Scala 101 Workshop

## System Requirements

1. JDK 6.0+
2. sbt 0.13.x
3. git

### No git?

If you are unable to have git on your system, we can work around it.
TBD.

## Environment Check

1. Fork this repo.
2. `git clone https://github.com/[USERNAME]/type-prog-ws.git`
3. `sbt`
4. `> update`
5. `> test`

You should get a passing test and a failing test with the following output.

```text
[info] EnvironmentSpecs:
[info] The successful test
[info] - should be green
[info] The failing test
[info] - should be red *** FAILED ***
[info]   "answer" was not equal to 42 (EnvironmentSpecs.scala:11)
[info] Run completed in 230 milliseconds.
[info] Total number of tests run: 2
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 1, failed 1, canceled 0, ignored 0, pending 0
[info] *** 1 TEST FAILED ***
```

1. Open `src/test/scala/com.joescii.typeprog/EnvironmentSpecs.scala`.
2. Correct the broken test.
3. Rerun `test` and verify that you now have two green tests.
4. Commit your code.

You are now ready to begin the workshop!

## Workshop Exercises

Each exercise is delivered from the repo in a branch.
The branch will contain a test source file to guide what to build next.
Please feel free to add your own tests as needed.
You may find you need to pass some intermediate steps before trying to satisfy the tests I've provided.

There is also a complementary solution branch for each exercise with the suffix `-soln`.
For instance, the first exercise is `bool-1` and a solution is in branch `bool-1-soln`.
If you want to view solutions as you go, I recommend checking out the `type-prog-ws` repo into a second local directory to avoid merge conflicts with your own solutions.

E.g. `git clone https://github.com/[USERNAME]/type-prog-ws.git type-prog-ws-solutions`

## Bool Exercises

The first set of exercises covers the `BoolType` type shown during the introductory talk.

### bool-1

Invoke `git merge origin/bool-1` to grab the first exercise.
Run `sbt test:compile` and you will see it fails to compile.
You will see that there is an incomplete implementation of `Bool` in `src/main/scala/com.joescii.typeprog/Bool.scala`
(We're dropping `Type` from the name since that was to emphasize the similarities to the value-level dual).
Open `src/test/scala/com.joescii.typeprog/Bool1Specs.scala` and you will see it expects `Not` and `Or` types to be defined correctly.
Update `Bool` to make the compiler happy!

### bool-2

`git merge origin/bool-2`

This time you need to implement the `And` type.

Were you able to implement it by only updating the `Bool` trait?

### bool-3

`git merge origin/bool-3`

Now implement the `Imp` type, short for _implies_.

Again, you should be able to add `Imp` without changing `True` or `False`.

## Nat Exercises

The next set of exercises covers the `NatType` type introduced in the talk
(Again dropping `Type` as before).
Here we use the [Peano Axioms](http://en.wikipedia.org/wiki/Peano_axioms) to define natural numbers.

### nat-1

`git merge origin/nat-1`

The types `Nat`, `Nat0`, and `NatN` are stubbed out.
`Nat0` and `NatN` need to be subtypes of `Nat`.
`NatN` should recursively build the natural numbers.
`Nat` should declare a `plus` type for addition which the two subtypes implement.
Try it yourself first, but if you get stuck see [Peano Arithmetic](http://en.wikipedia.org/wiki/Peano_axioms#Arithmetic) for a hint on addition.

### nat-2

`git merge origin/nat-2`

This time implement a `times` type for multiplication.
Again, see [Peano Arithmetic](http://en.wikipedia.org/wiki/Peano_axioms#Arithmetic) if you get stuck.

### nat-3

`git merge origin/nat-3`

Now let's see if you can break the compiler.
Make a recursive type that causes scalac to throw a `java.lang.StackOverflowError` because it's just too deep.
Once you're done with this exercise, you'll of course want to comment out the successful line of code.
Note also that if you're using Intellij or Scala-IDE, then you'll likely crash it too.
I recommend switching to a text editor for this one.

## Vect Exercises

Now we begin to put our work to practical use.
We will implement a `Vector` as shown in the introductory talk.
It is a `Vector` in the mathematical/linear algebra sense.

### vect-1

`git merge origin/vect-1`

We will start be implementing the unsafe `Vector` shown in the talk.
You've been provided with stubbed out trait, base object, and case class.
It is up to you to complete their type definitions and implement both cons and addition.
See [Vector Addition](http://mathworld.wolfram.com/VectorAddition.html) if you need a refresher on the definition.

### vect-2

`git merge origin/vect-2`

Now it's time to make that `IllegalArgumentException` a compile-time check.
First, comment-out the `intercept` block in `Vect1Specs` as it will no longer be applicable, nor will it compile.
Update the `Vector` trait to take a `Nat` type parameter for its size.
Now go throughout `Vector.scala` adding the appropriate `Nat` type parameter to each usage of `Vector`.

### vect-3

`git merge origin/vect-3`

This time we're going to observe the power of types in documenting code.
We will define a function mysteriously named `??` using our types.
The types will lead us to a reasonable implementation of the function `??`.
The `Vect3Spec` has the details in comments.

## TypeList Exercises

Let's take a dive back into the strange world of type programming.
Now we will create a type called `TypeList`.
It can build an arbitrary list of any types.
When those types are our `Nat` types, then we effectively have lists of naturals in the type system.
Our playing around with this type will conclude with brushing up against type lambdas.

### tlist-1

`git merge origin/tlist-1`

First things first, build a `TypeList`.
For fun, our `TypeList` includes a `size` type which represents the length of the `TypeList`.
As usual, the base types are stubbed out.
Once you are done, you should be able to compile the test code.

### tlist-2

`git merge origin/tlist-2`

Since we have a list, we should be able to do operations like `reduce`.
You may make the simplifying assumption that `TNil#reduce =:= Nat0`.

### tlist-3

`git merge origin/tlist-3`

Now it's time to face the ugly syntax which is a type lambda.
There really is no syntax for this.
The comments in the test code should guide you through understanding this obtuse syntax.
There is also a hint as nothing you have seen thus far will help you know how to correctly express this concept.