import factories.HomeFactory;
import factories.HomeFactoryImpl;

import models.Home;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HomeLoaderImpl implements HomeLoader {
    HomeFactory homeFactory = new HomeFactoryImpl();

    @Override
    public Home loadHome(String fileName, String separator) {
        //load file and use home factory to create home

        FileReader fr = null;
        String line = "";

        // OTWIERANIE PLIKU
        try {
            fr = new FileReader("home");
        } catch (FileNotFoundException e) {
            System.exit(1);
        }

        BufferedReader bfr = new BufferedReader(fr);
        List<String> strList = new ArrayList<>();
        // ODCZYT KOLEJNYCH LINII Z PLIKU I ZAPIS DO LISTY
        try {
            while ((line = bfr.readLine()) != null) {
                strList.add(line);
            }
        } catch (IOException e) {
            System.exit(2);
        }

        // ZAMYKANIE PLIKU
        try {
            fr.close();
        } catch (IOException e) {
            System.exit(3);
        }


        Home home = homeFactory.createHome(strList, separator);


        return home;
    }
}
