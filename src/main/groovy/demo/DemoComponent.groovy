package demo

import org.springframework.stereotype.Service

/**
 * A dummy object used to test JaCoCo's handling of component test results.
 */
@Service
class DemoComponent {

    String echo( String message ) {
        message
    }
}
