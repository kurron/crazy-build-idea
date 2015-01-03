package demo

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
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

	@Autowired
	private DemoIntegrationPoint sut

	def 'exercise integration'() {

		given:
		log.debug( 'running integration test' )
		sut

		when:
		def result = sut.echo( 'hello' )

		then:
		'hello' == result
	}
}
