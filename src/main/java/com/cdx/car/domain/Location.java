package com.cdx.car.domain;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: yb
 * Date: 2018/6/17
 * Time: 10:47
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
public class Location {
    private double x;
    private double y;
    private String msg;
    private double angle;
    private double distance;

    public Location() {
        this.x = 0;
        this.y = 0;
        this.msg = "success";
    }

    public static Location returnError() {
        Location location = new Location();
        location.setMsg("error");
        return location;
    }
}