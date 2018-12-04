package factories;

import models.Element;
import models.Room;

import models.properties.RoomProperty;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static models.properties.RoomProperty.COUNT_ELEMENTS;

public class RoomFactoryImpl implements RoomFactory {
    ElementFactory elementFactory = new ElementFactoryImpl();

    @Override
    public Room createRoom(List<String> lines, String separator) {
        // create room using element Factory to create each element

        String[] roomLine = lines.get(0).split(separator);

        Map<RoomProperty, String> roomDetails = new EnumMap<>(RoomProperty.class);
        roomDetails.put(RoomProperty.ROOM_NAME, roomLine[0]);
        roomDetails.put(RoomProperty.ROOM_COLOR_HEX, roomLine[1]);
        roomDetails.put(RoomProperty.AREA, roomLine[2]);
        roomDetails.put(RoomProperty.HEIGHT, roomLine[3]);
        roomDetails.put(RoomProperty.COUNT_ELEMENTS, roomLine[4]);

        List <Element> eleList = new ArrayList();
        for (int i = 0; i <lines.size() ; i++) {
            Element element = elementFactory.createElement(lines.get(i), separator);
            eleList.add(element);
        }

        String name = roomDetails.get(RoomProperty.ROOM_NAME);
        String colorHex = roomDetails.get(RoomProperty.ROOM_COLOR_HEX);
        Float area = Float.parseFloat(roomDetails.get(RoomProperty.AREA));
        Float height = Float.parseFloat(roomDetails.get(RoomProperty.HEIGHT));

        return new Room(name, colorHex, area, height, eleList);
    }
}
