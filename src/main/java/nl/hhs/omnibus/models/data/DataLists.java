package nl.hhs.omnibus.models.data;

import jdk.jfr.internal.consumer.RecordingInput;
import jdk.jfr.internal.tool.Main;
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


//    // Fans
//    private final Fan oscar;
//
//
//    // Heroes
//    private final Hero batman;
//
//    // Villains
//    private final Villain theJoker;
//
//
//    // Gadget Base
//    private final Base
//    // Gadget Vehicle
//    // Gadget Weapon
//
//
//

    public DataLists() {

        /** Create list of Fans
         * */
        Fan oscarWellner = new Fan("Oscar Wellner");
        Fan eleonoraAvaleva = new Fan("Eleonora Avaleva");
        Fan jordyHuizer = new Fan("Jordy Huizer");
        Fan milevaMaric = new Fan("Mileva Maric");
        Fan maryCurieary = new Fan("Mary Curie");
        Fan rogerPenrose = new Fan("Roger Penrose");
        Fan jamesGosling = new Fan("James Gosling");
        Fan joseSaramago = new Fan("Jose Saramago");
        Fan titosPullo = new Fan("Titos Pullo");
        Fan guidoVanRossum = new Fan("Guido van Rossum");
        Fan dennisRitchie = new Fan("Dennis Ritchie");
        Fan adaLovelace = new Fan("Ada Lovelace");
        Fan albertCamus = new Fan("Albert Camus");
        Fan aldusHuxley = new Fan("Aldus Huxley");

       this.fans = (ArrayList<Fan>)Arrays.asList(
                titosPullo,oscarWellner,eleonoraAvaleva,jordyHuizer,milevaMaric,maryCurieary,rogerPenrose,jamesGosling,
                joseSaramago,guidoVanRossum,dennisRitchie,adaLovelace,albertCamus,aldusHuxley);



        /** Create list of Heroes
         * */
        Hero batman = new Hero("Batman", "Gotham City", 50,
                "Bruce Wayne", "The bat is here!!");
        Hero catwoman = new Hero("Catwoman", "Gotham City", 37,
                "Selina Kyle", "I like weapons that only the skilled can control… Guns are for jerks and cowards.");
        Hero blackWidow = new Hero("Black Widow", "Norway", 35,
                "Natalia Alianovna Romanova", "I’m sorry, did I step on your moment?");
        Hero wolverine = new Hero("Wolverine", "Alberta", 25,
                "James Howlett", "Meet my claws!");
        Hero ironMan = new Hero("Iron man", "Long Island", 26,
                "Tony Stark", "The Truth is… I am Iron Man.");
        Hero thor = new Hero("Thor", "Asgardian", 26,
                "Thor Borson", "You have no idea what you are dealing with.");
        Hero hulk = new Hero("Hulk", "Sakaaran", 50,
                "Robert Bruce Banner", "Hulk will break metal man open like a tin can. " +
                "Metal man thinks he is stronger than Hulk. Metalman wrong");
        Hero spidarman = new Hero("Spiderman", "New York", 14,
                "Peter Parker", "With great power, comes great responsibility");

        this.heroes = (ArrayList<Hero>) Arrays.asList(batman,catwoman,blackWidow,wolverine,ironMan,thor,hulk,spidarman);

        /** Create list of Villains
         * */
        Villain joker = new Villain("Joker", "Gotham City", 49,
                "Selling Smylex", "If you're good at something, never do it for free");
        Villain mrFreeze = new Villain("Mr. Freeze", "Gotham City", 19,
                "destroy everything Batman loves");
        Villain lokiLaufeyson = new Villain("Loki Laufeyson", "Asgardian", 27,
                "take over the planet");
        Villain theAbomination = new Villain("The Abomination", "Harlem", 50,
                "Kill the Hulk! Gain more power in order to be able to become the most powerful warrior on Earth by killing everyone who stands in his way.");
        Villain vipor = new Villain("Vipor", "location", 35, "");
        Villain ladyDeathstrike = new Villain("Lady Deathstrike", "location", 30,
                "");
        Villain venum = new Villain("Venum", "New York", 55,
                "");
        Villain greenGoblin = new Villain("Green Goblin", "New York", 25,
                "To gain full control over Spidermen's mind.");

        this.villains = (ArrayList<Villain>) Arrays.asList(joker,mrFreeze,lokiLaufeyson,theAbomination,vipor,
                ladyDeathstrike,venum,greenGoblin);



        /** Create a list with bases
         * */
        Base batcave = new Base("Batcave", "Batman's cave", batman, "Gotham City");
        Base underwaterBase =  new Base("Underwater base", "A well designed underwater base", thor, "Under the see");
        Base jokersFunHouse = new Base("Joker's Funhouse", "Is located at the center of Amusement Mile in Otisburg district", joker, "Gotham City");
        Base lokiPalace = new Base("Loki Palace", "It is an underground palave hideout located in the Void.", lokiLaufeyson, "Unknown");
        Base bannerB773hideout = new Base("Banner Hideout B-733", "An underground grotto located beneath a " + "lake in the Chihuahuan Desert", hulk, "New Mexico");

        this.bases = (ArrayList<Base>)Arrays.asList(batcave,underwaterBase,jokersFunHouse,lokiPalace,bannerB773hideout);

        /** Create list of Vehicles
         * */

        Vehicle batmobile = new Vehicle("Batmobile", "Batman's supercar",heroes.get(0), 380, 1);
        Vehicle blackWidowMotor = new Vehicle("Black Widow's Motorcycle", "Fast Harley-Davidson bike", heroes.get(2), 350, 2);
        Vehicle dodgeViper = new Vehicle("Dodge Viper", "Fast car", villains.get(4), 480, 2);
        Vehicle zephyrOne = new Vehicle("Zephyr One", "Is a mobile airborne command plane", heroes.get(6), 1875, 30);
        Vehicle f22Raptor = new Vehicle("F-22 Raptor", "A single-seat, twin-engine fifth-generation supermaneuverable fighter aircraft that uses stealth technology.", heroes.get(4), 1845, 1);

         this.vehicles = (ArrayList<Vehicle>)Arrays.asList(batmobile,blackWidowMotor,dodgeViper,zephyrOne,f22Raptor);

        /** Create list of Weapons
         * */

                // Batman
        Weapon rocketPropelledGrenade = new Weapon("Rocket propelled grenade", "Click, BOOM!", batman, 75);
        Weapon batarang = new Weapon("Batarang", "Batman's boomerang", batman, 35);
                //Catwoman
        Weapon whip = new Weapon("Whip", "Uses her whip to attack in combat, and to trip up enemies. ", catwoman, 0);
        Weapon caltrop = new Weapon("Caltrop", "A sharp, metal jacks that could be dropped and used as a trap. Enemies trip and fall down when they step on them.", catwoman , 0);
                // Black Widow
        Weapon teaserDisks = new Weapon("Teaser Disks", "Teaser disks are an extension of her widow bites, and these disks can electrocute a person without needing to make contact with them.", blackWidow, 0);
        Weapon dualBatons= new Weapon("Dual Batons", "Similar to her widow bites, Natasha's dual batons are electrically charged, where she is able to electrocute the Ultron bots, taking them offline after only a few precise blows.", blackWidow, 0);
                //Wolverine
                new Weapon("Weapon X", "", wolverine, 0);
                new Weapon("", "", wolverine, 0);
                // Iron Man
                new Weapon("", "", ironMan, 0);
                new Weapon("", "", ironMan, 0);
                // Thor
                new Weapon("", "", thor, 0);
                new Weapon("", "", thor, 0);
                //Hulk
                new Weapon("", "", hulk, 0);
                new Weapon("", "", hulk, 0);
                //Spidar man
                new Weapon("", "", spidarman, 0);
                new Weapon("", "", spidarman, 0);
                //Joker
                new Weapon("", "", joker, 0);
                new Weapon("", "", joker, 0);
                //Mr. Freeze
                new Weapon("", "", mrFreeze, 0);
                new Weapon("", "", mrFreeze, 0);
                //Loki Laufeyson
                new Weapon("", "", lokiLaufeyson, 0);
                new Weapon("", "", lokiLaufeyson, 0);
                // The Abomination
                new Weapon("", "", theAbomination, 0);
                new Weapon("", "", theAbomination, 0);
                // Vipor
                new Weapon("", "", vipor, 0);
                new Weapon("", "", vipor, 0);
                // Lady Deathstrike
                new Weapon("", "", ladyDeathstrike, 0);
                new Weapon("", "", ladyDeathstrike, 0);
                // Venum
                new Weapon("", "", venum, 0);
                new Weapon("", "", venum, 0);
                //Green Goblin
                new Weapon("", "", greenGoblin, 0);
                new Weapon("", "", greenGoblin, 0);
        this.weapons = (ArrayList<Weapon>)Arrays.asList(rocketPropelledGrenade, batarang,whip,caltrop,teaserDisks,dualBatons);

    }
    /** GETTERS AND SETTERS **/
}