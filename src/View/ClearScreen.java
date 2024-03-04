package src.View;

public class ClearScreen {

    public ClearScreen(){};
    public void run() {
        // Kiem tra he dieu hanh cua nguoi xu dung
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.out.print("\f");
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            System.out.print("\033[H\033[2J");
        }
    }
}
