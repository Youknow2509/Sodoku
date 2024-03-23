package src.View;

public class Level { // TODO: lưu system.out từ file controller
    // Constructor
    public Level() {
        super();
    }
    // View
    // menu appliacation
    public void menuApplication() {
        System.out.println("Vui lòng chọn loại game: 9x9, 16x16.");
        System.out.println("1. 9x9");
        System.out.println("2. 16x16");
        System.out.print("Chọn: ");
    }
    // THong bao cho sai menuApplication
    public void inputMenuApplicationError() {
        System.out.println("Vui lòng chọn 1 hoặc 2.");
    }
    // chon typegame
    public void chooseTypeGame() {
        System.out.println("Vui lòng chọn mức độ:");
        System.out.println("1. Dễ");
        System.out.println("2. Trung bình");
        System.out.println("3. Khó");
        System.out.print("Chọn: ");
    }
    // THong bao cho sai typegame
    public void inputTypeGameError() {
        System.out.println("Vui lòng chọn 1, 2 hoặc 3.");
    }
    // input sai dinh dang
    public void inputNumberFormatError() {
        System.out.println("Vui long nhap so nguyen.");
    }

}
