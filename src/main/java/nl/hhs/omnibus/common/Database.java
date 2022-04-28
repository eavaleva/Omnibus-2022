package nl.hhs.omnibus.common;

import nl.hhs.omnibus.models.Nameable;
import nl.hhs.omnibus.models.gadgets.Gadget;
import nl.hhs.omnibus.models.navigation.ListableMenuItem;
import nl.hhs.omnibus.models.navigation.Menu;
import nl.hhs.omnibus.models.navigation.NavigableMenuItem;
import nl.hhs.omnibus.models.persons.Fan;
import nl.hhs.omnibus.models.persons.Hero;
import nl.hhs.omnibus.models.persons.Villain;
import nl.hhs.omnibus.models.teams.HeroTeam;
import nl.hhs.omnibus.models.teams.VillainTeam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Database {
    private final List<Gadget> gadgets;
    private final List<Fan> fans;
    private final List<Hero> heroes;
    private final List<HeroTeam> heroicTeams;
    private final List<Villain> villains;
    private final List<VillainTeam> villainTeams;

    private final Menu menuMain;

    public Database() {
        this.fans = new ArrayList<>();
        this.heroes = new ArrayList<>();
        this.heroicTeams = new ArrayList<>();
        this.villains = new ArrayList<>();
        this.villainTeams = new ArrayList<>();
        this.gadgets = new ArrayList<>();

        // Combine the Hero- and Villain Teams into one list
        // for listing the various teams under MenuItem for Teams
        List<Nameable> teams = Stream.of(this.heroicTeams, this.villainTeams)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

        // Combine Heroes, Villains, Fans, and Teams lists into one list
        // for searching for a person or team.
        List<Nameable> peopleAndTeams = Stream.of(this.heroes, this.villains, this.fans, teams)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

        // Menus
        this.menuMain = new Menu("Main Menu");
        Menu menuPeople = new Menu("People Menu");
        Menu menuGadgets = new Menu("Gadgets Menu");
        Menu menuFights = new Menu("Fights Menu");

        // Common MenuItems
        NavigableMenuItem miExit = new NavigableMenuItem("Exit");

        // Main MenuItems
        NavigableMenuItem miPeopleAndTeams = new NavigableMenuItem("Menu People & Teams", menuPeople);
        NavigableMenuItem miGadgets = new NavigableMenuItem("Menu Gadgets", menuGadgets);
        NavigableMenuItem miFights = new NavigableMenuItem("Menu Fights", menuFights);

        // People and Teams MenuItems
        ListableMenuItem lmiHeroes = new ListableMenuItem("List Heroes", "Heroes:", this.heroes);
        ListableMenuItem lmiVillains = new ListableMenuItem("List Villains", "Villains:", this.villains);
        ListableMenuItem lmiTeams = new ListableMenuItem("List Teams", "Teams:", teams);
        ListableMenuItem lmiFans = new ListableMenuItem("List Fans", "Fans:", this.fans);
        ListableMenuItem lmiSearchPeople = new ListableMenuItem(Constants.SEARCH_LABEL, "People & Teams:", peopleAndTeams, true);

        // Gadget MenuItems
        ListableMenuItem lmiGadgets = new ListableMenuItem("List Gadgets", "Gadgets:", this.gadgets);
        ListableMenuItem lmiSearchGadgets = lmiGadgets.makeSelectable(menuGadgets);

        // Tying all the Menu's and MenuItems together
        this.menuMain.addAllOptions(miExit, miPeopleAndTeams, miGadgets, miFights);
        menuPeople.addAllOptions(
            miExit.withPreviousMenu(this.menuMain),
            lmiHeroes.withPreviousMenu(menuPeople),
            lmiVillains.withPreviousMenu(menuPeople),
            lmiTeams.withPreviousMenu(menuPeople),
            lmiFans.withPreviousMenu(menuPeople),
            lmiSearchPeople.withPreviousMenu(menuPeople)
        );
        menuGadgets.addAllOptions(
            miExit.withPreviousMenu(this.menuMain),
            lmiGadgets.withPreviousMenu(menuGadgets),
            lmiSearchGadgets
        );
        menuFights.addAllOptions(miExit.withPreviousMenu(this.menuMain));
    }

    public Menu getMainMenu() {
        return this.menuMain;
    }
}
