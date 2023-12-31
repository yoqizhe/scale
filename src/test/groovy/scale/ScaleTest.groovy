/*
 * This Spock specification was generated by the Gradle 'init' task.
 */
package scale


import com.yqz.scale.RulerFactory
import com.yqz.scale.Scale
import spock.lang.Specification

import java.math.RoundingMode

class ScaleTest extends Specification {

    def "test ruler"() {
        setup:
        def _02 = new BigDecimal(0.2)
        def _05 = new BigDecimal(0.5)

        def positionRuler = RulerFactory.createRuler(BigDecimal.ONE, _02) // 1 - 0.2
        def incomeRuler = RulerFactory.createRuler(BigDecimal.ZERO, BigDecimal.ONE); // 0 - 1
        def scale = new Scale(incomeRuler, positionRuler);

        when:
        // A(0.5) = 5/8 -> b = 5 / 8 = 0.6
        def b = scale.getB(_05).setScale(1, RoundingMode.HALF_UP)

        then:
        b.equals(new BigDecimal(0.6).setScale(1, RoundingMode.HALF_UP))
    }

}
