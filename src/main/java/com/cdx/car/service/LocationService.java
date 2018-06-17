package com.cdx.car.service;

import com.cdx.car.domain.Location;
import com.cdx.car.form.DistanceAngle; /**
 * Created with IntelliJ IDEA.
 * User: yb
 * Date: 2018/6/17
 * Time: 12:00
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface LocationService {
    Location calculateLocation(DistanceAngle distanceAngle);

    Location getLastLocation();

    Location restLocation();
}
