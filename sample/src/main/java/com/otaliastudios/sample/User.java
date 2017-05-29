package com.otaliastudios.sample;

import java.util.Arrays;
import java.util.List;


public class User {

    private String fullname;
    private String username;

    public User(String fullname, String username) {
        this.fullname = fullname;
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getUsername() {
        return username;
    }

    // Thanks uinames.com
    public static List<User> USERS = Arrays.asList(
            new User("Lori Rice", "lori__rice"),
            new User("Karen Sandoval", "karen93"),
            new User("Andrea Wagner", "andrea_86"),
            new User("Jerry Sanchez", "jerry-85"),
            new User("Elizabeth Carroll", "elizabeth-94"),
            new User("Ronald Tran", "ronald_tran"),
            new User("Crystal Castillo", "crystal.castillo"),
            new User("Sean King", "sean"),
            new User("Paul Aguilar", "paul.aguilar"),
            new User("Benjamin Gonzalez", "ben-85"),
            new User("Ryan Curtis", "ryan-94"),
            new User("Jane Willis", "jane_willis"),
            new User("Diane Price", "diane__price"),
            new User("Marie Elliott", "marie95"),
            new User("Peter Cole", "peter_83"),
            new User("Donald Green", "donald-35"),
            new User("Frank Oliver", "frank-oliver"),
            new User("Doris Walters", "doris"),
            new User("Jack Lynch", "jack-lynch"),
            new User("Ruth Patel", "patel"),
            new User("Donald Obrien", "obrien.donald"),
            new User("Joyce Wells", "jwells"),
            new User("Austin Keller", "keller-94"),
            new User("Jean Watkins", "jw"),
            new User("Julio Cesar Paredes", "julio.cesar"),
            new User("Fabian Mercedesz", "fabian"),
            new User("Roma Kania", "roma.kania"),
            new User("Luna Vidal", "luna-75"),
            new User("Daisy Roberts", "roberts-93"),
            new User("Matthew Maxton", "matthew_maxton"),
            new User("Claudio Guerra", "guerra.claudio"),
            new User("Floare Carafoli", "floare84"),
            new User("Esra Yilmaz", "esra_83"),
            new User("Casanda Goian", "casanda-1935"),
            new User("Kyle Lawson", "kyle-law"),
            new User("Mathijs de Boer", "mdboer"),
            new User("Mitchell Sarah", "mitchell-sarah"),
            new User("Carolina Rotaru", "rotaru"),
            new User("Joe Fernandez", "joe.fernandez"),
            new User("Christian Colombo", "ccolombo"),
            new User("Venera Steflea", "venera-91"),
            new User("Helge Olsen", "holsen"),
            new User("Fien Smet", "fien.smet"),
            new User("Hugo Aviles", "aviles"),
            new User("Elizabeth Montoya", "elizabeth.montoya"),
            new User("Mihnea Gliga", "mihnea-75"),
            new User("Gary Cook", "cook-96"),
            new User("Seppe Smet", "seppe_smet"),
            new User("Diane Lane", "diane.lane"),
            new User("Sophia Ackroyd", "sophia"),
            new User("Octavia Sirma", "octavia_sirma"),
            new User("Ciprian Tutoveanu", "ciprian"),
            new User("Ida Birkeland", "birkeland-ida"),
            new User("Tore Haugland", "torehaug"),
            new User("Denis Vaska", "denis-vaska"),
            new User("Milena Corbea", "corbeamilena"),
            new User("Gyurkovics Letti", "gyur.letti "),
            new User("Oliviu Fugaru", "oliviufu"),
            new User("Semiha Erdem", "semi-91"),
            new User("Codin Ardelean", "codin.ardelean")
    );
}
