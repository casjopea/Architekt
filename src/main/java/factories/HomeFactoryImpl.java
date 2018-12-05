package factories;

import models.Element;
import models.Home;
import models.Room;
import models.properties.HomeProperty;
import models.properties.RoomProperty;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class HomeFactoryImpl implements HomeFactory {
    RoomFactory roomFactory = new RoomFactoryImpl();

    @Override
    public Home createHome(List<String> lines, String separator) {
        //create home using roomFactory
        String[] roomLine = lines.get(0).split(separator);

        Map<HomeProperty, String> homeDetails = new EnumMap<>(HomeProperty.class);
        homeDetails.put(HomeProperty.HOME_NAME, roomLine[0]);
        homeDetails.put(HomeProperty.ADDRESS, roomLine[1]);
        homeDetails.put(HomeProperty.HOMEMADE_COUNT, roomLine[2]);
        homeDetails.put(HomeProperty.ROOMS_COUNT, roomLine[3]);

        int countRooms = Integer.parseInt(homeDetails.get(HomeProperty.ROOMS_COUNT));
        List<Element> roomsList = new ArrayList<>();
        for (int i = 1; i < countRooms; i++) {
            Room room = RoomFactory.createRoom(lines.get(i), separator);
            roomsList.add(room);
        }
        return new Home(name, address, householdCount, rooms);
    }
}
