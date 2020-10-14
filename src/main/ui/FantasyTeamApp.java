package ui;

import model.FantasyTeam;
import model.Player;
import model.ListOfFantasyTeam;

import java.util.Scanner;

// Fantasy Team application
public class FantasyTeamApp {
    private ListOfFantasyTeam fantasyTeamList = new ListOfFantasyTeam();
    private FantasyTeam masterListOfPlayers = new FantasyTeam("Master");
    private Scanner input;

    //EFFECTS: runs the fantasy application
    public FantasyTeamApp() {
        runFantasy();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runFantasy() {
        boolean keepGoing = true;
        String command;

        input = new Scanner(System.in);

        while (keepGoing) {
            displayMenu();
            command = input.nextLine();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGood luck for your basketball fantasy season!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("t")) {
            teamMenu();
        } else if (command.equals("p")) {
            playerMenu();
        } else {
            System.out.println("The option you selected is not valid, try again...");
        }
    }

    // EFFECTS: starts display menu and gives user options
    private void displayMenu() {
        System.out.println("\nDo you want to:");
        System.out.println("\tCreate or view a team? Enter t");
        System.out.println("\tCreate or view a player? Enter p");
        System.out.println("\tQuit? Enter q");
    }

    // EFFECTS: takes a team name and shows its player and it's value, if not found creates team with given name
    private void teamMenu() {
        System.out.print("Enter the name of a team already created or enter a new name: ");
        String teamName;
        teamName = input.nextLine();
        if (fantasyTeamList.containsTeam(teamName)) {
            fantasyTeamList.getTeam(teamName).printFantasyTeam();
            System.out.println("Team value: " + fantasyTeamList.getTeam(teamName).getAverageValueOfTeam());
        } else {
            FantasyTeam newFantasyTeam = new FantasyTeam(teamName);
            fantasyTeamList.addTeam(newFantasyTeam);
            System.out.println(teamName + " has been added");
        }
    }

    // EFFECTS: creates player and adds to a fantasy team
    private void playerMenu() {
        System.out.println("Enter the name of a player already created or enter a new name:");
        String playerName;
        playerName = input.nextLine();
        if (masterListOfPlayers.containsPlayer(playerName)) {
            System.out.println(playerName + " has value of " + (masterListOfPlayers.getPlayer(playerName)).getValue());
        } else {
            Player p = new Player(playerName);
            System.out.println("Player created with name " + p.getName());
            enterStats1(p);
            enterStats2(p);
            System.out.println("Which team would you like to add this player to?");
            String teamName;
            teamName = input.nextLine();
            if (fantasyTeamList.containsTeam(teamName)) {
                fantasyTeamList.getTeam(teamName).addPlayerToTeam(p);
            } else {
                FantasyTeam fantasyTeam = new FantasyTeam(teamName);
                fantasyTeamList.addTeam(fantasyTeam);
                fantasyTeamList.getTeam(teamName).addPlayerToTeam(p);
            }
            masterListOfPlayers.addPlayerToTeam(p);
        }
    }

    // MODIFIES: this
    // EFFECTS: entered numbers are added to player stats
    private void enterStats1(Player p) {
        System.out.println("Enter points per game of given player");
        String points = input.nextLine();
        double pts = Double.parseDouble(points);
        p.setPoints(pts);
        System.out.println("Enter rebounds per game of given player");
        String rebounds = input.nextLine();
        double rebs = Double.parseDouble(rebounds);
        p.setRebounds(rebs);
        System.out.println("Enter assists per game of given player");
        String assists = input.nextLine();
        double ast = Double.parseDouble(assists);
        p.setAssists(ast);
        p.setValue();
    }

    public void enterStats2(Player p) {
        System.out.println("Enter steals per game of given player");
        String steals = input.nextLine();
        double stl = Double.parseDouble(steals);
        p.setSteals(stl);
        System.out.println("Enter blocks per game of given player");
        String blocks = input.nextLine();
        double blk = Double.parseDouble(blocks);
        p.setBlocks(blk);
        System.out.println("Enter three pointers made per game of given player");
        String threes = input.nextLine();
        double thr = Double.parseDouble(threes);
        p.setThrees(thr);
        System.out.println("Enter turnovers per game of given player");
        String turnovers = input.nextLine();
        double tos = Double.parseDouble(turnovers);
        p.setTurnovers(tos);
        p.setValue();
    }

}
