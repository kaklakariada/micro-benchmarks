# micro-benchmarks
Some Java micro benchmarks

## Usage

* Build: `./gradlew jmhJar`
* Print arguments: `java -jar build/libs/micro-benchmarks-0.0.1-jmh.jar -h`
* Example: `java -jar build/libs/micro-benchmarks-0.0.1-jmh.jar -wi 2 -i 5 -f 1 -wf 1`

## Results

### [ReflectionBenchmark](src/jmh/java/reflection/ReflectionBenchmark.java)

```
Benchmark                             Mode  Cnt    Score    Error  Units
ReflectionBenchmark.direct            avgt    5    4,850 ±  0,238  ns/op
ReflectionBenchmark.directNotInlined  avgt    5    6,146 ±  0,332  ns/op
ReflectionBenchmark.reflection        avgt    5  227,670 ± 16,882  ns/op
ReflectionBenchmark.reflectionCached  avgt    5   11,478 ±  2,940  ns/op
```
