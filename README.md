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

