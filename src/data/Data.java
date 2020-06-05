package data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Data {

    int dia, mes, ano = 0;
    Date data = new Date();
    SimpleDateFormat formatarDia = new SimpleDateFormat("d");
    SimpleDateFormat formatarMes = new SimpleDateFormat("M");
    SimpleDateFormat formatarAno = new SimpleDateFormat("y");
    int diaAtual = Integer.parseInt(formatarDia.format(data));
    int mesAtual = Integer.parseInt(formatarMes.format(data));
    int anoAtual = Integer.parseInt(formatarAno.format(data));

    public Data(Integer diaP, Integer mesP, Integer anoP) {

        if (mesP < 1 || mesP > 12) {

            System.out.println("Informe um mes valido.");

        }

        if (diaP < 1 && anoP > 31) {

            System.out.println("Tem que ser de 1 a 31!!!");

        }

        if (anoP > anoAtual) {

            System.out.println("Ano invalido");

        }
        try {
            if (verificaData(diaP, mesP, anoP)) {

                this.dia = diaP;

                this.mes = mesP;

                this.ano = anoP;
                calculoIdade(dia, mes, ano);

            } else {
                System.out.println("data invalida !");
            }
        } catch (Exception e) {
            System.out.println("data incorreta !");
        }
        ;

    }

    public boolean verificaData(Integer diaV, Integer mesV, Integer anoV) {

        boolean dataCorreta = false;

        if (mesV == 4 || mesV == 6 || mesV == 9 || mesV == 11) {

            if (diaV <= 30) {

                dataCorreta = true;

            } else {

                dataCorreta = false;
            }

        }

        if (mesV == 1 || mesV == 3 || mesV == 5 || mesV == 7 || mesV == 8 || mesV == 10 || mesV == 12) {

            if (diaV <= 31) {

                dataCorreta = true;

            } else {

                dataCorreta = false;

            }

        }

        if (mesV == 2) {

            if (anoV % 4 == 0) {

                if (dia <= 29) {

                    dataCorreta = true;

                } else {

                    dataCorreta = false;
                }

            } else {

                if (dia <= 28) {
                    dataCorreta = true;

                } else {
                    dataCorreta = false;
                }
            }
        }
        if (dataCorreta) {
            return true;
        } else {
            return false;

        }

    }

    public void calculoIdade(int diaV, int mesV, int anoV) {

        int Idade = anoAtual - anoV;
        while (true) {
            if (mesV >= mesAtual) {
                if(mesV > mesAtual){
                    Idade -= 1;
                    break;
                }
                
                if (diaV > diaAtual) {
                    Idade -= 1;
                    break;
                }
                
            }
            break;
        }
        System.out.println("idade : " + Idade + " anos");

    }

    public static void main(String[] args) {
        int diaDig = 0, mesDig = 0, anoDig = 0;
         System.out.println("Digite uma data: EX: 12/10/2012");
         Scanner l = new Scanner(System.in);
         String dataDigitada = l.nextLine();
         String dataFormatada = dataDigitada.replace("/", "").replace(" ", "").replace("-", "");
        
      

         if (dataFormatada.length() == 8) {
         try {
         diaDig = Integer.parseInt(dataFormatada.substring(0, 2));
         mesDig = Integer.parseInt(dataFormatada.substring(2, 4));
         anoDig = Integer.parseInt(dataFormatada.substring(4, 8));
         Data objData = new Data(diaDig, mesDig, anoDig);
                
                
         } catch (NumberFormatException e) {
         System.out.println("Por favor, digite apenas caracteres validos");
         } catch (Exception e) {
         System.out.println("Por favor, digite apenas caracteres validos");
         }

         } else {
         System.out.println("Por favor digite uma data valida...");
         }
         
       
    }

}
