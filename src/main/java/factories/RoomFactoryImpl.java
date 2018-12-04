package factories;

import models.Room;
import models.properties.ElementProperty;
import models.properties.RoomProperty;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RoomFactoryImpl implements RoomFactory {
    ElementFactory elementFactory = new ElementFactoryImpl();

    @Override
    public Room createRoom(List<String> lines, String separator) {
        // create room using element Factory to create each element

        List<String> values = lines.split(separator);
        Map<RoomProperty, String> roomDetails = new EnumMap<>(RoomProperty.class);
        roomDetails.put(ElementProperty.ROOM_NAME, values[0]);

        return new Room(name, colorHex, area, height, elements);
    }
}
