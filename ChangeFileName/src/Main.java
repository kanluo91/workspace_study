//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String dirPath = "/Volumes/KK/ios逆向/xmg007-小码哥-Swift编程从入门到精通-MJ大神精选";
        String tar1 = "【一手it资源：dbbp.net.com】";
        String tar2 = "【一手资源 dbbp.net.com】";
        FileUtils.loopTravelDir(dirPath,tar1,tar2);
    }
}