![Android](./assets/154176831-50b6f16a-2858-48a0-b8b7-59b1c8291837.png "Now in Android")

<img src="https://img.shields.io/static/v1?label=android&message=Mobile-Development&color=green&style=for-the-badge&logo=Android"/>

<!-- <p align="justify">O Android é um sistema operacional mobile, baseado em Linux, criado pela Google em 2009. Possuindo mais de dois bilhões de usuários e estando presente em mais de vinte e quatro mil modelos de dispositivos, desde smartphones e smartwatches a televisores e veículos, o sistema ganhou a alcunha de mais popular do mundo. O fato é que sua história se mistura com a histório de criação e adoção em massa dos smartphones, e por consequência, do desenvolvimento mobile.</p>

<p align="justify">Sendo o principal rival do IOS, e muitas vezes único, o sistema Android passou a ser adotado pela maior parte das empresas que desenvolvem aparelhos móveis. Empresas como Samsung, Motorola, Xiaomi e muitas outras adotaram o OS da Google a partir de sua entrada no mercado. Contudo, sua popularidade se dá muito graças a pirataria, resultado da sua já popular acessibilidade.</p>

<h1>Guia de Desenvolvimento</h1>

<p align="justify">Tendo apresentado seus números, é possível passar a pensar no apecto que supre tal montante: o desenvolvimento. O Android SDK faz parte ou impacta a vida da maior parte dos desenvolvedores mobile, sejam especialistas, generalistas ou criadores de aplicações híbridas, o que contabiliza mais de 70% da stack.</p>

<p align="justify">A documentação a seguir busca inicialmente introduzir os fundamentos do desenvolvimento de aplicativos Android, priorizando o desenvolvimento mobile, e, posteriormente, se aprofundar em especificidades.</p>



# 1. O Sistema Operacional

Compreender o Android como sistema operacional perpassa o entendimento de como este é mantido e quem está por trás de seu desenvolvimento e gerenciamento. A princípio, o Android é um produto desenvolvido pelo grupo de empresas conhecido como Open Handset Alliance (OHA), liderado pela Google. O produto engloba uma série de subprojetos de software, gerido pelo Android Open Source Project (AOSP), por meio do Programa de compatibilidade do Android. Tal programa permite que qualquer pessoa que contribua para o desenvolvimento do produto faça parte de um ecossistema compartilhado.

Desse modo o Android é intencional e explicitamente uma iniciativa de código aberto, que pode atender qualquer pessoa para qualquer finalidade, desde que legítima.

# 2. Visão Geral da Arquitetura

O Android é um sistema operacional baseado no núcleo Linux, ou seja, na base de sua arquitetura está um Kernel Linux. Tal arquitetura decorre da implementação de uma plataforma dedicada, também open source, chamada Android Open System Platform (AOSP), cuja stack de software contém as seguintes camadas:

<!-- ![img](https://source.android.com/static/images/android_stack.png?hl=pt-br)

Sobre cada camada, cabe destacar:

### 1. Linux Kernel

O kernel é a parte central de qualquer sistema operacional e se comunica com o hardware subjacente em um dispositivo, sendo nesse caso um Kernel Linux, comum a sistemas operacionais baseados em Unix.

### 2. Daemons e Bibliotecas Nativas

No Android, um daemon é um processo contínuo em segundo plano que executa várias tarefas no nível do sistema, dentre elas a execução de builds e a inicialização de bibliotecas. As bibliotecas nativas, por sua vez, têm por função interagir diretamente com o kernel ou outras interfaces e não dependem de uma implementação HAL baseada no espaço do usuário.

### 3. HAL

Um HAL é uma camada de abstração com uma interface padrão para os fornecedores de hardware implementarem. Sua principal função é expor as capacidades do hardware do dispositivo para APIs de alto nível, permitindo implementar funcionalidades sem afetá-las ou modificá-las.

### 4. Android Runtime:

O android runtime é um ambiente de tempo de execução Java fornecido pelo AOSP, que realiza a tradução do bytecode do aplicativo em instruções específicas do processador que são executadas pelo ambiente de tempo de execução do dispositivo.

### 5. Serviços do Sistema

Os serviços do sistema são componentes modulares e focados, como system_server, SurfaceFlinger e MediaService. A funcionalidade exposta pela API da estrutura do Android se comunica com os serviços do sistema para acessar o hardware subjacente.

### 6. Android Framework

O android framework é um grupo de classes Java, interfaces e outros códigos pré-compilados sobre os quais os aplicativos são construídos. Partes da estrutura são acessíveis publicamente por meio do uso da API do Android. Outras partes da estrutura estão disponíveis apenas para OEMs por meio do uso das APIs do sistema. O código da estrutura do Android é executado dentro do processo de um aplicativo.

### 7. API do Android

A API do Android é a API disponível publicamente para desenvolvedores de aplicativos Android terceirizados.

### 8. API do Sistema

A API do sistema representa as APIs do Android disponíveis apenas para parceiros e OEMs (Original Equipment Manufacturer) para inclusão em aplicativos agrupados. Essas APIs são marcadas como @SystemApi no código-fonte.

### 9. Aplicativo

Acima das demais camadas se encontram os aplicativos, dentre os quais destacam-se:

### Aplicativo Android

Um aplicativo criado exclusivamente usando a API do Android. A Google Play Store é amplamente usada para encontrar e baixar aplicativos Android, embora existam muitas outras alternativas. Em alguns casos, um fabricante de dispositivos pode querer pré-instalar um aplicativo Android para dar suporte à funcionalidade principal do dispositivo.

### Aplicativo Privilegiado

Um aplicativo criado usando uma combinação das APIs do Android e do sistema. Esses aplicativos devem ser pré-instalados como aplicativos privilegiados em um dispositivo.

### Aplicativo do Fabricante do Dispositivo

Um aplicativo criado usando uma combinação de API do Android, API do sistema e acesso direto à implementação da estrutura do Android. Como um fabricante de dispositivos pode acessar diretamente APIs instáveis ​​na estrutura do Android, esses aplicativos devem ser pré-instalados no dispositivo e podem ser atualizados somente quando o software do sistema do dispositivo for atualizado. -->

# 3. Guia do Desenvolvedor

A

## 3.1. Fundamentos de uma Aplicação

<!-- Os aplicativos Android podem ser desenvolvidos usando as linguagens Kotlin, Java e C++. As ferramentas do Android SDK compilam seu código junto com quaisquer dados e arquivos de recursos em um APK ou Android App Bundle.

Um package Android, que é um arquivo compactado com um sufixo .apk, contém o conteúdo de um aplicativo Android necessário em tempo de execução e é o arquivo que os dispositivos com tecnologia Android usam para instalar um aplicativo.

Um Android App Bundle, que pode ser identificado por um arquivo com o sufixo .aab, contém o conteúdo de um projeto de aplicativo Android, incluindo alguns metadados adicionais que não são necessários em tempo de execução. Um AAB é um formato de publicação e não pode ser instalado em dispositivos Android. Ele adia a geração e a assinatura do APK para um estágio posterior. Ao distribuir seu aplicativo por meio do Google Play, por exemplo, os servidores do Google Play geram APKs otimizados que contêm apenas os recursos e o código exigidos por um determinado dispositivo que está solicitando a instalação do aplicativo.

Cada aplicativo Android vive em sua própria sandBox, protegida pelos seguintes recursos de segurança:

- O sistema operacional Android é um sistema Linux multiusuário no qual cada aplicativo é um usuário diferente.

- Por padrão, o sistema atribui a cada aplicativo um ID de usuário Linux exclusivo (o ID é usado apenas pelo sistema e é desconhecido para o aplicativo). O sistema define permissões para todos os arquivos em um aplicativo para que apenas o ID do usuário atribuído a esse aplicativo possa acessá-los.

- Cada processo tem sua própria máquina virtual (VM), portanto, o código de um aplicativo é executado isoladamente de outros aplicativos.

- Por padrão, cada aplicativo é executado em seu próprio processo Linux. O sistema Android inicia o processo quando qualquer um dos componentes do aplicativo precisa ser executado e, em seguida, encerra o processo quando não é mais necessário ou quando o sistema deve recuperar memória para outros aplicativos.

<p align="justify">
Também cabe ressaltar que o sistema Android implementa o princípio de privilégio mínimo. Ou seja, cada aplicativo, por padrão, tem acesso apenas aos componentes necessários para fazer seu trabalho e nada mais. Isso cria um ambiente seguro no qual um aplicativo não pode acessar partes do sistema para as quais não tem permissão. No entanto, existem maneiras de um aplicativo compartilhar dados com outros aplicativos e de um aplicativo acessar os serviços do sistema:
</p>

<p align="justify">
É possível fazer com que dois aplicativos compartilhem o mesmo ID de usuário do Linux e, nesse caso, eles podem acessar os arquivos um do outro. Para conservar os recursos do sistema, os aplicativos com o mesmo ID de usuário também podem ser executados no mesmo processo do Linux e compartilhar a mesma VM. Os aplicativos também devem ser assinados com o mesmo certificado.
</p>

<p align="justify">
Um aplicativo pode solicitar permissão para acessar dados do dispositivo, como localização, câmera e conexão Bluetooth. O usuário deve conceder explicitamente essas permissões.
</p> -->

<!-- Tais métodos serão mais bem abordados no decorrer da documentação. -->

<!-- ## 3.2. App Components

Os App Components são os blocos de construção essenciais de um aplicativo Android. Cada componente é um ponto de entrada pelo qual o sistema ou um usuário pode entrar em seu aplicativo. Há quatro tipos distintos de app components:

### 3.2.1. Activities

Uma activity é um fragmento da aplicação com qual o usuário pode interagir, a qual possui certa independência dentro da estrutura da aplicação. Por exemplo, um app como o Gmail possui uma atividade para listar novos emails, uma atividade que permite a leitura destes e outra que permite respondê-los. Ou seja, as atividades trabalham para criar uma experiência coesa das funções de uma aplicação. A maioria dos aplicativos contém várias telas, ou seja, várias atividades. Normalmente, uma atividade em um aplicativo é especificada como a MainActivity, sendo a tela inicial do aplicativo. Cada atividade pode então iniciar outra atividade para realizar ações distintas. Porém, diferentemente da sua contraparte desktop, mobile-apps nem sempre são inicializados de um mesmo ponto. Pelo contrário, a jornada do usuário normalmente se inicia de forma não determinada.

Retornando ao exemplo do Gmail App, pode se notar diferentes formas de inicializá-lo, sendo a mais direta delas através da sua MainActivity. Por outro lado, quando seu acesso está atrelado a outro app, a MainActivity não será necessariamente utilizada, sendo possível acessar especificamente a task de escrita e envio de e-mails.

Toda activity é subclasse da classe Activity, a qual será abordada em detalhes mais adiante.

### 3.2.2. Services

Um service é um entry point capaz de executar um recurso de uma aplicação em segundo plano enquanto o usuário não interage com ela, ou de disponibilizar estes recursos a outras aplicações.

Serviços podem ser tanto iniciados (restritos aos próprios processos) quanto vinculados (se estendem a processos de outros apps), de modo que se tornam úteis para todos os tipos de conceitos de sistemas high-level.

Todo service é subclasse da classe Service, a qual será abordada em detalhes mais adiante

### 3.2.3. Broadcast receivers

Um broadcast receiver é um componente de comunicação tanto entre usuário e sistema, quanto entre aplicações. Sua função é basicamente disparar e transmitir eventos a quem interessar, independentemente se o app destino esteja ou não em uso.

Um app android utiliza um BroadcastReceiver tanto quando gera notificações para o usuário na barra de status, quanto quando sinaliza a outros apps que informações nele geradas estão disponíveis para uso (downloads, imagens, etc), o que ocorre sem que o usuário tome conhecimento.

Todo broadcast receiver é subclasse da classe BroadcastReceiver, a qual será abordada em detalhes mais adiante

### 3.2.4. Content providers

Um content provider gerencia um conjunto compartilhado de dados do app que você pode armazenar no sistema de arquivos, em um banco de dados SQLite, na Web ou em qualquer outro local de armazenamento permanente que seu app possa acessar. Por meio do provedor de conteúdo, outros apps podem consultar ou modificar os dados, se este assim permitir.

Por exemplo, o sistema Android oferece um provedor de conteúdo que gerencia os dados de contato do usuário. Qualquer app com as permissões adequadas pode consultar o provedor de conteúdo, por exemplo, usando ContactsContract.Data, para ler e gravar informações sobre uma pessoa específica.

Todo content provider é subclasse da classe ContentProvider, a qual será abordada em detalhes mais adiante. -->

## 3.3. O Arquivo Manifesto

Antes que o sistema Android possa iniciar um app component, é necessário torná-lo ciente de sua existência, o que se dá a partir da leitura prévia do arquivo manifesto, ou AndroidManifest.xml, presente na raiz do projeto. Desse modo, todos os componentes da aplicação serão declarados nele.

> [!NOTE]
> Além disso, o mesmo arquivo é incumbido de:
>
> - Identificar todas as permissões do usuário exigidas pelo app, como acesso à internet ou acesso a lista de contatos, arquivos, imagens, etc;
> - Declarar o API level mínimo exigido pelo aplicação, baseando-se em quais APIs o app utiliza;
> - Declarar as features de hardware e software requeridos pelo app, como câmera, serviços de Bluetooth ou tela multitoque;
> - Declarar as bibliotecas de API as quais o app precisa ser vinculado (além das APIs do framework do Android), como a Biblioteca Google Maps.

O trecho a seguir descreve todos os elementos válidos no arquivo AndroidManifest.xml:

|                                                       Elemento                                                        | Descrição                                                                                                                                                        |
| :-------------------------------------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|                 [action](https://developer.android.com/guide/topics/manifest/action-element?hl=pt-br)                 | Adiciona uma ação a um filtro de intents.                                                                                                                        |
|               [activity](https://developer.android.com/guide/topics/manifest/activity-element?hl=pt-br)               | Declara um componente da atividade.                                                                                                                              |
|         [activity-alias](https://developer.android.com/guide/topics/manifest/activity-alias-element?hl=pt-br)         | Declara um alias para a atividade.                                                                                                                               |
|            [application](https://developer.android.com/guide/topics/manifest/application-element?hl=pt-br)            | Declara o aplicativo.                                                                                                                                            |
|               [category](https://developer.android.com/guide/topics/manifest/category-element?hl=pt-br)               | Adiciona um nome de categoria a um filtro de intents.                                                                                                            |
|     [compatible-screens](https://developer.android.com/guide/topics/manifest/compatible-screens-element?hl=pt-br)     | Especifica cada configuração de tela com que o aplicativo é compatível.                                                                                          |
|                   [data](https://developer.android.com/guide/topics/manifest/data-element?hl=pt-br)                   | Adiciona uma especificação de dados a um filtro de intents.                                                                                                      |
|   [grant-uri-permission](https://developer.android.com/guide/topics/manifest/grant-uri-permission-element?hl=pt-br)   | Especifica os subconjuntos de dados do app aos quais o provedor de conteúdo pai tem permissão de acesso.                                                         |
|        [instrumentation](https://developer.android.com/guide/topics/manifest/instrumentation-element?hl=pt-br)        | InstrumentationDeclara uma classe que permite monitorar a interação de um aplicativo com o sistema.                                                              |
|          [intent-filter](https://developer.android.com/guide/topics/manifest/intent-filter-element?hl=pt-br)          | Especifica os tipos de intents aos quais uma atividade, um serviço ou um broadcast receiver pode responder.                                                      |
|               [manifest](https://developer.android.com/guide/topics/manifest/manifest-element?hl=pt-br)               | O elemento raiz do arquivo AndroidManifest.xml.                                                                                                                  |
|              [meta-data](https://developer.android.com/guide/topics/manifest/meta-data-element?hl=pt-br)              | Um par de nome-valor para um item de dados extra e arbitrários que pode ser fornecido ao componente pai.                                                         |
|        [path-permission](https://developer.android.com/guide/topics/manifest/path-permission-element?hl=pt-br)        | Define o caminho e as permissões necessárias para um subconjunto específico de dados em um provedor de conteúdo.                                                 |
|             [permission](https://developer.android.com/guide/topics/manifest/permission-element?hl=pt-br)             | Declara uma permissão de segurança que pode ser usada para limitar o acesso a componentes ou recursos específicos deste ou de outros aplicativos.                |
|       [permission-group](https://developer.android.com/guide/topics/manifest/permission-group-element?hl=pt-br)       | Declara um nome para um agrupamento lógico de permissões relacionadas.                                                                                           |
|        [permission-tree](https://developer.android.com/guide/topics/manifest/permission-tree-element?hl=pt-br)        | Declara o nome base de uma árvore de permissões.                                                                                                                 |
|               [provider](https://developer.android.com/guide/topics/manifest/provider-element?hl=pt-br)               | Declara o componente de um provedor de conteúdo.                                                                                                                 |
|                [queries](https://developer.android.com/guide/topics/manifest/queries-element?hl=pt-br)                | Declara o conjunto de outros apps que seu app pretende acessar. Saiba mais no guia sobre filtragem de visibilidade de pacotes.                                   |
|               [receiver](https://developer.android.com/guide/topics/manifest/receiver-element?hl=pt-br)               | Declara um componente do broadcast receiver.                                                                                                                     |
|                [service](https://developer.android.com/guide/topics/manifest/service-element?hl=pt-br)                | Declara um componente de serviço.                                                                                                                                |
|    [supports-gl-texture](https://developer.android.com/guide/topics/manifest/supports-gl-texture-element?hl=pt-br)    | Declara um único formato de compactação de textura GL que pode ser usado com o app.                                                                              |
|       [supports-screens](https://developer.android.com/guide/topics/manifest/supports-screens-element?hl=pt-br)       | Declara os tamanhos de tela com suporte do app e ativa o modo de compatibilidade da tela para telas maiores do que as com suporte.                               |
|     [uses-configuration](https://developer.android.com/guide/topics/manifest/uses-configuration-element?hl=pt-br)     | Indica os recursos de entrada específicos exigidos pelo aplicativo.                                                                                              |
|           [uses-feature](https://developer.android.com/guide/topics/manifest/uses-feature-element?hl=pt-br)           | Declara um único recurso de hardware ou software usado pelo aplicativo.                                                                                          |
|           [uses-library](https://developer.android.com/guide/topics/manifest/uses-library-element?hl=pt-br)           | Especifica uma biblioteca compartilhada que precisa ser vinculada ao aplicativo.                                                                                 |
|    [uses-native-library](https://developer.android.com/guide/topics/manifest/uses-native-library-element?hl=pt-br)    | Especifica uma biblioteca compartilhada nativa oferecida pelo fornecedor que precisa ser vinculada ao app.                                                       |
|        [uses-permission](https://developer.android.com/guide/topics/manifest/uses-permission-element?hl=pt-br)        | Especifica uma permissão do sistema que precisa ser concedida pelo usuário para que o app funcione corretamente.                                                 |
| [uses-permission-sdk-23](https://developer.android.com/guide/topics/manifest/uses-permission-sdk-23-element?hl=pt-br) | Especifica que um app quer uma permissão específica, mas somente se o app estiver instalado em um dispositivo com Android 6.0 (nível 23 da API) ou mais recente. |
|               [uses-sdk](https://developer.android.com/guide/topics/manifest/uses-sdk-element?hl=pt-br)               | Permite expressar a compatibilidade de um aplicativo com uma ou mais versões da plataforma Android usando um número inteiro de nível de API.                     |

## 3.4 Arquitetura

A

## 3.5. Gradle

A
