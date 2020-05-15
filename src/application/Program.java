package application;

import model.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String args[]) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();
        System.out.print("Informe o caminho do arquivo para ser sumarizado: ");
        String pathFile = sc.next(); // /Users/lhserafim/Desktop/source.csv

        // Criar subdiretório
        System.out.println("");

        // Recuperar o path - sem o nome do arquivo
        File path = new File(pathFile);
        System.out.println("getName(): " + path.getName());
        System.out.println("getParent(): " + path.getParent());
        System.out.println("getAbsolutePath(): " + path.getAbsolutePath());

        boolean status = new File(path.getParent() + "/out").mkdir();
        if (status) {
            System.out.print("Subdiretório criado");
        }
        else {
            System.out.println("Não foi possível criar um subdiretório");
        }

        // Ler o arquivo
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))){
            String lines = br.readLine(); // lendo as linhas do arquivo
            while (lines != null) {
                System.out.println(lines);
                String[] ls = lines.split(",");
                String name = ls[0];
                double price = Double.parseDouble(ls[1]);
                int quantity = Integer.parseInt(ls[2]);
                list.add(new Product(name, price, quantity));
                lines = br.readLine();
            }
            // Escrever no arquivo
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/lhserafim/Desktop/out/summary.csv"))) {
                for (Product item : list) {
                    bw.write(item.getName() + "," + String.format("%.2f", item.total()));
                    bw.newLine();
                }
            }
            catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Listar o diretório
        File path2 = new File(path.getParent());
        File[] ls = path2.listFiles();
        System.out.println("ls:");
        for (File folder : ls) {
            System.out.println(folder);
        }
        sc.close();
    }
}
