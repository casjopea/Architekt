package factories;

import models.Home;

import java.util.List;

public class HomeFactoryImpl implements HomeFactory {
    RoomFactory roomFactory = new RoomFactoryImpl();

    @Override
    public Home createHome(List<String> lines, String separator) {
        //create home using roomFactory
    }
}
