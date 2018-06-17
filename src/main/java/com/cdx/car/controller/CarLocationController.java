package com.cdx.car.controller;

import com.cdx.car.domain.Location;
import com.cdx.car.form.DistanceAngle;
import com.cdx.car.service.LocationService;
import com.cdx.car.util.MyEasyJsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: yb
 * Date: 2018/6/17
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Api(value = "位置中转站", description = "位置中转站接口", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController(value = "小车位置")
public class CarLocationController {
    @Autowired
    private LocationService locationService;
    @ApiOperation("接受距离和夹角")
    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    public String receive(@RequestBody DistanceAngle distanceAngle){
        Location location = locationService.calculateLocation(distanceAngle);
        String str = MyEasyJsonUtil.json2string(location);
        return str;
    }

    @ApiOperation("得到当前位置")
    @RequestMapping(value = "/getLocation", method = RequestMethod.POST)
    public String getLocation(){
        Location location = locationService.getLastLocation();
        return MyEasyJsonUtil.json2string(location);
    }

    @ApiOperation("重置起点位置")
    @RequestMapping(value = "/resetOrigin", method = RequestMethod.POST)
    public String reset(){
        Location location = locationService.restLocation();
        return MyEasyJsonUtil.json2string(location);
    }

}