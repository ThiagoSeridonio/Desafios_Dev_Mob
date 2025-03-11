import kotlin.random.Random

fun main(){
    //para testes de cada desafio é so escrever o nome da funcao.(ex: reducaoTempo() )
    //lista de todas as funcoes usadas:
    //reducaoTempo(), triangulo(), trianguloTipagem(), jooKenPo(), adivinhaNumero()
    //adivinhaNumeroLimitado(), pa(), fibonacci(), vetorOrdenado(), fibonacciLimitado()


}

fun reducaoTempo(){
    println("Qual a quantidade de cigarros fumados por dia:")
    val qtd = readln().toInt()
    println("Quantas anos vc ja fumou:")
    val anos = readln().toInt()
    val minutos = qtd * 10
    val horas = minutos / 60
    val dias = horas / 24

    println("O fumante perdeu ${dias * anos} de vida")
}

fun triangulo(){
    println("Digite o valor dos três segmentos:")
    val lado1 = readln().toDouble()
    val lado2 = readln().toDouble()
    val lado3 = readln().toDouble()

    if (lado1 < lado2 + lado3 && lado2 < lado1 + lado3 && lado3 < lado1 + lado2) {
        println("É possível formar um triângulo com esses segmentos de reta.")
    } else {
        println("Não é possível formar um triângulo com esses segmentos de reta.")
    }
}

fun trianguloTipagem() {
    println("Digite o valor dos três segmentos:")
    val lado1 = readln().toDouble()
    val lado2 = readln().toDouble()
    val lado3 = readln().toDouble()

    if (lado1 < lado2 + lado3 && lado2 < lado1 + lado3 && lado3 < lado1 + lado2) {
        println("É possível formar um triângulo com esses segmentos de reta.")

        when {
            lado1 == lado2 && lado2 == lado3 -> println("O triângulo é EQUILÁTERO.")
            lado1 == lado2 || lado2 == lado3 || lado1 == lado3 -> println("O triângulo é ISÓSCELES.")
            else -> println("O triângulo é ESCALENO.")
        }
    } else {
        println("Não é possível formar um triângulo com esses segmentos de reta.")
    }
}

fun jooKenPo() {
    // criaçao da lista de opçoes de jogadas
    val opcoes = arrayOf("Pedra", "Papel", "Tesoura")

    println("Bem-vindo ao jogo de JoKenPo!\nEscolha sua jogada:")
    println("1. Pedra")
    println("2. Papel")
    println("3. Tesoura")

    val escolhaJogador = readln().toInt()

    // verifica se a escolha é valida

    if (escolhaJogador !in 1..3) {
        println("Opção inválida. Tente novamente.")
        return
    }

    //mostra a escolha do jogador e do computador

    val escolhaComputador = Random.nextInt(3) + 1
    println("\nVocê escolheu: ${opcoes[escolhaJogador - 1]}")
    println("O computador escolheu: ${opcoes[escolhaComputador - 1]}")

    // Verificaa o vencedor
    when {
        escolhaJogador == escolhaComputador -> println("Empate!")
        (escolhaJogador == 1 && escolhaComputador == 3) ||
                (escolhaJogador == 2 && escolhaComputador == 1) ||
                (escolhaJogador == 3 && escolhaComputador == 2) -> println("Você ganhou!")
        else -> println("Você perdeu!")
    }
}

fun adivinhaNumero() {
    println("Bem-vindo ao jogo de adivinhação!\nTente adivinhar o número sorteado entre 1 e 5.")

    // sorteio do numero de 1 a 5(o numero 6 é esclusivo logo 1 a 6 seria o msm de 1 a 5)
    val numeroSorteado = Random.nextInt(1, 6)

    var tentativas = 0
    var numeroJogador: Int

    do {
        print("Digite seu palpite (1 a 5): ")
        numeroJogador = readln().toInt()

        // Verifica se o palpite está dentro do intervalo permitido
        if (numeroJogador !in 1..5) {
            println("Número inválido! Por favor, digite um número entre 1 e 5.")
            continue
        }
        // adiciona +1 na var tentaivas
        tentativas++

        //verifica se o numero escolido pelo jogador é menor ou maior que o numero sorteado
        if (numeroJogador < numeroSorteado) {
            println("O número sorteado é maior. Tente novamente!")
        } else if (numeroJogador > numeroSorteado) {
            println("O número sorteado é menor. Tente novamente!")
        }

    //verifica se o numero do jogador é diferente do numero sorteado, caso seja igual volta para o do se nao passa para o proximo passo
    } while (numeroJogador != numeroSorteado)

    //proximo passo caso caso o numero do jogador seja igual ao numero sorteado
    println("Parabéns! Você acertou o número sorteado ($numeroSorteado) em $tentativas tentativas.")
}

fun adivinhaNumeroLimitado() {
    println("Bem-vindo ao jogo de adivinhação!")
    println("Tente adivinhar o número sorteado entre 1 e 10.")
    println("Você tem 4 tentativas.")

    // O computador sorteia um número entre 1 e 10
    val numeroSorteado = Random.nextInt(1, 11)

    // setando as tentativas e o limite de tentativas
    var tentativas = 0
    var numeroJogador: Int
    val maxTentativas = 4

    // Loop de tentativas do jogador
    while (tentativas < maxTentativas) {
        print("Tentativa ${tentativas + 1} de $maxTentativas. Digite seu palpite (1 a 10): ")
        numeroJogador = readln().toInt()

        // Verifica se o numero do jogador está dentro do intervalo permitido
        if (numeroJogador !in 1..10) {
            println("Número inválido! Por favor, digite um número entre 1 e 10.")
            continue
        }

        tentativas++

        // Verifica se o jogador acertou ou se o numero é maior ou menor do que o numero sorteado
        if (numeroJogador == numeroSorteado) {
            println("Parabéns! Você acertou o número sorteado ($numeroSorteado) em $tentativas tentativas.")
            return
        } else if (numeroJogador < numeroSorteado) {
            println("O número sorteado é maior. Tente novamente!")
        } else {
            println("O número sorteado é menor. Tente novamente!")
        }
    }

    // Se o jogador não acertou após 4 tentativas
    println("Você não acertou o número. O número sorteado era $numeroSorteado.")
}

fun pa() {
    // Leitura do primeiro termo e da razão
    print("Digite o primeiro termo da PA: ")
    val primeiroTermo = readln().toInt()
    print("Digite a razão da PA: ")
    val razao = readln().toInt()

    var termoAtual = primeiroTermo
    var soma = 0

    // Exibindo os 10 primeiros termos da PA
    println("\nOs 10 primeiros termos da PA são:")
    for (i in 1..10) {
        println(termoAtual)
        soma += termoAtual
        termoAtual += razao  // Calcula o próximo termo
    }

    // Exibindo a soma dos 10 primeiros termos
    println("\nA soma dos 10 primeiros termos da PA é: $soma")
}

fun fibonacci() {
    println("Os 10 primeiros elementos da sequência de Fibonacci são:")

    var a = 1
    var b = 1

    // Exebiçao dos 10 elemettos da sequencia de fibonacci

    print("$a $b ")  // Exibe os dois primeiros números (1 e 1)

    // Calcula e exibe os próximos números da sequência
    for (i in 3..10) {
        val c = a + b
        print("$c ")

        // Atualiza os valores de a e b
        a = b
        b = c
    }
}

fun vetorOrdenado() {
    // criaçao do vetor de 20 posições
    val vetor = IntArray(20)

    // Preenchendo o vetor com números aleatórios entre 0 e 99
    for (i in vetor.indices) {
        vetor[i] = Random.nextInt(0, 100)  // Gera um número aleatório entre 0 e 99
    }

    // Exibindo os números gerados
    println("Números gerados aleatoriamente:")
    for (numero in vetor) {
        print("$numero ")
    }

    // Ordenando o vetor em ordem crescente(O sort ordena os elementos de forma crescente por padrão, sortDescending para ordem decrescente)
    vetor.sort()

    // Exibindo os números ordenados
    println("\n\nNúmeros ordenados em ordem crescente:")
    for (numero in vetor) {
        print("$numero ")
    }
}

fun fibonacciLimitado() {
    println("Digite a quantidade de termos da sequência de Fibonacci que deseja ver:")
    val termos = readln().toInt()

    // Chama o procedimento FibonacciParaLimitado passando o número de termos
    fibonacciParaLimitado(termos)
}

// Procedimento Fibonacci que recebe um número inteiro indicando quantos termos mostrar
fun fibonacciParaLimitado(quantidade: Int) {
    // Variáveis para os primeiros dois termos da sequência
    var a = 1
    var b = 1

    // Exibe os primeiros dois termos, se houver pelo menos 1 termo a ser exibido
    if (quantidade >= 1) print("$a >> ")
    if (quantidade >= 2) print("$b >> ")

    // Exibe os termos seguintes, se necessário
    for (i in 3..quantidade) {
        val c = a + b
        print("$c >> ")
        a = b
        b = c
    }

    // Exibe "FIM" após os termos
    println("FIM")
}
