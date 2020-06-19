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
        while (true) {
            if (mesP < 1 || mesP > 12) {

                System.out.println("Informe um mes valido.\n");
                break;

            }

            if (diaP < 1 || diaP > 31) {

                System.out.println("Dia incorreto...Tem que ser de 1 a 31!!!\n");
                break;
            }

            if (anoP > anoAtual) {

                System.out.println("Ano invalido! \n");
                break;
            }
            if (anoP == anoAtual) {
                if (mesP > mesAtual) {
                    System.out.println("Data invalida! \n");
                    break;
                }
                if (mesP == mesAtual) {
                    if (diaP > diaAtual) {
                        System.out.println("Data invalida! \n");
                        break;
                    }
                }

            }
            try {
                if (verificaData(diaP, mesP, anoP)) {

                    this.dia = diaP;

                    this.mes = mesP;

                    this.ano = anoP;
                    calculoIdade(dia, mes, ano);

                } else {
                    System.out.println("Data invalida !\n");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Data incorreta !\n");
                break;
            }
            ;
            break;
        }
    }

    public boolean verificaData(Integer diaP, Integer mesP, Integer anoP) {

        boolean dataCorreta = false;

        if (mesP == 4 || mesP == 6 || mesP == 9 || mesP == 11) {

            if (diaP <= 30) {

                dataCorreta = true;

            } else {

                dataCorreta = false;
            }

        }

        if (mesP == 1 || mesP == 3 || mesP == 5 || mesP == 7 || mesP == 8 || mesP == 10 || mesP == 12) {

            if (diaP <= 31) {

                dataCorreta = true;

            } else {

                dataCorreta = false;

            }

        }

        if (mesP == 2) {

            if (anoP % 4 == 0 && anoP % 100 != 0 || anoP % 400 == 0) { // regra do ano bissexto

                if (diaP <= 29) {

                    dataCorreta = true;

                } else {

                    dataCorreta = false;
                }

            } else {

                if (diaP <= 28) {
                    dataCorreta = true;

                } else {
                    dataCorreta = false;
                }
            }
        }
        if (dataCorreta == true) {
            return true;
        } else {
            return false;

        }

    }

    public void calculoIdade(int diaP, int mesP, int anoP) {

        int idade = anoAtual - anoP;
        while (true) {
            if (mesP >= mesAtual) {
                if (mesP > mesAtual) {
                    idade -= 1;
                    break;
                }

                if (diaP > diaAtual) {
                    idade -= 1;
                    break;
                }

            }
            break;
        }
        if (idade > 1) {
            System.out.println("Idade : " + idade + " anos \n");
        } else {
            if (idade < 1) {
                System.out.println("Voce possui menos de um ano de idade!!! \n");
            } else {
                System.out.println("Idade : " + idade + " ano \n");
            }
        }

    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("------------------------------------------------------- ");
            System.out.println("Para sair digite 0 ");
            System.out.println("Digite uma data: EX: 12/10/2012 ");
            System.out.println("------------------------------------------------------- ");
            int diaDig = 0, mesDig = 0, anoDig = 0;

            Scanner l = new Scanner(System.in);
            String dataDigitada = l.nextLine();
            String dataFormatada = dataDigitada.replace("/", "").replace(" ", "").replace("-", "");
            if (dataFormatada.equals("0")) {
                break;
            }

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

}
