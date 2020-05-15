package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o caminho do arquivo para ser sumarizado: ");
        String pathFile = sc.next(); // /Users/lhserafim/Desktop/source.csv

        // Ler o arquivo
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))){
            String lines = br.readLine(); // lendo as linhas do arquivo
            while (lines != null) {
                System.out.println(lines);
                lines = br.readLine();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
