package practice23_24;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

import com.opencsv.*;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.exceptions.CsvValidationException;

public class main {
    public static void main(String[] args) throws IOException, CsvValidationException {

        float income = 0;
        int i = 0;
        HashMap<String, Float> table = new HashMap<>();
        float expenses = 0;
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream("C:\\Users\\semey\\IdeaProjects\\java2\\src\\main\\java\\practice23_24\\csv\\movementList.csv"), "utf-8"));
        String[] nextline;
        while((nextline = reader.readNext()) != null){
            if(nextline != null){
                if(i != 0) {
                    String[] arr;
                    if((nextline[5].split("     ")[0].split("   ").length) >= 2) {
                        arr = nextline[5].split("     ")[0].split("   ")[1].split(" ");
                        if(!table.containsKey(arr[arr.length - 1])){
                            table.put(arr[arr.length - 1], Float.parseFloat(nextline[nextline.length - 1].replace(",",".")));
                        }
                        else if(table.containsKey(arr[arr.length - 1])){
                            table.put(arr[arr.length - 1], table.get(arr[arr.length - 1]) + Float.parseFloat(nextline[nextline.length - 1].replace(",",".")));
                        }
                    }

                    expenses += Float.parseFloat(nextline[nextline.length - 1].replace(",","."));
                    income += Float.parseFloat(nextline[nextline.length - 2].replace(",","."));
                }
                i++;
            }
        }
        System.out.println("Суммы расходов по организациям:");
        for(String k: table.keySet()) {
            System.out.println(k + " " + table.get(k));
        }
        System.out.println("\nСумма расходов: " + expenses);
        System.out.println("Сумма доходов: " + income);
    }
}
