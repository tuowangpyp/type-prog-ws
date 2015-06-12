# type-prog-ws
Type Programming in Scala 101 Workshop

## System Requirements

1. JDK 6.0+
2. sbt 0.13.x
3. git

## Environment Check

1. Fork this repo.
2. Clone locally.
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
