package hu.nye.progkor.dvdcatalouge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is a DVD catalog program with spring boot.
 *
 * @author István Szabó
 * @version 0.0.1
 */

@SpringBootApplication
public class DvdCatalougeApplication {

    /**
     * This is the main method. Some kind of handy description goes here.
     *
     * @param args The command line arguments.
     */

    public static void main(String[] args) {

        SpringApplication.run(DvdCatalougeApplication.class, args);
    }

}
