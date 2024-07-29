//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String dirPath = "/Volumes/KK/android逆向/wyy0055 - IOS逆向与安全";
        String tar1 = "【更多资源： dbbp.net】";
        String tar2 = "【找it教程dbbp.net】【微信648765304】";
        FileUtils.loopTravelDir(dirPath,tar1,tar2);
    }
}