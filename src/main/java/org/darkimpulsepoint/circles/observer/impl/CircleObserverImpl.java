package org.darkimpulsepoint.circles.observer.impl;

import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.observer.CircleObserver;
import org.darkimpulsepoint.circles.pool.CircleParameters;
import org.darkimpulsepoint.circles.pool.Warehouse;
import org.darkimpulsepoint.circles.service.CircleService;

public class CircleObserverImpl implements CircleObserver<Circle> {
    private Warehouse warehouse;
    private CircleService circleService;

    public CircleObserverImpl(Warehouse warehouse, CircleService circleService){
        this.warehouse = warehouse;
        this.circleService = circleService;
    }

    @Override
    public void update(Circle item) {
        warehouse.put(item, new CircleParameters(circleService.findCirclePerimeter(item), circleService.findCircleArea(item)));
    }
}
