package demo

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Component-level test.
 */
@Slf4j
@ContextConfiguration(loader = SpringApplicationContextLoader, classes = DemoApplication )
class SomeComponentTest extends Specification {

	@Autowired
	private DemoComponent sut

	def 'exercise component'() {

		given:
		log.debug( 'running component test' )
		sut

		when:
		def result = sut.echo( 'hello' )

		then:
		'hello' == result
	}
}
