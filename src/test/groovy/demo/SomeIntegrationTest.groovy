package demo

import groovy.util.logging.Slf4j
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Integration-level test.
 */
@Slf4j
@ContextConfiguration(loader = SpringApplicationContextLoader, classes = DemoApplication )
@IntegrationTest
class SomeIntegrationTest extends Specification {

	def 'exercise loading the context'() {

		given:
		log.debug( 'running integration test' )
		def i = 10

		when:
		i += 1

		then:
		i == 11
	}
}
