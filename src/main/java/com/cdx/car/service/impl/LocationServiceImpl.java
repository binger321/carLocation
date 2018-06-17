package com.cdx.car.service.impl;

import com.cdx.car.domain.Location;
import com.cdx.car.form.DistanceAngle;
import com.cdx.car.service.LocationService;
import com.cdx.car.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: yb
 * Date: 2018/6/17
 * Time: 12:04
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
public class LocationServiceImpl implements LocationService {

    private Location lastLocation = Constant.lastLocation;

    //y = kx + b
    private double k;
    private double b;
    //是否平行y轴 即为 x = p 函数
    private boolean flag = false;
    private double p;

    //相对于上一个点是向左还是向右,true 右  false 左
    private boolean direction;

    @Override
    public Location calculateLocation(DistanceAngle distanceAngle) {
        if (lastLocation == null) {
            return Location.returnError();
        }
        getLine(distanceAngle.getAngle());
        boolean isSuccess = getPoint(distanceAngle.getDistance());
        if (isSuccess) {
            return lastLocation;
        } else {
            return Location.returnError();
        }
    }

    @Override
    public Location getLastLocation() {
        return lastLocation;
    }

    @Override
    public Location restLocation() {
        lastLocation = new Location();
        return lastLocation;
    }

    private boolean getPoint(double distance) {
        if (flag) {
            double x = p;
            double y = Math.pow((Math.pow(distance, 2.0) - Math.pow(p, 2.0)), 0.5);
            lastLocation.setX(x);
            lastLocation.setY(y);
            lastLocation.setMsg("success");
        } else {
            double temp = 4*k*k*b*b - 4*(k*k+1)*(b*b-distance*distance);
            if (temp < 0) {
                return false;
            }
            if (direction){
                double x = (-2*k*b + Math.pow(temp, 0.5))/(2*k*k+2);
                double y = k*x + b;
                lastLocation.setX(x);
                lastLocation.setY(y);
                lastLocation.setMsg("success");
            } else {
                double x = (-2*k*b - Math.pow(temp, 0.5))/(2*k*k+2);
                double y = k*x + b;
                lastLocation.setX(x);
                lastLocation.setY(y);
                lastLocation.setMsg("success");
            }
        }
        return true;
    }

    private void getLine(double angle) {
        if (Math.abs(angle) == 90) {
            //直线与y轴平行的情况
            p = lastLocation.getX();
            flag = true;
        } else {
            if (Math.abs(angle) < 90) {
                direction = true;
            } else {
                direction = false;
            }
            k = Math.tan(angle*Math.PI/180);
            b = lastLocation.getY() - lastLocation.getX()*k;
            flag = false;
        }
    }
}