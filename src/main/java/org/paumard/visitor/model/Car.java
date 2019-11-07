package org.paumard.visitor.model;

import org.paumard.visitor.Visitor;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Car {
    private Body body = new Body();
    private Engine engine = new Engine();
    private Wheel[] wheels = {new Wheel(), new Wheel(), new Wheel(), new Wheel()};

//    private <R> R accept(Visitor<R> visitor) {
//        return visitor.visit(this);
//    }

//    public <R, RR> RR accept(Visitor<R> visitor, Collector<? super R, ?, RR> collector) {
//        R r1 = this.body.accept(visitor);
//        R r2 = this.engine.accept(visitor);
//        R r3 = this.wheels[0].accept(visitor);
//        R r4 = this.wheels[1].accept(visitor);
//        R r5 = this.wheels[2].accept(visitor);
//        R r6 = this.wheels[3].accept(visitor);
//        R r7 = accept(visitor);
//        return Stream.of(r1, r2, r3, r4, r5, r6, r7).collect(collector);
//    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Car{" +
                "body=" + body +
                ", engine=" + engine +
                ", wheels=" + Arrays.toString(wheels) +
                '}';
    }
}
