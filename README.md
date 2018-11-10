# SimulES

Trabalho prático da disciplina Reuso de Sofware (2018-2), ministrada pelo Professor Eduardo Figueiredo ([DCC/UFMG](https://www.ufmg.br/)). Reuso e evolução do sistema SimulES.

Grupo G1: Aline Brito, Igor Muzetti

## Manuais

## Manual de instalação e configuração

Deve-se seguir instruções descritas abaixo para para instalar e configurar o SimulES:
    
* Instalar o Java, versão 8;
    
* Baixar a [FeatureIDE](https://featureide.github.io/) ou outra IDE compatível e executá-la;
    
* Instalar o plugin AJDT, através da opção EclipseMarketplace disponível no menu Help da IDE.

* Importar o código fonte do projeto para a IDE utilizada.
    
* Converter o projeto para aspecto. Para tanto, pressione o botão direito do mouse sobre o projeto, e selecione as opções Configure >> Convert to Aspect Project.
    
* Executar o projeto através das opções Run as >> AspectJ/Java Aplication.

## Manual de operação

O jogo SimulES compreende três etapas principais que envolvem a configuração e definição das ordem dos jogadores, visualização das especificações do jogo, e construção dos módulos. As instruções a seguir detalham cada uma dessas etapas.

* Configurar o jogo: Na primeira etapa do jogo deve-se informar o nome dos participantes na tela exibida e pressionar o botão OK. Em seguida uma opção para jogar o dado é exibida. Deve-se então, jogar os dados para definir a ordem dos participantes.

* Visualizar especificações do jogo: Após a definição da ordem dos jogadores, a carta de projeto sorteada é exibida. Após pressionar o botão OK, a tela principal do jogo é exibida. O cartão do projeto pode ser visualizado novamente através da opção Ver carta projeto, se necessário.

* Construir módulos:  A etapas posteriores do jogo consistem na construção dos módulos especificados no cartão do projeto. Em cada rodada o usuário deve jogar o dado para definir a qualidade de cartas que poderá acessar. Após esta etapa, o usuário pode optar por aplicar, guardar, ou descartar os itens adquiridos. Dentre as cartas sorteadas pode existir engenheiros, capazes de gerar e inspecionar os artefatos para a construção dos módulos. Dessa forma, a linha de produtos de software consiste nas várias combinações de artefatos e ações dos usuários no jogo. O novo módulo de testes incluído, assim como, as novas cartas de conceito e problema são instanciados a partir dessas funcionalidades disponíveis no tabuleiro.






