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


        List<Room> roomsList = new ArrayList<>();
        int start = 1;
        for (int i = 0; i < countRooms; i++) {
            List<String> stringList = lines.subList(start, lines.size());
            Room room = roomFactory.createRoom(stringList, separator);
            roomsList.add(room);
            start = start + 1 + room.getElements().size();
        }

        String name = homeDetails.get(HomeProperty.HOME_NAME);
        String address = homeDetails.get(HomeProperty.ADDRESS);
        int householdCount = Integer.parseInt(homeDetails.get(HomeProperty.HOMEMADE_COUNT));

        return new Home(name, address, householdCount, roomsList);
    }
}
