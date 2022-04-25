package nl.hhs.omnibus.models.data;

import nl.hhs.omnibus.models.gadgets.Base;
import nl.hhs.omnibus.models.gadgets.Vehicle;
import nl.hhs.omnibus.models.gadgets.Weapon;
import nl.hhs.omnibus.models.persons.Fan;
import nl.hhs.omnibus.models.persons.Hero;
import nl.hhs.omnibus.models.persons.Villain;


import java.util.ArrayList;
import java.util.Arrays;

public class DataLists {

    private final ArrayList<Fan> fans;
    private final ArrayList<Hero> heroes;
    private final ArrayList<Villain> villains;
    private final ArrayList<Base> bases;
    private final ArrayList<Vehicle> vehicles;
    private final ArrayList<Weapon> weapons;

    public ArrayList<Hero> heroes() {
        return heroes;
    }

    public ArrayList<Villain> villains() {
        return villains;
    }

    public ArrayList<Fan> fans() {
        return fans;
    }

    public ArrayList<Weapon> weapons() {
        return weapons;
    }

    public ArrayList<Vehicle> vehicles() {
        return vehicles;
    }

    public ArrayList<Base> bases() {
        return bases;
    }


    public DataLists() {

        /** Create list of Fans
         * */
        fans = new ArrayList<>(Arrays.asList(
                new Fan("Oscar Wellner"),
                new Fan("Eleonora Avaleva"),
                new Fan("Jordy Huizer"),
                new Fan("Mileva Maric"),
                new Fan("Mary Curie"),
                new Fan("Roger Penrose"),
                new Fan("James Gosling"),
                new Fan("Jose Saramago"),
                new Fan("Linus Torvalds"),
                new Fan("Guido van Rossum"),
                new Fan("Dennis Ritchie"),
                new Fan("Ada Lovelace"),
                new Fan("Albert Camus"),
                new Fan("Aldus Huxley")
        ));

        /** Create list of Heroes
         * */
        heroes = new ArrayList<>(Arrays.asList(
                new Hero("Batman", "Gotham City", 50, "Bruce Wayne", "The bat is here!!"),
                new Hero("Catwoman", "Gotham City", 37, "Selina Kyle", "I like weapons that only the skilled can control… Guns are for jerks and cowards."),
                new Hero("Black Widow", "Norway", 35, "Natalia Alianovna Romanova", "I’m sorry, did I step on your moment?"),
                new Hero("Wolverine", "Alberta", 25, "James Howlett", "Meet my claws!"),
                new Hero("Iron man", "Long Island", 26, "Tony Stark", "The Truth is… I am Iron Man."),
                new Hero("Thor", "Asgardian", 26, "Thor Borson", "You have no idea what you are dealing with."),
                new Hero("Hulk", "Sakaaran", 50, "Robert Bruce Banner", "Hulk will break metal man open like a tin can. Metal man thinks he is stronger than Hulk. Metalman wrong"),
                new Hero("Spiderman", "New York", 14, "Peter Parker", "With great power, comes great responsibility")
        ));

        /** Create list of Villains
         * */
        villains = new ArrayList<>(Arrays.asList(
                new Villain("Joker", "Gotham City", 49, "Selling Smylex", "If you're good at something, never do it for free"),
                new Villain("Mr. Freeze", "Gotham City", 19, "destroy everything Batman loves"),
                new Villain("Loki Laufeyson", "Asgardian", 27, "take over the planet"),
                new Villain("The Abomination", "Harlem", 50, "Kill the Hulk! Gain more power in order to be able to become the most powerful warrior on Earth by killing everyone who stands in his way."),
                new Villain("Vipor", "location", 35, "evil plan"),
                new Villain("Lady Deathstrike", "location", 30, "evil plan"),
                new Villain("Venum", "New York", 55, "evil plan"),
                new Villain("Villain", "location", 25, "evelplan")

        ));


        bases = new ArrayList<>(Arrays.asList(
                new Base("Batcave", "Batman's cave", heroes.get(0), "Gotham City"),
                new Base("Underwater base", "A well designed underwater base", heroes.get(1), "Under the see"),
                new Base("Joker's Funhouse", "Is located at the center of Amusement Mile in Otisburg district", villains.get(0), "Gotham City"),
                new Base("Loki Palace", "It is an underground palave hideout located in the Void.", villains.get(2), "Unknown"),
                new Base("Banner Hideout B-733", "An underground grotto located beneath a lake in the Chihuahuan Desert", heroes.get(6), "New Mexico")
        ));

        /** Create list of Vehicles
         * */
        vehicles = new ArrayList<>(Arrays.asList(
                new Vehicle("Batmobile", "Batman's supercar",heroes.get(0), 380, 1),
                new Vehicle("Black Widow's Motorcycle", "Fast Harley-Davidson bike", heroes.get(2), 350, 2),
                new Vehicle("Dodge Viper", "Fast car", villains.get(4), 480, 2),
                new Vehicle("Zephyr One", "Is a mobile airborne command plane", heroes.get(6), 1875, 30),
                new Vehicle("F-22 Raptor", "A single-seat, twin-engine fifth-generation supermaneuverable fighter aircraft that uses stealth technology.", heroes.get(4), 1845, 1)
                ));

        /** Create list of Weapons
         * */
        weapons = new ArrayList<>(Arrays.asList(
                // Batman
                new Weapon("Rocket propelled grenade", "Click, BOOM!", heroes.get(0), 75),
                new Weapon("Batarang", "Batman's boomerang", heroes.get(0), 35),
                //Catwoman
                new Weapon("Whip", "Uses her whip to attack in combat, and to trip up enemies. ", heroes.get(1), 0),
                new Weapon("Caltrop", "A sharp, metal jacks that could be dropped and used as a trap. Enemies trip and fall down when they step on them.", heroes.get(1), 0),
                // Black Widow
                new Weapon("Taser Disks", "Teaser disks are an extension of her widow bites, and these disks can electrocute a person without needing to make contact with them.", heroes.get(2), 0),
                new Weapon("Dual Batons", "Similar to her widow bites, Natasha's dual batons are electrically charged, where she is able to electrocute the Ultron bots, taking them offline after only a few precise blows.", heroes.get(2), 0),
                //Wolverine
                new Weapon("Weapon X", "", heroes.get(3), 0),
                new Weapon("", "", heroes.get(3), 0),
                // Iron Man
                new Weapon("", "", heroes.get(4), 0),
                new Weapon("", "", heroes.get(4), 0),
                // Thor
                new Weapon("", "", heroes.get(5), 0),
                new Weapon("", "", heroes.get(5), 0),
                //Hulk
                new Weapon("", "", heroes.get(6), 0),
                new Weapon("", "", heroes.get(6), 0),
                //Spidar man
                new Weapon("", "", heroes.get(7), 0),
                new Weapon("", "", heroes.get(7), 0),
                //Joker
                new Weapon("", "", villains.get(0), 0),
                new Weapon("", "", villains.get(0), 0),
                //Mr. Freeze
                new Weapon("", "", villains.get(1), 0),
                new Weapon("", "", villains.get(1), 0),
                //Loki Laufeyson
                new Weapon("", "", villains.get(2), 0),
                new Weapon("", "", villains.get(2), 0),
                // The Abomination
                new Weapon("", "", villains.get(3), 0),
                new Weapon("", "", villains.get(3), 0),
                // Vipor
                new Weapon("", "", villains.get(4), 0),
                new Weapon("", "", villains.get(4), 0),
                // Lady Deathstrike
                new Weapon("", "", villains.get(5), 0),
                new Weapon("", "", villains.get(5), 0),
                // Venum
                new Weapon("", "", villains.get(6), 0),
                new Weapon("", "", villains.get(6), 0),
                // Villain to be determent
                new Weapon("", "", villains.get(7), 0),
                new Weapon("", "", villains.get(7), 0)
        ));

    }
}
