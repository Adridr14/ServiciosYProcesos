import java.util.Scanner;

public class Teclado
{
    private Scanner teclado;

    public Teclado()
    {
        teclado = new Scanner(System.in);
    }

    public int leerNumero()
    {
        System.out.println("Dame número");
        int numero = teclado.nextInt();
        teclado.nextLine();
        return numero;
    }

    public char leerOperacion()
    {
        // teclado.nextLine();
        char oper;
        do
        {
            System.out
                    .println("Qué operación quieres realizar +  -  *  / q (quit)");
            oper = teclado.nextLine().charAt(0);
        }
        while (!correcta(oper));
        return oper;
    }

    private boolean correcta(char oper)
    {
        return oper == '+' || oper == '-' || oper == '*' || oper == '/'
                || oper == 'q' || oper == 'Q';
    }
}
