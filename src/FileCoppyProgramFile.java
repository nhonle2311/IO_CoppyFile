import java.io.*;

public class FileCoppyProgramFile {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("nhâp tên file nguôn: ");
            String sourceFileName = bufferedReader.readLine();
            File sourceFile = new File(sourceFileName);
            if (!sourceFile.exists()){
                System.out.println("không tồn tại");
            }
            System.out.println("nhập tệp đích: ");
            String tagetFileName = bufferedReader.readLine();
            File tagetFile = new File(tagetFileName);
            if (tagetFile.exists()){
                System.out.println("tệp đã tồn tại");
                String responce = bufferedReader.readLine();
                if (!responce.equalsIgnoreCase("")){
                    System.out.println("sao chep bị hủy bỏ: ");
                }
            }
            try(BufferedReader fileReader = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(tagetFile))) {
                int character;
                int charCount = 0;
                while ((character = fileReader.read()) != -1){
                    fileWriter.write(character);
                    charCount++;
                }
                System.out.println("sao chép thành công" + charCount);
            } catch (IOException e) {
                System.out.println("lỗi sao chép tệp " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("lỗi đọc dữ liệu từ bàn phim" + e.getMessage());
        }
    }
}
