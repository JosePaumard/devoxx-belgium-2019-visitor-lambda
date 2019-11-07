package org.paumard.visitor;

import org.paumard.visitor.model.Body;
import org.paumard.visitor.model.Car;
import org.paumard.visitor.model.Engine;
import org.paumard.visitor.model.Wheel;

import java.util.List;
import java.util.stream.Collectors;

public class PlayWithVisitor {

    public static void main(String[] args) {

        Car renault = new Car();

//        VisitorInitializer<String> visitorInitializer =
//                builder -> {
//                    builder.register(Car.class, car -> "Visited car" + car);
//                    builder.register(Body.class, body -> "Visited body" + body);
//                    builder.register(Engine.class, engine -> "Visited engine" + engine);
//                    builder.register(Wheel.class, wheel -> "Visited wheel" + wheel);
//                };

        VisitorInitializer<String> visitorInitializer =
                Visitor.<Car, String>forType(Car.class).execute((Car car) -> "Visited car" + car)
                    .forType(Body.class).execute((Body body) -> "Visited body" + body)
                    .forType(Engine.class).execute((Engine engine) -> "Visited engine" + engine)
                    .forType(Wheel.class).execute((Wheel wheel) -> "Visited wheel" + wheel);

        Visitor<String> visitor = Visitor.of(visitorInitializer);

        String visit = visitor.visit(renault);
        System.out.println("visit = " + visit);

        String visit1 = visitor.visit(renault.getBody());
        System.out.println("visit1 = " + visit1);

        @SuppressWarnings("all")
        VisitableFactory<Car> visitableFactory =
                    VisitableFactory.visiting(Car.class)
                    .collectsFrom(
                            car -> car,
                            car -> car.getBody(),
                            car -> car.getEngine(),
                            car -> car.getWheels()[0]
                    );
        Visitable<Car> visitableRenaut = visitableFactory.makeVisitable(renault);

        String accept = visitableRenaut.accept(visitor, Collectors.joining(" -- "));
        System.out.println("accept = " + accept);

        List<String> accept1 = visitableRenaut.accept(visitor, Collectors.toList());
        accept1.forEach(System.out::println);
    }

}
