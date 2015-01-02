package demo

import groovy.util.logging.Slf4j
import spock.lang.Specification

/**
 * An example of a unit-level test.
 */
@Slf4j
class SomeUnitTest extends Specification {

    def 'exercise some math'() {
        given:
        log.debug( 'running unit test' )
        def i = 10

        when:
        i += 1

        then:
        i == 11
    }
}
