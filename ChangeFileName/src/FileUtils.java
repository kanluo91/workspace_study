import java.io.File;

public class FileUtils {

    public static void loopTravelDir(String dirPath,String targetStr1,String targetStr2){

        if(dirPath == null || dirPath.isEmpty()){
            return;
        }
        File file = new File(dirPath);
        if(!file.exists()){
            return;
        }
        if(file.isDirectory()){ // 目录的情况
            String[] fileNamelist = file.list();
            for (String fileName : fileNamelist) {
                String filePath = dirPath + File.separator + fileName;

                loopTravelDir(filePath,targetStr1,targetStr2);
            }
        }else{// 非目录的情况
            System.out.println("[文件]" + dirPath);
          changeFileName(dirPath,targetStr1,targetStr2);
        }
    }

    public static void changeFileName(String filePath,String targetStr1,String targetStr2) {
        System.out.println("[执行]----[1]");
        if (filePath == null || filePath.isEmpty()) {
            return;
        }

        boolean isFilter1Exist = targetStr1 != null && !targetStr1.isEmpty() && filePath.contains(targetStr1);
        boolean isFilter2Exist = targetStr2 != null && !targetStr2.isEmpty() && filePath.contains(targetStr2);

        System.out.println("[执行]----[2]" + "[filePath]="+filePath + "\n" + "[filter2] = " + targetStr2);

        System.out.println("[执行]----[3] " + (isFilter1Exist?"yes":"no") + " " + (isFilter2Exist?"yes":"no"));

        String tartgetName = filePath;
        if (isFilter1Exist) {
            System.out.println("[执行]----[4]" + tartgetName);
            System.out.println("[过滤1][原文件名称]" + tartgetName + "[过滤]" + targetStr1);
            tartgetName = tartgetName.replace(targetStr1, "");
        }

        if (isFilter2Exist) {
            System.out.println("[执行]----[5]" + tartgetName);
            System.out.println("[过滤2][原文件名称]" + tartgetName + "[过滤]" + targetStr2);
            tartgetName = tartgetName.replace(targetStr2, "");
        }

        if (!filePath.equals(tartgetName)) {
            File oldfile = new File(filePath);
            File newfile = new File(tartgetName);
            boolean isSucc = oldfile.renameTo(newfile);
            System.out.println("----------[改名]" + filePath + (isSucc ? "成功" : "失败"));
        }
    }
}
