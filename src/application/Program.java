package application;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String args[]) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o caminho do arquivo para ser sumarizado: ");
        String pathFile = sc.next(); // /Users/lhserafim/Desktop/source.csv

        // Ler o arquivo
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))){
            String lines = br.readLine(); // lendo as linhas do arquivo
            //String<> list = new ArrayList<>();
            //System.out.println(lines.split(","));
            while (lines != null) {
                System.out.println(lines);
                lines = br.readLine();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

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

        // Criar o arquivo
        //try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathFile))) {        }

        // Listar o diretório

        sc.close();
    }
}
