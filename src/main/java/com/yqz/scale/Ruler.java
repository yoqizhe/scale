package com.yqz.scale;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Ruler {

    protected BigDecimal start;

    protected BigDecimal end;

    protected BigDecimal length;

    public Ruler(BigDecimal start, BigDecimal end) {
        this.start = start;
        this.end = end;
        this.length = end.subtract(start).abs();
    }

    public abstract boolean contain(BigDecimal value);

    public abstract boolean overStart(BigDecimal value);

    public abstract boolean overEnd(BigDecimal value);

    public abstract BigDecimal distanceFromStart(BigDecimal value);

    public abstract BigDecimal distanceFromEnd(BigDecimal value);

    public BigDecimal percentFromStart(BigDecimal value) {
        return distanceFromStart(value).divide(this.length, 4, RoundingMode.HALF_UP);
    }

    public BigDecimal percentFromEnd(BigDecimal value) {
        return distanceFromEnd(value).divide(this.length, 4, RoundingMode.HALF_UP);
    }

    public abstract BigDecimal getValueByPercentFromStart(BigDecimal percentFromStart);

    public abstract BigDecimal getValueByPercentFromEnd(BigDecimal percentFromEnd);

    public BigDecimal getStart() {
        return start;
    }

    public BigDecimal getEnd() {
        return end;
    }

    public BigDecimal getLength() {
        return length;
    }
}