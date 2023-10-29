package com.yqz.scale;

import java.math.BigDecimal;

public class RulerFactory {

    public static Ruler createRuler(BigDecimal start, BigDecimal end) {
        if (start.compareTo(end) == 1) {
           return new NegativeRuler(start, end);
        } else {
            return new PositiveRuler(start, end);
        }
    }

}
