package com.cdx.car.form;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: yb
 * Date: 2018/6/17
 * Time: 10:57
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
public class DistanceAngle {
    private double distance;
    private double angle;

    public DistanceAngle() {
    }

    public DistanceAngle(double distance, double angle) {
        this.distance = distance;
        this.angle = angle;
    }
}