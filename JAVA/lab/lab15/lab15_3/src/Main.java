import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileService<Company> companyFileService = new FileService<>();

        List<Company> writeCompanies = new ArrayList<>();
        Company shoppe = new Company("Shoppe", "admin@shoppe.com", "0123456789", "5 Science Park Drive, Shopee Building", "118265", "Singapore");
        writeCompanies.add(shoppe);
        Company lazada = new Company("Lazada", "admin@lazada.com", "0123567891", "8 Science Park Drive, Lazada Building", "118265", "Singapore");
        writeCompanies.add(lazada);
        // ghi dữ liệu vào file
        companyFileService.writeFile("company.dat", writeCompanies);


        // đọc dữ liệu từ file
        List<Company> readCompanies = companyFileService.readFile("company.dat");
        System.out.println("List company in file: ");
        companyFileService.printList(readCompanies);
    }
}