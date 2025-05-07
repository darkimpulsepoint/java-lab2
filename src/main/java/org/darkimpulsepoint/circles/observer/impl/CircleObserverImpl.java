package org.darkimpulsepoint.circles.observer.impl;

import org.darkimpulsepoint.circles.entity.Circle;
import org.darkimpulsepoint.circles.observer.Observer;
import org.darkimpulsepoint.circles.pool.CircleParameters;
import org.darkimpulsepoint.circles.pool.Warehouse;
import org.darkimpulsepoint.circles.service.CircleService;

public class CircleObserverImpl implements Observer<Circle> {
    private Warehouse warehouse;
    private CircleService circleService;

    public CircleObserverImpl(Warehouse warehouse, CircleService circleService){
        this.warehouse = warehouse;
        this.circleService = circleService;
    }

    @Override
    public void update(Circle item) {
        warehouse.update(item, new CircleParameters(circleService.findCirclePerimeter(item), circleService.findCircleArea(item)));
    }
}
