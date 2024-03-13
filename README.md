<div align="center">
  <img src="https://user-images.githubusercontent.com/61476935/154176831-50b6f16a-2858-48a0-b8b7-59b1c8291837.png">
</div>
<br>
<img src="https://img.shields.io/static/v1?label=android&message=Mobile-Development&color=green&style=for-the-badge&logo=Android"/>

<!-- <p align="justify">O Android é um sistema operacional mobile, baseado em Linux, criado pela Google em 2009. Possuindo mais de dois bilhões de usuários e estando presente em mais de vinte e quatro mil modelos de dispositivos, desde smartphones e smartwatches a televisores e veículos, o sistema ganhou a alcunha de mais popular do mundo. O fato é que sua história se mistura com a histório de criação e adoção em massa dos smartphones, e por consequência, do desenvolvimento mobile.</p>

<p align="justify">Sendo o principal rival do IOS, e muitas vezes único, o sistema Android passou a ser adotado pela maior parte das empresas que desenvolvem aparelhos móveis. Empresas como Samsung, Motorola, Xiaomi e muitas outras adotaram o OS da Google a partir de sua entrada no mercado. Contudo, sua popularidade se dá muito graças a pirataria, resultado da sua já popular acessibilidade.</p>

<h1>Guia de Desenvolvimento</h1>

<p align="justify">Tendo apresentado seus números, é possível passar a pensar no apecto que supre tal montante: o desenvolvimento. O Android SDK faz parte ou impacta a vida da maior parte dos desenvolvedores mobile, sejam especialistas, generalistas ou criadores de aplicações híbridas, o que contabiliza mais de 70% da stack.</p>

<p align="justify">A documentação a seguir busca inicialmente introduzir os fundamentos do desenvolvimento de aplicativos Android, priorizando o desenvolvimento mobile, e, posteriormente, se aprofundar em especificidades.</p>

<h1>Fundamentos de uma Aplicação</h1>

Os aplicativos Android podem ser desenvolvidos usando as linguagens [Kotlin](https://github.com/VictorSantos12/Kotlin), [Java]() e C++. As ferramentas do Android SDK compilam seu código junto com quaisquer dados e arquivos de recursos em um APK ou Android App Bundle.

<p align="justify">Um package Android, que é um arquivo compactado com um sufixo .apk, contém o conteúdo de um aplicativo Android necessário em tempo de execução e é o arquivo que os dispositivos com tecnologia Android usam para instalar o aplicativo.</p>

<p align="justify">Um Android App Bundle, que pode ser identificado por um arquivo com o sufixo .aab, contém o conteúdo de um projeto de aplicativo Android, incluindo alguns metadados adicionais que não são necessários em tempo de execução. Um AAB é um formato de publicação e não pode ser instalado em dispositivos Android. Ele adia a geração e a assinatura do APK para um estágio posterior. Ao distribuir seu aplicativo por meio do Google Play, por exemplo, os servidores do Google Play geram APKs otimizados que contêm apenas os recursos e o código exigidos por um determinado dispositivo que está solicitando a instalação do aplicativo.</p>

<p align="justify">Cada aplicativo Android vive em sua própria sendBox, protegida pelos seguintes recursos de segurança:</p>

- O sistema operacional Android é um sistema Linux multiusuário no qual cada aplicativo é um usuário diferente.<br>

- Por padrão, o sistema atribui a cada aplicativo um ID de usuário Linux exclusivo (o ID é usado apenas pelo sistema e é desconhecido para o aplicativo). O sistema define permissões para todos os arquivos em um aplicativo para que apenas o ID do usuário atribuído a esse aplicativo possa acessá-los.<br>

- Cada processo tem sua própria máquina virtual (VM), portanto, o código de um aplicativo é executado isoladamente de outros aplicativos.<br>

- Por padrão, cada aplicativo é executado em seu próprio processo Linux. O sistema Android inicia o processo quando qualquer um dos componentes do aplicativo precisa ser executado e, em seguida, encerra o processo quando não é mais necessário ou quando o sistema deve recuperar memória para outros aplicativos.

Também cabe ressaltar que o sistema Android implementa o princípio de privilégio mínimo. Ou seja, cada aplicativo, por padrão, tem acesso apenas aos componentes necessários para fazer seu trabalho e nada mais. Isso cria um ambiente seguro no qual um aplicativo não pode acessar partes do sistema para as quais não tem permissão. No entanto, existem maneiras de um aplicativo compartilhar dados com outros aplicativos e de um aplicativo acessar os serviços do sistema:

- É possível fazer com que dois aplicativos compartilhem o mesmo ID de usuário do Linux e, nesse caso, eles podem acessar os arquivos um do outro. Para conservar os recursos do sistema, os aplicativos com o mesmo ID de usuário também podem ser executados no mesmo processo do Linux e compartilhar a mesma VM. Os aplicativos também devem ser assinados com o mesmo certificado.<br>

- Um aplicativo pode solicitar permissão para acessar dados do dispositivo, como localização, câmera e conexão Bluetooth. O usuário deve conceder explicitamente essas permissões.

Tais métodos serão mais bem abordados no decorrer da documentação.

<h1>Componentes</h1>

Os App Components são os blocos de construção essenciais de um aplicativo Android. Cada componente é um ponto de entrada pelo qual o sistema ou um usuário pode entrar em seu aplicativo. Há quatro tipos distintos de app components:

- Activities<br>
- Services<br>
- Broadcast receivers<br>
- Content providers

Cada component serve a um propósito distinto e possui um ciclo de vida distinto, o qual define como o mesmo é criado e destruído. Os tópicos a seguir descrevem cada um dos quatro em detalhes:

<h2>a) Activities:</h2> Uma <i>activity</i> é um fragmento da aplicação com qual o usuário pode interagir, a qual possui certa independência dentro da estrutura da aplicação. Por exemplo, um app como o Gmail possui uma atividade para listar novos emails, uma atividade que permite a leitura destes e outra que permite responde-los. Ou seja, as atividade trabalham para criar uma experiência coesa das funções de uma aplicação.

A maioria dos aplicativos contém várias telas, ou seja, várias atividades. Normalmente, uma atividade em um aplicativo é especificada como a <i>MainActivity</i>, sendo a tela inicial do aplicativo. Cada atividade pode então iniciar outra atividade para realizar ações distintas. Porém, diferentemente da sua contraparte desktop, mobile-apps nem sempre são inicializados de um mesmo ponto. Pelo contrário, a jornada do usuário normalmente se inicia de forma não determinada.

Retornando ao exemplo do Gmail App, pode se notar diferentes formas de inicializa-lo, sendo a mais direta delas através da sua MainActivity. Por outro lado, quando seu acesso está atrelado a outro app, a MainActivity não será necessariamente utilizada, sendo possível acessar especificamente a task de escrita e envio de e-mails.

Toda activity é subclasse da classe [Activity](https://developer.android.com/reference/android/app/Activity?authuser=1) foi desenvolvida para falicitar tais necessidades. Quando um aplicativo invoca outro, o que de fato é invocado é uma de suas atividades, não o aplicativo como um todo.

<h2>a) Stack</h2>

As atividades em um sistema Android são agrupadas seguindo o modelo de [Stacks](https://developer.android.com/guide/components/activities/tasks-and-back-stack?authuser=1), sendo posicionadas de acorde com sua ordem de abertura em uma <i>task</i>. Quando uma atividade é inicializada, ela é posicionada sobre a stack atual, passando a estar em execução; <img align="right" style="width: 400px;" src="https://user-images.githubusercontent.com/61476935/179646952-ac018b2e-97d3-417c-b36b-505bb55f49e4.png">
a atividade anterior sempre permanece abaixo na stack, compondo a <i>back stack</i>.

Uma atividade que faz parte da back stack não retorna ao primeiro plano até que a nova atividade seja encerrada. É possível que haja uma ou multiplas stacks visíveis em uma tela.

A tela inicial do dispositivo é o ponto de partida para a maioria das tasks. Quando um aplicativo é acessado, sua task (conjunto de atividades) fica em primeiro plano. Se não existir nenhuma task para o aplicativo (o aplicativo não foi usado recentemente), uma nova task será criada a partir da tela inicial do app.

As atividades na stack nunca são reorganizadas, apenas sofrem push quando acessadas, ou pop, quando retiradas da pilha caso uma interação do usuário com o Back button ou gesture seja detectada. Quando uma atividade é encerrada, sua antecedente se torna ativa, e o estado anterior da interface é retomado.

<h2>b) Activity Lifecycle</h2>

Uma atividade é implementada como uma subclasse da [Activity](https://developer.android.com/reference/android/app/Activity?authuser=1) class, e como quase todas as atividades interagem com o usuário, a classe Activity se encarrega de criar métodos para lidar com as diferentes formas de interação e seus resultados. Tais métodos definem o ciclo de vida de uma atividade:

    public class Activity extends ApplicationContext {

        protected void onCreate(Bundle savedInstanceState);

        protected void onStart();

        protected void onRestart();

        protected void onResume();

        protected void onPause();

        protected void onStop();

        protected void onDestroy();
    }

O ciclo de vida de uma atividade é essencialmente composto por quatro estados:

<h3>Active</h3>

Caso uma atividade esteja em primeiro plano (na posição mais acima da stack atual), seu estado é definido como <i>active</i> ou <i>running</i>, sendo esta a atividade com a qual o usuário está interegindo.

<img align="left" style="width: 250px;" src="https://user-images.githubusercontent.com/61476935/179614835-f18ee0ca-a3a6-43f8-a02e-58e7c1f91f56.png">

<h3>Visible</h3>

Caso uma atividade tenha perdido o foco, mas ainda esteja sendo apresentada ao usuário, seu estado é definido como <i>visible</i>. Alguns exemplos deste caso são: quando uma nova atividade cujo espaço não equivalha a totalidade da tela é acessada (dialog ou popUp); quando uma outra atividade se posiciona acima na stack; ou a atividade em si não é focalizável na janela atual. Esse estado mantém a atividade completamente ativa, mantendo todas as informações anexadas ao gerenciador de janelas.

<h3>Stopped</h3>

Se uma atividade for completamente obscurecida por outra, o estado desta passa a ser <i>stopped</i> ou <i>hidden</i>. Ela ainda retém todas as informações, no entanto, não é mais visível, logo, sua janela fica oculta e geralmente será eliminada pelo sistema quando a memória for necessária em outro lugar

<h3>Destroyed</h3>

O sistema pode descartar uma atividade da memória pedindo que ela termine ou simplesmente eliminando seu processo, a tornando <i>destroyed</i>. Quando for exibida novamente para o usuário, ela deve ser completamente reiniciada, retomando o estado anterior.

O diagrama a seguir ilustra como o ciclo de vida de uma atividade deve se comportar:

<div align="center">
  <img src="https://user-images.githubusercontent.com/61476935/179652997-28a860c2-f16a-4580-8e76-0447b53348f1.png">
</div>

Dentro do ciclo de vida de uma tela, é importante ficar atento as inicializações e finalizações de cada periodo:

- O ciclo completo acontece entre a primeira chamada do método onCreate() e a primeira chamada do onDestroy(). Uma atividade fará toda a configuração do estado "global" em onCreate(), liberando todos os recursos restantes em onDestroy().

- O tempo de vida visível de uma atividade acontece entre a chamada do método onStart() e uma chamada correspondente ao método onStop(). Durante este periodo o usuário pode ver a atividade na tela, embora não esteja em primeiro plano. Ambos os métodos podem ser chamados várias vezes à medida que a atividade se torna visível e oculta para o usuário.

- O tempo de vida em primeiro plano de uma atividade acontece entre a chamada do método onResume() e uma chamada correspondente ao método onPause(). Durante este periodo a atividade fica visível, ativa e interagindo com o usuário. Uma atividade pode frequentemente ficar entre os estados resumed e paused - por exemplo, quando o dispositivo entra em suspensão, quando um resultado de atividade é entregue, quando uma nova intenção é entregue - portanto, o código nesses métodos deve ser bastante leve.

<h2>b) Services</h2>

<h2>c) Broadcast receivers</h2>

<h2>d) Content providers</h2>

<h1>The manifest file</h1>

<p align="justify">A</p> -->

# 1. O Sistema Operacional

<p align="justify">
Compreender o Android como sistema operacional perpassa o entendimento de como este é mantido e quem está por trás de seu desenvolvimento e gerenciamento. A princípio, o Android é um produto desenvolvido pelo grupo de empresas conhecido como Open Handset Alliance (OHA), liderado pela Google. O produto engloba uma série de subprojetos de software, gerido pelo Android Open Source Project (AOSP), por meio do Programa de compatibilidade do Android. Tal programa permite que qualquer pessoa que contribua para o desenvolvimento do produto faça parte de um ecossistema compartilhado.

Desse modo o Android é intencional e explicitamente uma iniciativa de código aberto, que pode atender qualquer pessoa para qualquer finalidade, desde que legítima.

</p>

# 2. Visão Geral da Arquitetura

<p align="justify">
O Android é um sistema operacional baseado no núcleo Linux, ou seja, na base de sua arquitetura está um Kernel Linux. Tal arquitetura decorre da implementação de uma plataforma dedicada, também open source, chamada Android Open System Platform (AOSP), cuja stack de software contém as seguintes camadas:
</p>

![img](https://source.android.com/static/images/android_stack.png?hl=pt-br)

Sobre cada camada, cabe destacar:

### 1. Linux Kernel

<p align="justify">
O kernel é a parte central de qualquer sistema operacional e se comunica com o hardware subjacente em um dispositivo, sendo nesse caso um Kernel Linux, comum a sistemas operacionais baseados em Unix.
</p>

### 2. Daemons e Bibliotecas Nativas

<p align="justify">
No Android, um daemon é um processo contínuo em segundo plano que executa várias tarefas no nível do sistema, dentre elas a execução de builds e a inicialização de bibliotecas. As bibliotecas nativas, por sua vez, têm por função interagir diretamente com o kernel ou outras interfaces e não dependem de uma implementação HAL baseada no espaço do usuário.
</p>

### 3. HAL

<p align="justify">
Um HAL é uma camada de abstração com uma interface padrão para os fornecedores de hardware implementarem. Sua principal função é expor as capacidades do hardware do dispositivo para APIs de alto nível, permitindo implementar funcionalidades sem afetá-las ou modificá-las.
</p>

### 4. Android Runtime:

<p align="justify">
O android runtime é um ambiente de tempo de execução Java fornecido pelo AOSP, que realiza a tradução do bytecode do aplicativo em instruções específicas do processador que são executadas pelo ambiente de tempo de execução do dispositivo.
</p>

### 5. Serviços do Sistema

<p align="justify">
Os serviços do sistema são componentes modulares e focados, como system_server, SurfaceFlinger e MediaService. A funcionalidade exposta pela API da estrutura do Android se comunica com os serviços do sistema para acessar o hardware subjacente.
</p>

### 6. Android Framework

<p align="justify">
O android framework é um grupo de classes Java, interfaces e outros códigos pré-compilados sobre os quais os aplicativos são construídos. Partes da estrutura são acessíveis publicamente por meio do uso da API do Android. Outras partes da estrutura estão disponíveis apenas para OEMs por meio do uso das APIs do sistema. O código da estrutura do Android é executado dentro do processo de um aplicativo.
</p>

### 7. API do Android

<p align="justify">
A API do Android é a API disponível publicamente para desenvolvedores de aplicativos Android terceirizados.
</p>

### 8. API do Sistema

<p align="justify">
A API do sistema representa as APIs do Android disponíveis apenas para parceiros e OEMs (Original Equipment Manufacturer) para inclusão em aplicativos agrupados. Essas APIs são marcadas como @SystemApi no código-fonte.
</p>

### 9. Aplicativo

<p align="justify">
Acima das demais camadas se encontram os aplicativos, dentre os quais destacam-se:
</p>

### Aplicativo Android

<p align="justify">
 Um aplicativo criado exclusivamente usando a API do Android. A Google Play Store é amplamente usada para encontrar e baixar aplicativos Android, embora existam muitas outras alternativas. Em alguns casos, um fabricante de dispositivos pode querer pré-instalar um aplicativo Android para dar suporte à funcionalidade principal do dispositivo.
</p>

### Aplicativo Privilegiado

<p align="justify">
Um aplicativo criado usando uma combinação das APIs do Android e do sistema. Esses aplicativos devem ser pré-instalados como aplicativos privilegiados em um dispositivo.
</p>

### Aplicativo do Fabricante do Dispositivo

<p align="justify">
Um aplicativo criado usando uma combinação de API do Android, API do sistema e acesso direto à implementação da estrutura do Android. Como um fabricante de dispositivos pode acessar diretamente APIs instáveis ​​na estrutura do Android, esses aplicativos devem ser pré-instalados no dispositivo e podem ser atualizados somente quando o software do sistema do dispositivo for atualizado.
</p>

# 3. Guia do Desenvolvedor

A

## 3.1. Fundamentos de uma Aplicação

<p align="justify">
Os aplicativos Android podem ser desenvolvidos usando as linguagens Kotlin, Java e C++. As ferramentas do Android SDK compilam seu código junto com quaisquer dados e arquivos de recursos em um APK ou Android App Bundle.
</p>

<p align="justify">
Um package Android, que é um arquivo compactado com um sufixo .apk, contém o conteúdo de um aplicativo Android necessário em tempo de execução e é o arquivo que os dispositivos com tecnologia Android usam para instalar um aplicativo.
</p>

<p align="justify">
Um Android App Bundle, que pode ser identificado por um arquivo com o sufixo .aab, contém o conteúdo de um projeto de aplicativo Android, incluindo alguns metadados adicionais que não são necessários em tempo de execução. Um AAB é um formato de publicação e não pode ser instalado em dispositivos Android. Ele adia a geração e a assinatura do APK para um estágio posterior. Ao distribuir seu aplicativo por meio do Google Play, por exemplo, os servidores do Google Play geram APKs otimizados que contêm apenas os recursos e o código exigidos por um determinado dispositivo que está solicitando a instalação do aplicativo.
</p>

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
</p>

Tais métodos serão mais bem abordados no decorrer da documentação.

## 3.2 App Components

<p align="justify">
Os App Components são os blocos de construção essenciais de um aplicativo Android. Cada componente é um ponto de entrada pelo qual o sistema ou um usuário pode entrar em seu aplicativo. Há quatro tipos distintos de app components:
</p>

### Activities

<p align="justify">
Uma activity é um fragmento da aplicação com qual o usuário pode interagir, a qual possui certa independência dentro da estrutura da aplicação. Por exemplo, um app como o Gmail possui uma atividade para listar novos emails, uma atividade que permite a leitura destes e outra que permite respondê-los. Ou seja, as atividades trabalham para criar uma experiência coesa das funções de uma aplicação. A maioria dos aplicativos contém várias telas, ou seja, várias atividades. Normalmente, uma atividade em um aplicativo é especificada como a MainActivity, sendo a tela inicial do aplicativo. Cada atividade pode então iniciar outra atividade para realizar ações distintas. Porém, diferentemente da sua contraparte desktop, mobile-apps nem sempre são inicializados de um mesmo ponto. Pelo contrário, a jornada do usuário normalmente se inicia de forma não determinada.

Retornando ao exemplo do Gmail App, pode se notar diferentes formas de inicializá-lo, sendo a mais direta delas através da sua MainActivity. Por outro lado, quando seu acesso está atrelado a outro app, a MainActivity não será necessariamente utilizada, sendo possível acessar especificamente a task de escrita e envio de e-mails.

</p>

Toda activity é subclasse da classe Activity, a qual será abordada em detalhes mais adiante.

### Services

<p align="justify">
Um service é um entry point capaz de executar um recurso de uma aplicação em segundo plano enquanto o usuário não interage com ela, ou de disponibilizar estes recursos a outras aplicações.
</p>

<p align="justify">
Serviços podem ser tanto iniciados (restritos aos próprios processos) quanto vinculados (se estendem a processos de outros apps), de modo que se tornam úteis para todos os tipos de conceitos de sistemas high-level.
</p>

Todo service é subclasse da classe Service, a qual será abordada em detalhes mais adiante

### Broadcast receivers

<p align="justify">
Um broadcast receiver é um componente de comunicação tanto entre usuário e sistema, quanto entre aplicações. Sua função é basicamente disparar e transmitir eventos a quem interessar, independentemente se o app destino esteja ou não em uso.
</p>

<p align="justify">
Um app android utiliza um BroadcastReceiver tanto quando gera notificações para o usuário na barra de status, quanto quando sinaliza a outros apps que informações nele geradas estão disponíveis para uso (downloads, imagens, etc), o que ocorre sem que o usuário tome conhecimento.
</p>

Todo broadcast receiver é subclasse da classe BroadcastReceiver, a qual será abordada em detalhes mais adiante

### Content providers

<p align="justify">
Um content provider gerencia um conjunto compartilhado de dados do app que você pode armazenar no sistema de arquivos, em um banco de dados SQLite, na Web ou em qualquer outro local de armazenamento permanente que seu app possa acessar. Por meio do provedor de conteúdo, outros apps podem consultar ou modificar os dados, se este assim permitir.
</p>

<p align="justify">
Por exemplo, o sistema Android oferece um provedor de conteúdo que gerencia os dados de contato do usuário. Qualquer app com as permissões adequadas pode consultar o provedor de conteúdo, por exemplo, usando ContactsContract.Data, para ler e gravar informações sobre uma pessoa específica.
</p>

Todo content provider é subclasse da classe ContentProvider, a qual será abordada em detalhes mais adiante.

## 3.3 O Arquivo Manifesto

<p align="justify">
Antes que o sistema Android possa iniciar um app component, é necessário torná-lo ciente de sua existência, o que se dá a partir da leitura prévia do arquivo manifesto, ou AndroidManifest.xml, presente na raiz do projeto. Desse modo, todos os componentes da aplicação serão declarados nele.
</p>

Além disso, o mesmo arquivo é incumbido de:

> [!NOTE]
> Useful information that users should know, even when skimming content.

- Identificar todas as permissões do usuário exigidas pelo app, como acesso à internet ou acesso a lista de contatos, arquivos, imagens, etc;
- Declarar o API level mínimo exigido pelo aplicação, baseando-se em quais APIs o app utiliza;
- Declarar as features de hardware e software requeridos pelo app, como câmera, serviços de Bluetooth ou tela multitoque;
- Declarar as bibliotecas de API as quais o app precisa ser vinculado (além das APIs do framework do Android), como a Biblioteca Google Maps.

O trecho a seguir descreve todos os elementos válidos no arquivo AndroidManifest.xml.

| [action]()               | Adiciona uma ação a um filtro de intents.                                                                                                                        |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <activity>               | Declara um componente da atividade.                                                                                                                              |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <activity-alias>         | Declara um alias para a atividade.                                                                                                                               |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <application>            | Declara o aplicativo.                                                                                                                                            |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <category>               | Adiciona um nome de categoria a um filtro de intents.                                                                                                            |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <compatible-screens>     | Especifica cada configuração de tela com que o aplicativo é compatível.                                                                                          |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <data>                   | Adiciona uma especificação de dados a um filtro de intents.                                                                                                      |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <grant-uri-permission>   | Especifica os subconjuntos de dados do app aos quais o provedor de conteúdo pai tem permissão de acesso.                                                         |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <instrumentation>        | InstrumentationDeclara uma classe que permite monitorar a interação de um aplicativo com o sistema.                                                              |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <intent-filter>          | Especifica os tipos de intents aos quais uma atividade, um serviço ou um broadcast receiver pode responder.                                                      |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <manifest>               | O elemento raiz do arquivo AndroidManifest.xml.                                                                                                                  |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <meta-data>              | Um par de nome-valor para um item de dados extra e arbitrários que pode ser fornecido ao componente pai.                                                         |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <path-permission>        | Define o caminho e as permissões necessárias para um subconjunto específico de dados em um provedor de conteúdo.                                                 |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <permission>             | Declara uma permissão de segurança que pode ser usada para limitar o acesso a componentes ou recursos específicos deste ou de outros aplicativos.                |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <permission-group>       | Declara um nome para um agrupamento lógico de permissões relacionadas.                                                                                           |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <permission-tree>        | Declara o nome base de uma árvore de permissões.                                                                                                                 |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <provider>               | Declara o componente de um provedor de conteúdo.                                                                                                                 |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <queries>                | Declara o conjunto de outros apps que seu app pretende acessar. Saiba mais no guia sobre filtragem de visibilidade de pacotes.                                   |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <receiver>               | Declara um componente do broadcast receiver.                                                                                                                     |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <service>                | Declara um componente de serviço.                                                                                                                                |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <supports-gl-texture>    | Declara um único formato de compactação de textura GL que pode ser usado com o app.                                                                              |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <supports-screens>       | Declara os tamanhos de tela com suporte do app e ativa o modo de compatibilidade da tela para telas maiores do que as com suporte.                               |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <uses-configuration>     | Indica os recursos de entrada específicos exigidos pelo aplicativo.                                                                                              |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <uses-feature>           | Declara um único recurso de hardware ou software usado pelo aplicativo.                                                                                          |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <uses-library>           | Especifica uma biblioteca compartilhada que precisa ser vinculada ao aplicativo.                                                                                 |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <uses-native-library>    | Especifica uma biblioteca compartilhada nativa oferecida pelo fornecedor que precisa ser vinculada ao app.                                                       |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <uses-permission>        | Especifica uma permissão do sistema que precisa ser concedida pelo usuário para que o app funcione corretamente.                                                 |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <uses-permission-sdk-23> | Especifica que um app quer uma permissão específica, mas somente se o app estiver instalado em um dispositivo com Android 6.0 (nível 23 da API) ou mais recente. |
| ------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <uses-sdk>               | Permite expressar a compatibilidade de um aplicativo com uma ou mais versões da plataforma Android usando um número inteiro de nível de API.                     |

| Attempt | #1  |
| ------- | --- |
| Seconds | 301 |

> <action> Adiciona uma ação a um filtro de intents.

## Gradle

A

## Arquitetura

A
