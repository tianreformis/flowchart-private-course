import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Character implements Serializable {
    private static final long serialVersionUID = 1L; // For serialization
    private String name;
    private int level;
    private int experiencePoints;
    private int hp;
    private int mp;
    private int attack;
    private int defense;

    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.experiencePoints = 0;
        this.hp = 5;
        this.mp = 3;
        this.attack = 3;
        this.defense = 2;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void strengthTraining() {
        experiencePoints += 3;
        attack += 1;
        levelUp();
    }

    public void durabilityTraining() {
        experiencePoints += 3;
        defense += 1;
        levelUp();
    }

    private void levelUp() {
        int requiredExperience = level * 10;
        while (experiencePoints >= requiredExperience) {
            experiencePoints -= requiredExperience;
            level++;
            hp += 5;
            mp += 3;
            requiredExperience = level * 10;
        }
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Experience Points: " + experiencePoints);
        System.out.println("HP: " + hp);
        System.out.println("MP: " + mp);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
    }
}

public class GameSaved {
    private static ArrayList<Character> characters = new ArrayList<>();
    private static final String SAVE_FILE = "characters.dat";

    public static void main(String[] args) {
        loadCharacters(); // Load characters from file at the start
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Create Character");
            System.out.println("2. Train Character");
            System.out.println("3. Display Character Info");
            System.out.println("4. Save and Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter character name: ");
                    String name = scanner.nextLine();
                    characters.add(new Character(name));
                    System.out.println("Character created!");
                    break;
                case 2:
                    System.out.print("Enter character index to train (0 to " + (characters.size() - 1) + "): ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < characters.size()) {
                        System.out.println("1. Strength Training");
                        System.out.println("2. Durability Training");
                        System.out.print("Choose training type: ");
                        int trainingChoice = scanner.nextInt();
                        if (trainingChoice == 1) {
                            characters.get(index).strengthTraining();
                        } else if (trainingChoice == 2) {
                            characters.get(index).durabilityTraining();
                        }
                        System.out.println("Training completed!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 3:
                    System.out.print("Enter character index to display (0 to " + (characters.size() - 1) + "): ");
                    int displayIndex = scanner.nextInt();
                    if (displayIndex >= 0 && displayIndex < characters.size()) {
                        characters.get(displayIndex).displayInfo();
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 4:
                    saveCharacters(); // Save characters to file before exiting
                    System.out.println("Characters saved. Exiting the game.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void saveCharacters() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            oos.writeObject(characters);
            System.out.println("Characters saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving characters: " + e.getMessage());
        }
    }

    private static void loadCharacters() {
        File saveFile = new File(SAVE_FILE);
        if (saveFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
                characters = (ArrayList<Character>) ois.readObject();
                System.out.println("Characters loaded successfully.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading characters: " + e.getMessage());
            }
        }
    }
}