import factories.HomeFactory;
import factories.HomeFactoryImpl;

import models.Home;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HomeLoaderImpl implements HomeLoader {
    HomeFactory homeFactory = new HomeFactoryImpl();

    @Override
    public Home loadHome(String fileName, String separator) {
        //load file and use home factory to create home
        List<String> strList = new ArrayList<>();
        try (BufferedReader bfr = new BufferedReader(new FileReader(fileName))) {

            String line = "";
            while ((line = bfr.readLine()) != null) {
                strList.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException("Could not load file", e);
        }
        Home home = homeFactory.createHome(strList, separator);
        return home;
    }
}
