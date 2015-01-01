package demo

import spock.lang.Specification

/**
 * An example of a unit-level test.
 */
class SomeUnitTest extends Specification {

    def 'exercise some math'() {
        given:
        def i = 10

        when:
        i += 1

        then:
        i == 11
    }
}
