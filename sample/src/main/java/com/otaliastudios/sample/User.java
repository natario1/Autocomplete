package com.otaliastudios.sample;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class User {

    private String fullname;
    private String username;
    private boolean female;

    public User(@NonNull String fullname, @NonNull String username) {
        this.fullname = fullname;
        this.username = username;
    }

    public User(@NonNull String fullname, @NonNull String username, boolean female) {
        this.fullname = fullname;
        this.username = username;
        this.female = female;
    }

    @NonNull
    public String getFullname() {
        return fullname;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public boolean isFemale() {
        return female;
    }

    // Thanks uinames.com
    public static List<User> USERS = Arrays.asList(
            new User("Lori Rice", "lori__rice", true),
            new User("Karen Sandoval", "karen93", true),
            new User("Andrea Wagner", "andrea_86"),
            new User("Jerry Sanchez", "jerry-85"),
            new User("Elizabeth Carroll", "elizabeth-94", true),
            new User("Ronald Tran", "ronald_tran"),
            new User("Crystal Castillo", "crystal.castillo", true),
            new User("Sean King", "sean"),
            new User("Paul Aguilar", "paul.aguilar"),
            new User("Benjamin Gonzalez", "ben-85"),
            new User("Ryan Curtis", "ryan-94"),
            new User("Jane Willis", "jane_willis", true),
            new User("Diane Price", "diane__price", true),
            new User("Marie Elliott", "marie95", true),
            new User("Peter Cole", "peter_83"),
            new User("Donald Green", "donald-35"),
            new User("Frank Oliver", "frank-oliver"),
            new User("Doris Walters", "doris", true),
            new User("Jack Lynch", "jack-lynch"),
            new User("Ruth Patel", "patel"),
            new User("Donald Obrien", "obrien.donald"),
            new User("Joyce Wells", "jwells"),
            new User("Austin Keller", "keller-94"),
            new User("Jean Watkins", "jw", true),
            new User("Julio Cesar Paredes", "julio.cesar"),
            new User("Fabian Mercedesz", "fabian"),
            new User("Roma Kania", "roma.kania", true),
            new User("Luna Vidal", "luna-75", true),
            new User("Daisy Roberts", "roberts-93", true),
            new User("Matthew Maxton", "matthew_maxton"),
            new User("Claudio Guerra", "guerra.claudio"),
            new User("Floare Carafoli", "floare84", true),
            new User("Esra Yilmaz", "esra_83", true),
            new User("Casanda Goian", "casanda-1935", true),
            new User("Kyle Lawson", "kyle-law"),
            new User("Mathijs de Boer", "mdboer"),
            new User("Mitchell Sarah", "mitchell-sarah"),
            new User("Carolina Rotaru", "rotaru", true),
            new User("Joe Fernandez", "joe.fernandez"),
            new User("Christian Colombo", "ccolombo"),
            new User("Venera Steflea", "venera-91", true),
            new User("Helge Olsen", "holsen", true),
            new User("Fien Smet", "fien.smet"),
            new User("Hugo Aviles", "aviles"),
            new User("Elizabeth Montoya", "elizabeth.montoya", true),
            new User("Mihnea Gliga", "mihnea-75", true),
            new User("Gary Cook", "cook-96"),
            new User("Seppe Smet", "seppe_smet"),
            new User("Diane Lane", "diane.lane", true),
            new User("Sophia Ackroyd", "sophia", true),
            new User("Octavia Sirma", "octavia_sirma", true),
            new User("Ciprian Tutoveanu", "ciprian"),
            new User("Ida Birkeland", "birkeland-ida", true),
            new User("Tore Haugland", "torehaug"),
            new User("Denis Vaska", "denis-vaska"),
            new User("Milena Corbea", "corbeamilena", true),
            new User("Gyurkovics Letti", "gyur.letti "),
            new User("Oliviu Fugaru", "oliviufu"),
            new User("Semiha Erdem", "semi-91"),
            new User("Codin Ardelean", "codin.ardelean")
    );
}
