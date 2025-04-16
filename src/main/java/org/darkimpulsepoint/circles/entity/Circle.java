package org.darkimpulsepoint.circles.entity;

public class Circle {
    private double x;
    private double y;
    private double radius;


    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return (Double.compare(circle.x, x) == 0 &&
               Double.compare(circle.y, y) == 0 &&
               Double.compare(circle.radius, radius) == 0);
    }

    @Override
    public int hashCode() {
        int result = 17;
        long xBits = Double.doubleToLongBits(x);
        long yBits = Double.doubleToLongBits(y);
        long radiusBits = Double.doubleToLongBits(radius);
        
        result = 31 * result + (int)(xBits ^ (xBits >>> 32));
        result = 31 * result + (int)(yBits ^ (yBits >>> 32));
        result = 31 * result + (int)(radiusBits ^ (radiusBits >>> 32));
        
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Circle{");

        sb.append("x=").append(this.getX());
        sb.append(", y=").append(this.getY());
        sb.append(", radius=").append(this.getRadius());
        sb.append("}");

        return sb.toString();
    }
}