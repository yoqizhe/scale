package com.yqz.scale;

import java.math.BigDecimal;

public class Scale {

    private Ruler a;

    private Ruler b;

    public Scale(Ruler a, Ruler b) {
        this.a = a;
        this.b = b;
    }

    public BigDecimal getB(BigDecimal aValue) {
        return getValueFromOtherRuler(aValue, this.a, this.b);
    }

    public BigDecimal getA(BigDecimal bValue) {
        return getValueFromOtherRuler(bValue, this.b, this.a);
    }

    public BigDecimal getValueFromOtherRuler(BigDecimal value, Ruler ruler, Ruler otherRuler) {
        if (ruler.overStart(value)) {
            return otherRuler.getStart();
        }
        if (ruler.overEnd(value)) {
            return otherRuler.getEnd();
        }
        return otherRuler.getValueByPercentFromStart(ruler.percentFromStart(value));
    }
}
