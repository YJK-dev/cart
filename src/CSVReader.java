import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static Cart readProductsFromCSV(String fileName) throws  InvalidCSVFormatException, IOException {
        if (!fileName.endsWith(".csv")) {
            throw new InvalidCSVFormatException("Invalid file format. Expected a .csv file.");
        }

        Cart cartCsv = new Cart();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            // 첫 줄 (Header) 건너뛰기
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                // id, name, price, quantity
                if (values.length != 4) {
                    throw new InvalidCSVFormatException("Invalid CSV format in line: " + line);
                }

                String name = values[1];
                double price = Double.parseDouble(values[2]);
                int quantity = Integer.parseInt(values[3]);
                Product product = new Product(values[0], name, price);

                cartCsv.addProduct(product, quantity);
            }
        }
        return cartCsv;
    }
}
