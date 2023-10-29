package com.yqz.scale;

import java.math.BigDecimal;

public class PositiveRuler extends Ruler{

    PositiveRuler(BigDecimal start, BigDecimal end) {
        super(start, end);
    }

    @Override
    public boolean contain(BigDecimal value) {
        return value.compareTo(start) >= 0 && value.compareTo(end) <= 0;
    }

    @Override
    public boolean overStart(BigDecimal value) {
        return value.compareTo(this.start) == -1;
    }

    @Override
    public boolean overEnd(BigDecimal value) {
        return value.compareTo(this.end) == 1;
    }

    @Override
    public BigDecimal distanceFromStart(BigDecimal value) {
        return value.subtract(this.start);
    }

    @Override
    public BigDecimal distanceFromEnd(BigDecimal value) {
        return this.end.subtract(value);
    }

    @Override
    public BigDecimal getValueByPercentFromStart(BigDecimal percentFromStart) {
        return this.start.add(percentFromStart.multiply(this.length));
    }

    @Override
    public BigDecimal getValueByPercentFromEnd(BigDecimal percentFromEnd) {
        return this.end.subtract(percentFromEnd.multiply(this.length));
    }
}
