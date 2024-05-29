import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MensagemVital {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int dificuldadeEscolhida = 0;
        System.out.println("MensagemVital");
        System.out.println();
        System.out.print("QUAL A DIFICULDADE (4 - 10): ");
        dificuldadeEscolhida = leitor.nextInt();

        while (dificuldadeEscolhida < 4 || dificuldadeEscolhida > 10) {
            System.out.println("Escolha entre 4 e 10: ");
            dificuldadeEscolhida = leitor.nextInt();
        }
        System.out.println("ENVIE ESTA MENSAGEM");

        geracaoDaPalavra(dificuldadeEscolhida);
    }

    private static void geracaoDaPalavra(int dificuldadeEscolhida) {

        ThreadLocalRandom geradorDePalavras = ThreadLocalRandom.current();
        // o ThreadL.R. ele é o "Random" só que para palavras
        StringBuilder mensagem = new StringBuilder();

        for (int i = 1; i <= dificuldadeEscolhida; i++) {
            char palavra = (char) geradorDePalavras.nextInt(65, 91);
            //casting é algo como int valor = 73; char letra (char) valor; temporariamente o int atua como um char, porém não é.
            mensagem.append(palavra);
             /*o i equivale a um número base para formar a palavra corretamente,
         se i for menor ou igual à dificuldade escolhida i soma mais 1, assim aleatorizando mais uma letra*/
        }
        System.out.println(mensagem);
        sleep(dificuldadeEscolhida);

        fimDoJogo(mensagem);
    }

    private static void sleep(int dificuldadeEscolhida) {
        int tempo = dificuldadeEscolhida * 1000;
        int numeroDeLinhas = 2000;

        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < numeroDeLinhas; i++) {
            System.out.println();
        }
    }

    private static void fimDoJogo(StringBuilder mensagem) {
        Scanner leitorTxt = new Scanner(System.in);
        String mensagemDigitada = "";

        System.out.println("DIGITE A MENSAGEM AGORA!");
        mensagemDigitada = leitorTxt.nextLine();

        if (mensagemDigitada.equalsIgnoreCase(mensagem.toString())) {
            System.out.println("VOCÊ SALVOU O MUNDO");
        } else {
            System.out.println("O MUNDO ACABOU, QUE PENA...");
        }

        System.exit(0);
    }
}
