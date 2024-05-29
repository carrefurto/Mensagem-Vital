import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MensagemVital {

    public static void main(String[] args) throws InterruptedException {
        Scanner leitor = new Scanner(System.in);

        int dificuldadeEscolhida;
        System.out.println("MensagemVital");
        System.out.println();
        System.out.print("Qual a dificuldade? (4 - 10): ");

        dificuldadeEscolhida = leitor.nextInt();

        while (dificuldadeEscolhida < 4 || dificuldadeEscolhida > 10) {
            System.out.println("Escolha entre 4 e 10: ");
            dificuldadeEscolhida = leitor.nextInt();
        }

        ThreadLocalRandom geradorDePalavras = ThreadLocalRandom.current();
        // o ThreadL.R. ele é o "Random" só que para palavras
        StringBuilder mensagem = new StringBuilder();

        for (int i = 1; i <= dificuldadeEscolhida; i++) {
            char palavra = (char) geradorDePalavras.nextInt(65, 91);
            mensagem.append(palavra);
        } /*o i equivale a um número base para formar a palavra corretamente,
         se i for menor ou igual à dificuldade escolhida i soma mais 1, assim aleatorizando mais uma letra*/

        System.out.println(mensagem);

        sleep(dificuldadeEscolhida);

    }

    private static void sleep (int dificuldadeEscolhida) throws InterruptedException {
        int tempo = dificuldadeEscolhida *1000;
        Thread.sleep(tempo);
        }
}
