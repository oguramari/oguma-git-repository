package examples.demo;

import com.intuit.karate.junit5.Karate;

public class DemoRunner {

    @Karate.Test
    Karate run() {
        return Karate.run().relativeTo(getClass());
    }
}
