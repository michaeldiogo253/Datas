package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

    private Integer dia, mes, ano;

    public Data(Integer dia, Integer mes, Integer ano) {

        if (mes < 1 || mes > 12) {

            System.out.println("Informe um mes valido.");

        }

        if (dia < 1 && ano > 31) {

            System.out.println("Tem que ser de 1 a 31!!!");

        }

        if (ano > 2020) {

            System.out.println("Ano invalido");

        }
        try {
            if (verificaData(dia, mes, ano)) {

                this.dia = dia;

                this.mes = mes;

                this.ano = ano;
                calculoIdade(dia, mes, ano);

            } else {
                System.out.println("data invalida");
            }
        } catch (Exception e) {
            System.out.println("data incorreta");
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

    public void calculoIdade(Integer diaV, Integer mesV, Integer anoV) {
        Date d = new Date();
        SimpleDateFormat formatarDia = new SimpleDateFormat("d");
        SimpleDateFormat formatarMes = new SimpleDateFormat("M");
        SimpleDateFormat formatarAno = new SimpleDateFormat("y");

        int diaAtual = Integer.parseInt(formatarDia.format(d));
        int mesAtual = Integer.parseInt(formatarMes.format(d));
        int anoAtual = Integer.parseInt(formatarAno.format(d));

       
        int diaAniv = diaAtual - diaV;
        int mesAniv = mesAtual - mesV;
        int anoAniv = anoAtual - anoV;

        System.out.println("dia atual " + diaAniv);
        System.out.println("mes atual " + mesAniv);
        System.out.println("ano atual " + anoAniv);

        System.out.println("idade : " + anoAniv);

    }

    public static void main(String[] args) {
        Data d = new Data(1, 6, 1998);

// TODO code application logic here
    }

}
