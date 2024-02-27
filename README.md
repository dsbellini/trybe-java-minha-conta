# Projeto Minha Conta

Boas-vindas ao repositório do projeto `Minha Conta`.

<details>
  <summary>👨‍💻 O que foi desenvolvido</summary><br />

Neste projeto, foi implementada uma ferramenta para gestão do consumo energético. A
ferramenta
desenvolvida permite que pessoas consumidoras emitam suas faturas, estimem os gastos mensais,
consultem histórico de pagamentos e uma série outras funcionalidades baseadas em uma SDK fornecida
pela Íons Energia, uma concessionária de luz ficticia que trabalhará conosco na entrega de uma
demanda
bem real.
</details>

<details>
  <summary><strong>📝 Habilidades que foram utilizadas</strong></summary>
<h3>Aplicação dos conhecimentos adquiridos dos fundamentos da linguagem Java</h3>
<p>- Classes em Java</p>
<p>- Tipos primitivos</p>
<p>- Tipos não primitivos</p>
<p>- Atributos, métodos e construtores</p>
<p>- Strings e Arrays</p>
<p>- Conversão de tipos</p>
<p>- Estruturas de repetição for/while</p>
<p>- Classes wrapper</p>
<p>- Gerenciamento de dependências com Maven</p>
</details>

<details>
<summary><strong>🎛 Checkstyle</strong></summary>

Para garantir a qualidade do código, utilizei nesse projeto o `Checkstyle`. Assim, o código
estará alinhado às boas práticas de desenvolvimento, sendo mais legível e de fácil manutenção!
Para poder rodar o `Checkstyle`, certifique-se de ter executado o comando `mvn install` dentro do
repositório.

</details>

<details>
<summary><strong>🛠 Testes</strong></summary>


Para executar todos os testes, basta rodar o comando:

```bash
mvn test
```

Para executar apenas uma classe de testes:

```bash
mvn test -Dtest="TestClassName"
```

</details>

## Tasks realizadas no projeto

### 1 - Implementar os atributos e o construtor da classe `EnergyBill`

Implementado em:
> src/main/java/com/betrybe/minhaconta/business/EnergyBill.java

O processo de emissão de uma conta de luz tem como base a classe `EnergyBill` que representa uma conta
de luz vinculada ao endereço de uma pessoa cliente.

### 2 - Implementar o método `adjustedTariff()`

Implementado em:
> src/main/java/com/betrybe/minhaconta/business/EnergyBill.java

Esse novo método permitirá a concessionária Íons Energia emitir um acréscimo de 10% sobre a conta de
luz quando o endereço `NÃO` estiver associado a um plano residencial.

### 3 - Implementar o método `calculateTotalUsage()`

Implementado em
> src/main/java/com/betrybe/minhaconta/business/EnergyBill.java

Este método deve retornar o total mensal em quilowatt-hora consumido por uma lista de dispositivos
eletrônicos.

Para os demais requisitos deste projeto é importante que você compreenda a operação das classes
`ConsoleUserInterface` e `LightDealerApi`, implementadas respectivamente em:

> src/main/java/com/betrybe/minhaconta/presentation/ConsoleUserInterface.java
> src/main/java/com/ions/lightdealer/sdk/service/LightDealerApi.java

As instâncias dessas classes serão armazenadas nos atributos `api` e `ui` da classe `Application`.

### 4 - Implementar o método `run()`

Implementado em
> src/main/java/com/betrybe/minhaconta/presentation/Application.java

Este método é responsável por rodar o menu de opções em nossa aplicação. Além disso,
deverá chamar o método `inputMenuOption()` da classe `ConsoleUserInterface` e o método
`runOptionAction()` da própria `Application`.

### 5 - Implementar o método `runOptionAction()`

Implementado em
> src/main/java/com/betrybe/minhaconta/presentation/Application.java

O método `runOptionAction()` recebe a opção vinda do menu implementado no requisito anterior e
deverá executar a ação correspondente (chamada de método).

### 6 - Implementar o método `registerClient()`

Implementado em
> src/main/java/com/betrybe/minhaconta/presentation/Application.java

Precisamos cadastrar nossas pessoas clientes e para fazer isso utilizaremos o método
`registerClient()`.

### 7 - Implementar o método `registerClientAddress()`

Implementado em
> src/main/java/com/betrybe/minhaconta/presentation/Application.java

Este método deve coletar o CPF da pessoa cliente para verificar se ela já está cadastrada em nosso
sistema, esta solicitação deve ser feita por meio do método `inputClientCpf()` da
`ConsoleUserInterface`.

---

### 8 - Implementar o método `registerAddressDevices()`

Implementado em
> src/main/java/com/betrybe/minhaconta/presentation/Application.java

Com a base pronta precisamos de um mecanismo que nos permita cadastrar dispositivos
eletrônicos.

### 9 - Implementar o método `estimateAddressBill()`

Implementado em
> src/main/java/com/betrybe/minhaconta/presentation/Application.java

Foi implementado um método para estimar a conta de energia de um determinado endereço e
apresentar este valor em tela.

### 10 - Implementar os métodos `optimizeEnergyBill()` e `suggestReducedUsage`

Implementado em
> src/main/java/com/betrybe/minhaconta/presentation/Application.java

Devemos sugerir as pessoas clientes meios para economizar na conta de luz.

** O método `suggestReducedUsage()`:**

Este método receberá um parâmetro do tipo `EnergyAccount`, e deverá usar o método `findHighConsumptionDevices()` do
parâmetro recebido para pegar o array contendo os dispositivos de maior uso.

### 11 - Desafio final - Implementar o método `findHighConsumptionDevices()`

Implementado em
> src/main/java/com/betrybe/minhaconta/business/EnergyAccount.java

Este método deve retornar a lista de dispositivos de maior consumo energético em todos os endereços
associados a uma pessoa cliente.

<!-- mdi versão 1.1 projeto ⚠️ não exclua esse comentário -->
