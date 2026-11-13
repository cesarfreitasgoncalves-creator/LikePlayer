# PROJETO: AURALIS MUSIC — ANDROID MUSIC PLAYER

## 1. SUA FUNÇÃO E AUTONOMIA

Você é o engenheiro de software principal, arquiteto, desenvolvedor Android, designer de interface, engenheiro de testes e responsável pela entrega deste projeto.

Seu objetivo é desenvolver um aplicativo Android completo, funcional, moderno, bonito, eficiente e instalável, entregando um arquivo `.APK` pronto para instalação.

Você está operando em modo AUTOPILOT, com permissão para utilizar o terminal, instalar dependências, consultar a internet, criar arquivos, modificar configurações, executar comandos e realizar todas as operações necessárias dentro do ambiente de desenvolvimento.

### Regras de autonomia

1. Trabalhe de maneira independente. Não espere que o usuário diga qual arquivo criar, qual dependência instalar ou qual erro corrigir.
2. Analise o ambiente e o repositório antes de começar.
3. Crie um plano de execução completo e divida o projeto em etapas.
4. Caso seu ambiente disponibilize subagentes, delegue tarefas a eles sempre que isso trouxer vantagem real.
5. Utilize subagentes para atividades paralelizáveis, como pesquisa visual, pesquisa de bibliotecas e APIs, desenvolvimento da interface, reprodução, estatísticas, testes, revisão de código e análise de desempenho.
6. Coordene os subagentes, revise seus resultados e integre tudo em uma arquitetura consistente.
7. Não delegue a responsabilidade final. Você é responsável por garantir que o produto completo funcione.
8. Não fique preso a um plano inicial caso encontre uma solução melhor.
9. Identifique problemas, investigue suas causas, implemente correções e teste novamente.
10. Nunca considere um erro resolvido apenas porque desapareceu do terminal. Verifique o comportamento relacionado.
11. Não esconda erros, não desative testes para conseguir um build e não substitua funcionalidades reais por simulações.
12. Não interrompa o trabalho depois de criar a estrutura inicial. O objetivo é entregar o aplicativo funcionando.

### Processo de autocorreção

Adote permanentemente este ciclo:

ANALISAR → PLANEJAR → IMPLEMENTAR → EXECUTAR → TESTAR → IDENTIFICAR FALHAS → CORRIGIR → TESTAR NOVAMENTE.

Quando uma implementação falhar, leia o erro completo, investigue a origem, consulte documentação oficial ou fontes confiáveis, compare soluções, implemente a correção e execute novamente os testes afetados. Verifique se a correção não prejudicou outros módulos.

Não faça correções superficiais apenas para esconder sintomas. Se uma biblioteca, API ou abordagem estiver obsoleta, procure uma alternativa atual e documentada.

Não solicite autorização para decisões técnicas comuns. Escolha soluções sensatas e prossiga.

---

## 2. OBJETIVO DO PRODUTO

Desenvolver um aplicativo Android chamado provisoriamente **Auralis Music**.

O aplicativo deve ser um reprodutor musical completo, com suporte a arquivos locais, reprodução de mídia, personalização visual, organização musical, estatísticas de utilização e descoberta de músicas pela internet.

A experiência deve ser semelhante à de um aplicativo comercial de música, com identidade visual própria e excelente qualidade de implementação.

Não quero um protótipo, uma demonstração ou um conjunto de telas bonitas sem funcionalidade. Quero um aplicativo real.

### Tecnologias principais

Utilize preferencialmente:

- Kotlin como linguagem principal.
- Android nativo.
- Jetpack Compose para a interface.
- Material 3 como base de componentes, com identidade visual personalizada.
- AndroidX Media3 / ExoPlayer para reprodução de mídia.
- MediaSessionService para reprodução em segundo plano.
- Room para banco de dados local.
- DataStore para preferências.
- Kotlin Coroutines e Flow para operações assíncronas.
- Gradle com Kotlin DSL.
- GitHub Actions para compilação automatizada.

Pesquise as versões estáveis e compatíveis das dependências antes de utilizá-las. Evite bibliotecas abandonadas, desnecessárias ou excessivamente pesadas. Adote uma arquitetura organizada, modular e sustentável.

---

## 3. PESQUISA E REFERÊNCIAS

Antes e durante o desenvolvimento, pesquise aplicativos existentes de reprodução musical.

Utilize referências de interface e experiência de uso de aplicativos como Spotify, Apple Music, YouTube Music, Musicolet, Poweramp, Retro Music Player, Oto Music e outros players Android bem avaliados.

Não copie integralmente nenhum desses aplicativos. Observe especialmente organização da biblioteca, navegação, interface do player, animações, apresentação de capas, listas de reprodução, controles, personalização, estatísticas e experiência de descoberta musical.

Pesquise também projetos open-source, bibliotecas Android e implementações de referência. Priorize documentação oficial do Android e das APIs utilizadas.

Registre as principais decisões técnicas e referências no README.

---

## 4. IDENTIDADE VISUAL E INTERFACE

A interface é uma das partes mais importantes do projeto. Quero um design bonito, moderno, fluido, sofisticado e consistente. Não faça uma interface genérica de aplicativo Android. Crie uma identidade visual própria para o Auralis.

### Direção visual

Utilize como inspiração:

- Design moderno.
- Transparências discretas.
- Cards com cantos arredondados.
- Hierarquia visual bem definida.
- Espaçamentos consistentes.
- Ícones coerentes.
- Tipografia cuidadosamente selecionada.
- Animações suaves.
- Capas de álbuns valorizadas.
- Transições elegantes.

A aparência pode ter elementos de glassmorphism, desde que isso não prejudique a legibilidade ou o desempenho.

Utilize uma paleta inicial sofisticada, mas permita que o usuário modifique praticamente toda a identidade visual.

### Navegação principal

Organize o aplicativo em seções acessíveis e intuitivas:

1. Início.
2. Biblioteca.
3. Buscar.
4. Estatísticas.
5. Perfil e configurações.

Implemente um mini-player persistente na parte inferior, sempre que houver uma música selecionada. Ao tocar no mini-player, abra a tela completa de reprodução.

### Tela inicial

A tela inicial deve apresentar saudação personalizada, música atualmente reproduzida, músicas ouvidas recentemente, mais reproduzidas, playlists, álbuns, artistas, descobertas musicais, atalhos para a biblioteca e estatísticas resumidas.

As seções devem ser organizadas visualmente, sem sobrecarregar a tela.

### Tela de reprodução

Crie uma tela completa contendo:

- Capa da música.
- Nome, artista e álbum.
- Barra de progresso, tempo atual e tempo total.
- Play e pause.
- Música anterior e próxima.
- Reprodução aleatória e repetição.
- Favoritos.
- Acesso às letras.
- Acesso à fila de reprodução.
- Menu de opções.

Permita que a capa ocupe boa parte da tela. Implemente animações discretas para mudanças de música, capas e controles. A interface deve continuar funcional durante a reprodução.

---

## 5. PERSONALIZAÇÃO VISUAL

Crie uma seção específica de aparência com um sistema de personalização abrangente.

### Cores

Permita modificar cor principal, cor de destaque, cor dos botões, cor dos elementos selecionados, cor do fundo e intensidade de transparências.

### Papel de parede

Permita selecionar uma imagem da galeria, utilizá-la como fundo do aplicativo, ajustar o enquadramento, modificar a opacidade, aplicar escurecimento, aplicar desfoque caso seja viável e restaurar o fundo original.

O papel de parede não deve comprometer a leitura dos textos.

### Temas

Implemente tema escuro, tema claro, tema baseado no sistema, temas personalizados e diferentes combinações de cores.

### Outros ajustes

Permita personalizar formato dos cards, intensidade das animações, estilo de apresentação das capas, aparência do mini-player, estilo da tela de reprodução, tamanho de determinados elementos e preferências de navegação.

Todas as configurações devem ser persistidas localmente. Não obrigue o usuário a configurar novamente o aplicativo depois de fechá-lo.

---

## 6. PERFIL LOCAL

Crie um perfil inteiramente local. Não exija login, conta externa ou cadastro.

O perfil deve permitir definir nome de exibição, selecionar foto de perfil, visualizar músicas favoritas, histórico, estatísticas pessoais, playlists, tempo total de reprodução e artistas mais reproduzidos.

As informações devem permanecer armazenadas no dispositivo. Não crie sincronização em nuvem obrigatória.

---

## 7. REPRODUÇÃO DE MÚSICAS LOCAIS

Esta funcionalidade é essencial. O aplicativo deve localizar e reproduzir os arquivos de mídia do dispositivo.

### Recursos

- Ler músicas disponíveis no dispositivo.
- Exibir músicas por nome, artista, álbum, gênero (quando houver metadados), duração e pastas.
- Pesquisar músicas localmente.
- Adicionar músicas à fila.
- Criar playlists.
- Favoritar músicas.
- Ordenar listas.
- Atualizar a biblioteca.
- Remover músicas da biblioteca sem apagar o arquivo original.

Permita também selecionar arquivos manualmente pelo seletor de documentos do Android.

Gerencie corretamente as permissões de armazenamento nas diferentes versões do Android. Prefira o acesso por MediaStore e Storage Access Framework, utilizando somente as permissões necessárias.

### Formatos

Implemente suporte aos formatos compatíveis com o Media3 e com o dispositivo, incluindo MP3, WAV, FLAC, AAC, M4A, OGG, OPUS, MP4, WebM e outros formatos compatíveis.

A compatibilidade depende dos codecs disponíveis e do conteúdo do arquivo. Não prometa suporte universal a formatos que o dispositivo não consegue decodificar.

### Arquivos MP4

Permita reproduzir arquivos MP4 que contenham áudio e vídeo. Crie uma experiência de reprodução adequada para vídeos locais, exibidos em uma tela própria, com controles e opções de expansão.

Para arquivos com áudio e vídeo, disponibilize também a reprodução enquanto o usuário estiver visualizando o vídeo.

---

## 8. SISTEMA DE REPRODUÇÃO

Implemente um mecanismo de reprodução robusto usando Media3 / ExoPlayer como base.

### Recursos obrigatórios

- Reprodução contínua.
- Reprodução em segundo plano.
- Controles na notificação.
- Controles na tela de bloqueio.
- Compatibilidade com controles de fones Bluetooth.
- Fila de reprodução.
- Próxima música e música anterior.
- Aleatório.
- Repetição de música e da fila.
- Pausa e retomada.
- Busca temporal dentro da música.
- Recuperação do estado de reprodução quando aplicável.

### Recursos adicionais

Quando tecnicamente viáveis, implemente crossfade, reprodução sem intervalos entre faixas, temporizador para interromper a reprodução, controle de velocidade, histórico de reprodução, atalhos para adicionar à fila e gerenciamento da fila em tempo real.

### Equalizador

Implemente uma seção de equalização. Investigue os recursos de áudio disponibilizados pelo Android e pelo Media3.

Considere equalizador gráfico, presets, graves, agudos e personalização manual.

Não afirme que o equalizador funciona em todos os dispositivos sem verificar a disponibilidade do efeito.

---

## 9. DESCOBERTA E PESQUISA MUSICAL ONLINE

Quero uma funcionalidade que permita digitar o nome de uma música e encontrar possíveis resultados na internet.

Exemplo: o usuário digita "Blinding Lights The Weeknd".

O aplicativo apresenta resultados que podem incluir nome da música, artista, capa ou miniatura, álbum, duração quando disponível, origem do resultado, informações disponíveis sobre a licença e ação apropriada para reproduzir ou abrir a fonte original.

### Arquitetura da pesquisa

Não construa uma solução dependente de scraping de páginas HTML. Não utilize endpoints privados, APIs não documentadas ou métodos frágeis de extração de áudio.

Crie uma arquitetura extensível baseada em provedores. Uma interface semelhante a `MusicSearchProvider` poderá ser implementada separadamente para cada serviço.

### A. Jamendo

Investigue a API oficial do Jamendo:

https://developer.jamendo.com/v3.0/docs

Avalie pesquisa por nome e artista, metadados, capas, informações de licença, URLs de reprodução autorizadas, estatísticas disponíveis e letras disponíveis, quando fornecidas.

Permita reproduzir no próprio Auralis somente conteúdo cuja API disponibilize legitimamente para esse uso e cujos termos de licença sejam respeitados. Exiba informações relevantes de atribuição e licença.

### B. YouTube

Investigue a YouTube Data API oficial:

https://developers.google.com/youtube/v3/docs/search/list

Permita pesquisar vídeos e músicas, exibindo resultados claramente identificados como conteúdo do YouTube.

Quando o usuário selecionar um resultado, abra o conteúdo pelo aplicativo oficial do YouTube ou navegador, preservando a experiência e as funcionalidades exigidas pela plataforma.

Não extraia áudio, não baixe conteúdo, não converta vídeos em MP3 e não implemente reprodução oculta em segundo plano de conteúdo do YouTube.

### C. Pesquisa Google

Implemente uma opção que permita abrir uma pesquisa Google com o nome informado.

Utilize uma URL de pesquisa ou uma Intent apropriada do Android. A pesquisa deve abrir no navegador ou no aplicativo disponível.

Não tente interpretar ou extrair resultados de páginas do Google por scraping.

### D. Outros provedores

Pesquise outras APIs públicas e documentadas que ofereçam catálogos musicais e reprodução autorizada.

Avalie qualidade, disponibilidade, custos, requisitos de autenticação e limitações. Não integre serviços somente porque possuem uma URL de áudio acessível.

### Experiência de pesquisa

A tela deve oferecer campo de pesquisa, histórico de pesquisas, resultados separados por provedor, indicador da origem, estados de carregamento, estado de ausência de resultados, tratamento de erros, opção para abrir a fonte original e possibilidade de adicionar resultados compatíveis à biblioteca, quando permitido.

A busca não deve travar a interface. Execute chamadas de rede assincronamente. Implemente cancelamento de buscas anteriores e tratamento de timeout.

Caso uma API exija chave, armazene a configuração fora do código-fonte e documente como configurá-la. O aplicativo deve continuar funcionando normalmente mesmo sem chaves externas.

---

## 10. LETRAS E CAPAS DE MÚSICAS

Implemente um sistema de gerenciamento de informações das músicas.

### Capas

Permita adicionar uma imagem manualmente, escolher uma imagem da galeria, alterar uma capa existente, remover uma capa personalizada, utilizar imagens locais e exibir capas na biblioteca e no player.

Quando disponível, aproveite os metadados embutidos nos próprios arquivos. Não modifique arquivos originais sem autorização explícita do usuário.

### Letras

Crie uma seção para visualizar letras.

Permita inserir letras manualmente, editar letras, salvar letras por música, importar arquivos `.LRC`, exportar letras quando aplicável, exibir letras durante a reprodução e sincronizar linhas com o tempo da música quando houver marcações temporais.

Implemente um visualizador de letras bonito, com destaque para a linha atual.

Não invente letras de músicas protegidas por direitos autorais. Use letras fornecidas legitimamente por fontes autorizadas ou inseridas pelo usuário.

---

## 11. ESTATÍSTICAS MUSICAIS

Implemente um sistema de estatísticas real, baseado no histórico local de reprodução. Utilize Room para armazenar os eventos necessários.

### Estatísticas diárias

- Músicas mais ouvidas do dia.
- Artistas mais ouvidos.
- Tempo total de reprodução.
- Quantidade de músicas reproduzidas.

### Estatísticas semanais

- Músicas mais ouvidas da semana.
- Artistas mais ouvidos.
- Tempo total de audição.
- Evolução diária.
- Comparação entre dias.

### Estatísticas adicionais

- Música mais reproduzida de todos os tempos.
- Artista favorito por quantidade de reproduções.
- Álbuns mais reproduzidos.
- Histórico cronológico.
- Tempo total desde a instalação.
- Gráficos de audição.

Os dados precisam ser calculados a partir de eventos reais. Não utilize dados fictícios para preencher gráficos.

Crie critérios consistentes para contabilizar uma reprodução, evitando registrar repetidamente a mesma música por causa de eventos internos do player.

Utilize o horário local do dispositivo para organizar estatísticas diárias e semanais. Todas as estatísticas pessoais devem ser armazenadas localmente.

---

## 12. PLAYLISTS E ORGANIZAÇÃO

Implemente um sistema completo de playlists.

Recursos:

- Criar playlist.
- Alterar nome.
- Alterar descrição.
- Adicionar capa.
- Adicionar músicas.
- Remover músicas.
- Reordenar músicas.
- Excluir playlist.
- Reproduzir playlist.
- Adicionar playlist à fila.
- Favoritar playlist.

Crie também playlists automáticas, quando possível: tocadas recentemente, mais tocadas, favoritas, nunca reproduzidas e adicionadas recentemente.

Todas as playlists devem persistir após o fechamento do aplicativo.

---

## 13. RECURSOS EXTRAS

Você tem liberdade para desenvolver funcionalidades adicionais que melhorem o produto.

Considere:

- Sleep Timer.
- Widget de reprodução na tela inicial do Android.
- Busca global na biblioteca.
- Histórico inteligente.
- Atalhos de reprodução.
- Filtros por gênero.
- Gerenciamento de artistas e álbuns.
- Importação e exportação de playlists.
- Backup local das configurações e dos dados do aplicativo.
- Recuperação da fila de reprodução.
- Visualização de metadados detalhados.
- Detecção de arquivos duplicados.
- Personalização da tela de reprodução.
- Configuração de qualidade de streaming, quando o provedor oferecer essa opção.

Implemente recursos extras de maneira gradual. Priorize funcionalidades realmente úteis e não adicione complexidade apenas por quantidade.

---

## 14. DESEMPENHO E CONSUMO DE MEMÓRIA

**ESTE É UM REQUISITO FUNDAMENTAL.**

O aplicativo precisa consumir o mínimo de memória possível sem comprometer sua experiência de utilização. Evite implementar recursos de forma desnecessariamente pesada.

### Requisitos

1. Não carregue toda a biblioteca musical na memória simultaneamente.
2. Utilize paginação ou carregamento gradual quando adequado.
3. Evite listas gigantes sem lazy loading.
4. Carregue imagens em tamanhos apropriados.
5. Utilize cache de imagens limitado.
6. Evite decodificar imagens em resolução maior que a necessária.
7. Evite recomposições desnecessárias no Jetpack Compose.
8. Não mantenha serviços funcionando sem necessidade.
9. Libere recursos de reprodução quando apropriado.
10. Evite múltiplas instâncias do ExoPlayer.
11. Utilize operações assíncronas para leitura de arquivos e processamento.
12. Cancele tarefas que deixaram de ser necessárias.
13. Evite bibliotecas grandes quando uma solução nativa for suficiente.
14. Não mantenha conexões de rede abertas sem necessidade.
15. Não faça pesquisas ou sincronizações automáticas em excesso.
16. Não mantenha visualizadores ou animações pesadas ativos quando não estiverem visíveis.
17. Evite decodificação de vídeo enquanto o usuário não estiver reproduzindo um vídeo.

### Interface

Use LazyColumn, LazyRow e outras estruturas apropriadas. Mantenha o estado da interface organizado. Evite atualizações excessivas da tela.

### Banco de dados

Utilize consultas eficientes, índices quando necessários e operações em lote. Não carregue dados desnecessários em cada abertura de tela.

### Dependências

Analise o peso e a finalidade de cada dependência. Não adicione dezenas de bibliotecas desnecessárias.

### Verificação

Execute testes e inspeções de desempenho. Investigue vazamentos de memória, consumo excessivo de CPU, processamento desnecessário e problemas de bateria.

Não declare o aplicativo otimizado sem verificar seu comportamento.

---

## 15. ARQUITETURA E ORGANIZAÇÃO DO CÓDIGO

Organize o projeto de forma profissional.

Uma possível estrutura inicial:

- `app/`
- `core/`
- `data/`
- `domain/`
- `playback/`
- `library/`
- `search/`
- `statistics/`
- `playlists/`
- `profile/`
- `customization/`
- `ui/`
- `navigation/`

Adapte a estrutura conforme a complexidade real.

Utilize separação de responsabilidades. Evite classes gigantes, funções com responsabilidades demais, código duplicado, dependências circulares, lógica de banco de dados dentro de componentes visuais, chamadas de rede diretamente na interface, código morto e arquivos desnecessários.

Utilize interfaces e abstrações quando trouxerem benefícios concretos.

Implemente tratamento de erros e estados de carregamento. Escreva código legível, organizado e sustentável.

O projeto deve ser fácil de continuar desenvolvendo no futuro.

---

## 16. SEGURANÇA, PRIVACIDADE E PERMISSÕES

O perfil é local. Não implemente coleta de dados pessoais desnecessária. Não adicione analytics, rastreamento ou publicidade por padrão.

Solicite somente permissões realmente necessárias. Explique de maneira clara a finalidade das permissões.

Nunca coloque tokens privados, senhas ou chaves secretas diretamente no código-fonte.

Não envie dados locais do usuário para serviços externos sem uma ação clara e necessária.

Preserve os arquivos originais das músicas.

Trate corretamente URIs de arquivos e permissões persistentes concedidas pelo Android.

---

## 17. TESTES E QUALIDADE

Não considere o projeto finalizado somente porque ele compila.

Implemente testes para os componentes importantes.

Teste especialmente:

- Reprodução local.
- Navegação.
- Gerenciamento da fila.
- Persistência de preferências.
- Persistência de playlists.
- Estatísticas.
- Busca.
- Gerenciamento de capas.
- Gerenciamento de letras.
- Tratamento de arquivos inválidos.
- Comportamento sem conexão com a internet.
- Reprodução em segundo plano.
- Reinicialização do aplicativo.
- Permissões negadas.
- Recuperação de erros.

Execute os testes disponíveis. Utilize lint e outras verificações adequadas.

Caso tenha acesso a um emulador, realize testes instrumentados e testes visuais. Verifique as interfaces em diferentes tamanhos de tela.

Corrija os problemas encontrados. Não remova funcionalidades para fazer os testes passarem.

---

## 18. WORKFLOW DE COMPILAÇÃO E ENTREGA

**A ENTREGA DO APK É O OBJETIVO FINAL DO PROJETO.**

Não pare depois de escrever o código.

Crie um workflow funcional do GitHub Actions em:

`.github/workflows/android-apk.yml`

O workflow deve:

1. Ser executável por push.
2. Ser executável por pull request.
3. Possuir execução manual por `workflow_dispatch`.
4. Preparar o ambiente Android.
5. Configurar a versão correta do JDK.
6. Preparar o Gradle.
7. Utilizar cache de dependências quando apropriado.
8. Executar testes.
9. Executar verificações de qualidade.
10. Compilar o APK.
11. Verificar se o APK foi realmente produzido.
12. Publicar o arquivo como GitHub Actions Artifact.

Utilize versões atuais e compatíveis das Actions.

### Arquivo final

O APK de depuração deve estar disponível em:

`app/build/outputs/apk/debug/app-debug.apk`

Caso a estrutura do projeto seja diferente, ajuste o caminho de acordo.

Crie também uma cópia organizada em um diretório de distribuição, caso isso facilite o download.

### Entrega

Ao concluir:

- Verifique se o APK existe.
- Verifique o tamanho.
- Verifique se o build terminou sem erros.
- Verifique o identificador do pacote.
- Confirme o tipo de compilação.
- Informe o caminho exato do APK.
- Disponibilize o arquivo para download, caso o ambiente permita.
- Caso o download direto não seja possível, disponibilize o workflow e explique precisamente onde encontrar o Artifact na aba Actions do GitHub.

Não invente um link de download. Não declare que o APK foi compilado se isso não aconteceu.

O APK de debug precisa ser instalável para testes.

Não invente uma assinatura de produção. Caso seja necessária uma versão release assinada, documente a configuração de um keystore próprio e utilize secrets do GitHub, sem expor credenciais.

---

## 19. DOCUMENTAÇÃO

Crie um `README.md` profissional, preferencialmente em português.

Inclua nome do aplicativo, descrição, funcionalidades, tecnologias utilizadas, arquitetura, como compilar, como executar testes, como configurar APIs externas, como configurar o GitHub Actions, como obter o APK, limitações conhecidas e fontes/documentação consultadas.

Mantenha a documentação sincronizada com a implementação real. Não documente recursos que não existem.

---

## 20. PRIORIZAÇÃO DO DESENVOLVIMENTO

Organize as entregas por prioridade.

### PRIORIDADE CRÍTICA — P0

O aplicativo precisa ter:

- Projeto Android funcional.
- Interface principal.
- Navegação.
- Biblioteca local.
- Reprodução de músicas locais.
- Media3 / ExoPlayer.
- Reprodução em segundo plano.
- Mini-player.
- Tela de reprodução.
- Persistência básica.
- Playlists.
- Personalização visual básica.
- Build APK funcional.
- Workflow do GitHub Actions.

### PRIORIDADE ALTA — P1

Implemente:

- Perfil local.
- Estatísticas diárias e semanais.
- Letras.
- Gerenciamento de capas.
- Busca online.
- Pesquisa Google.
- Integração com provedores autorizados.
- Equalizador.
- Personalizações avançadas.
- Reprodução de arquivos de vídeo.

### PRIORIDADE ADICIONAL — P2

Implemente, conforme viabilidade:

- Crossfade.
- Widget Android.
- Backup local.
- Playlists inteligentes.
- Animações adicionais.
- Recursos avançados de descoberta.
- Estatísticas adicionais.

Não deixe que uma funcionalidade opcional impeça a entrega do núcleo funcional.

---

## 21. CRITÉRIOS DE ACEITAÇÃO

Antes de declarar o projeto concluído, verifique:

- [ ] O projeto abre e compila.
- [ ] O APK foi realmente produzido.
- [ ] O APK pode ser instalado.
- [ ] A interface principal funciona.
- [ ] A navegação funciona.
- [ ] O usuário consegue acessar músicas locais.
- [ ] O usuário consegue reproduzir uma música.
- [ ] Os controles de reprodução funcionam.
- [ ] A reprodução em segundo plano funciona.
- [ ] A notificação de mídia funciona.
- [ ] As preferências permanecem salvas.
- [ ] O perfil local funciona.
- [ ] As playlists persistem.
- [ ] As estatísticas são calculadas com dados reais.
- [ ] A personalização de aparência funciona.
- [ ] É possível selecionar uma imagem de fundo.
- [ ] O gerenciamento de capas funciona.
- [ ] O gerenciamento de letras funciona.
- [ ] A pesquisa online possui estados de erro e carregamento.
- [ ] Os provedores respeitam suas respectivas políticas.
- [ ] O projeto possui testes.
- [ ] O workflow GitHub Actions está criado e validado.
- [ ] O README está atualizado.
- [ ] Não há chaves ou credenciais expostas.
- [ ] Não existem botões importantes sem implementação.
- [ ] O desempenho foi analisado.
- [ ] O resultado final foi revisado.

---

## 22. INSTRUÇÃO FINAL

Você tem autonomia para tomar decisões técnicas e criativas.

Não transforme este projeto em uma simples demonstração. Não entregue apenas um planejamento, arquivos de interface ou um protótipo.

**DESENVOLVA O APLICATIVO.**

Pesquise, planeje, distribua tarefas, implemente, teste, corrija e otimize.

Quando encontrar uma dificuldade, investigue e tente outra abordagem.

Quando identificar uma oportunidade de melhorar a experiência, considere implementá-la sem prejudicar o escopo principal.

Não acrescente complexidade sem justificativa.

Priorize qualidade, consistência, eficiência, manutenção e experiência de uso.

O produto final deve transmitir a sensação de um aplicativo musical real, completo e cuidadosamente desenvolvido.

**RESULTADO ESPERADO: UM APLICATIVO ANDROID AURALIS MUSIC FUNCIONAL, ACOMPANHADO DO CÓDIGO-FONTE, DOCUMENTAÇÃO, WORKFLOW DE BUILD E ARQUIVO APK INSTALÁVEL.**

Comece inspecionando o ambiente e o repositório. Em seguida, estabeleça seu plano e inicie a implementação imediatamente.
