package com.cdx.car.util;

import com.cdx.car.domain.Location;

/**
 * Created with IntelliJ IDEA.
 * User: yb
 * Date: 2018/6/17
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 * Description: 通用常量，将最近一次的位置存储在内存中
 */
public class Constant {
    public static volatile Location lastLocation;
}