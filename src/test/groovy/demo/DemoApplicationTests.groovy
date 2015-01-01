package demo

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Component-level test.
 */
@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = DemoApplication)
class DemoApplicationTests {

	@Test
	void contextLoads() {
		assert 1 == 2 - 1
	}

}
