package by.it.academy;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import by.it.academy.maven.Service;


public class Main {

    public static void main(String[] args) {

      Service service  =   ServiceLoader.load(Service.class)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No service"));

        List<Integer> testdata2 = new ArrayList<>();
        testdata2.add(1);
        testdata2.add(null);
        testdata2.add(2);

        Double result = service.average(testdata2);
        System.out.println("Result: " + result);

    }
}
