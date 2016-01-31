package reflection;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 10)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class ReflectionBenchmark {

    private Testee instance;
    private Method method;

    @Setup
    public void setup() throws NoSuchMethodException {
        instance = new Testee();
        method = getMethod();
    }

    @Benchmark
    public Integer direct() {
        return instance.getInteger();
    }

    @Benchmark
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public Integer directNotInlined() {
        return instance.getInteger();
    }

    @Benchmark
    public Integer reflection() throws Exception {
        return (Integer) getMethod().invoke(instance);
    }

    @Benchmark
    public Integer reflectionCached() throws Exception {
        return (Integer) method.invoke(instance);
    }

    private Method getMethod() throws NoSuchMethodException {
        return Testee.class.getMethod("getInteger");
    }
}
