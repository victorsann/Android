<div align="center">
  <img src="https://user-images.githubusercontent.com/61476935/154176831-50b6f16a-2858-48a0-b8b7-59b1c8291837.png">
</div>
<br>
<img src="https://img.shields.io/static/v1?label=android&message=Mobile-Development&color=green&style=for-the-badge&logo=Android"/>

O Android é um sistema operacional mobile, baseado em Linux, criado pela Google em 2009. Possuindo mais de dois bilhões de usuários e estando presente em mais de vinte e quatro mil modelos de dispositivos, desde smartphones e smartwatches a televisores e veículos, o sistema ganhou a alcunha de mais popular do mundo. O fato é que sua história se mistura com a histório de criação e adoção em massa dos smartphones, e por consequência, do desenvolvimento mobile.

Sendo o principal rival do IOS, e muitas vezes único, o sistema Android passou a ser adotado pela maior parte das empresas que desenvolvem aparelhos móveis. Empresas como Samsung, Motorola, Xiaomi e muitas outras adotaram o OS da Google a partir de sua entrada no mercado. Contudo, sua popularidade se dá muito graças a pirataria, resultado da sua já popular acessibilidade.

<h1>Guia de Desenvolvimento</h1>

Tendo apresentado seus números, é possível passar a pensar no apecto que supre tal montante: o desenvolvimento. O Android SDK faz parte ou impacta a vida da maior parte dos desenvolvedores mobile, sejam especialistas, generalistas ou criadores de aplicações híbridas, o que contabiliza mais de 70% da stack.

A documentação a seguir busca inicialmente introduzir os fundamentos do desenvolvimento de aplicativos Android, priorizando o desenvolvimento mobile, e, posteriormente, se aprofundar em especificidades. 

<h1>Application Fundamentals</h1>

Os aplicativos Android podem ser desenvolvidos usando as linguagens [Kotlin](https://github.com/VictorSantos12/Kotlin), Java e C++. As ferramentas do Android SDK compilam seu código junto com quaisquer dados e arquivos de recursos em um APK ou Android App Bundle. 

Um package Android, que é um arquivo compactado com um sufixo .apk, contém o conteúdo de um aplicativo Android necessário em tempo de execução e é o arquivo que os dispositivos com tecnologia Android usam para instalar o aplicativo.

Um Android App Bundle, que pode ser identificado por um arquivo com o sufixo .aab, contém o conteúdo de um projeto de aplicativo Android, incluindo alguns metadados adicionais que não são necessários em tempo de execução. Um AAB é um formato de publicação e não pode ser instalado em dispositivos Android. Ele adia a geração e a assinatura do APK para um estágio posterior. Ao distribuir seu aplicativo por meio do Google Play, por exemplo, os servidores do Google Play geram APKs otimizados que contêm apenas os recursos e o código exigidos por um determinado dispositivo que está solicitando a instalação do aplicativo.

Cada aplicativo Android vive em sua própria sendBox, protegida pelos seguintes recursos de segurança:

- O sistema operacional Android é um sistema Linux multiusuário no qual cada aplicativo é um usuário diferente.<br>

- Por padrão, o sistema atribui a cada aplicativo um ID de usuário Linux exclusivo (o ID é usado apenas pelo sistema e é desconhecido para o aplicativo). O sistema define permissões para todos os arquivos em um aplicativo para que apenas o ID do usuário atribuído a esse aplicativo possa acessá-los.<br>

- Cada processo tem sua própria máquina virtual (VM), portanto, o código de um aplicativo é executado isoladamente de outros aplicativos.<br>

- Por padrão, cada aplicativo é executado em seu próprio processo Linux. O sistema Android inicia o processo quando qualquer um dos componentes do aplicativo precisa ser executado e, em seguida, encerra o processo quando não é mais necessário ou quando o sistema deve recuperar memória para outros aplicativos.

Também cabe ressaltar que o sistema Android implementa o princípio de privilégio mínimo. Ou seja, cada aplicativo, por padrão, tem acesso apenas aos componentes necessários para fazer seu trabalho e nada mais. Isso cria um ambiente seguro no qual um aplicativo não pode acessar partes do sistema para as quais não tem permissão. No entanto, existem maneiras de um aplicativo compartilhar dados com outros aplicativos e de um aplicativo acessar os serviços do sistema:

- É possível fazer com que dois aplicativos compartilhem o mesmo ID de usuário do Linux e, nesse caso, eles podem acessar os arquivos um do outro. Para conservar os recursos do sistema, os aplicativos com o mesmo ID de usuário também podem ser executados no mesmo processo do Linux e compartilhar a mesma VM. Os aplicativos também devem ser assinados com o mesmo certificado.<br>

- Um aplicativo pode solicitar permissão para acessar dados do dispositivo, como localização, câmera e conexão Bluetooth. O usuário deve conceder explicitamente essas permissões. 

Tais métodos serão mais bem abordados no decorrer da documentação.

<h1>App Components</h1>

Os App Components são os blocos de construção essenciais de um aplicativo Android. Cada componente é um ponto de entrada pelo qual o sistema ou um usuário pode entrar em seu aplicativo. Há quatro tipos distintos de app components:

- Activities<br>
- Services<br>
- Broadcast receivers<br>
- Content providers

Cada component serve a um propósito distinto e possui um ciclo de vida distinto, o qual define como o mesmo é criado e destruído. Os tópicos a seguir descrevem cada um dos quatro em detalhes:

<h1>Activities</h1>

Uma <i>activity</i> é o meio de interação entre o sistema e o usuário, sendo representada por uma tela contendo uma interface. Por exemplo, um app como o Gmail possui uma activity para listar novos emails, uma activiy que permite a leitura desses emails e outra que permite escreve-los e enviá-los. Ou seja, as activities trabalham para criar uma experiência coesa das funções de uma aplicação. 

Também cabe destacar que uma activity pode ser inicializada por um outro app, quando permitido. Um exemplo seria o acesso ao app da câmera ou de armazenamento de arquivos, em casos em que o email possar conter um recurso provido por um deles.

As funções das activities também incluem facilitar as seguintes interações entre o sistema e o app:

- Acompanhar as funções de interesse do usuário no momento (o que está em tela) para garantir que o sistema as continue executando.
- Saber que os processos usados ​​anteriormente contêm coisas para as quais o usuário pode retornar (activities interrompidas) e, portanto, mantê-los ativos.
- Ajudar o aplicativo a lidar com a interrupção de processos para que o usuário possa retornar às activities mantendo seus estados anteriores restaurados.
- Fornecer uma maneira para os aplicativos implementarem fluxos de usuários entre si e para o sistema coordenar esses fluxos. (Sendo o exemplo mais clássico o share).

Uma activity é implementada como uma subclasse da classe [Activity](https://developer.android.com/reference/android/app/Activity?authuser=1), a qual será abordada em detalhes a seguir.

<h1>The Activity Class</h1>

Como foi dito, uma activity é um fragmento da aplicação com qual o usuário pode interagir. Quase todas as atividades interagem com o usuário, logo a classe Activity se encarrega de criar métodos para lidar com as diferentes formas de interação e seus resultados. Tais métodos definem o ciclo de vida de uma activity, e estes são:

    public class Activity extends ApplicationContext {
      
        protected void onCreate(Bundle savedInstanceState);
    
        protected void onStart();
    
        protected void onRestart();
    
        protected void onResume();
    
        protected void onPause();
    
        protected void onStop();
    
        protected void onDestroy();
    }

<h2>Stack</h2>

As activities em um sistema Android são agrupadas seguindo o modelo de [Stack](https://developer.android.com/guide/components/activities/tasks-and-back-stack?authuser=1), sendo posicionadas de acorde com sua ordem de abertura. Quando um activity é inicializada, ela é posicionada sobre a stack atual, passando a ser a activity em execução; a activity anterior sempre permanece abaixo na stack, e não voltará ao primeiro plano novamente até que a nova activity seja encerrada. É possível que haja um ou multiplas stacks visíveis em uma tela.

<div align="center">
  <img src="">
</div>

<h2>Activity Lifecycle</h2>

Uma activity possui essencialmente quatro estados:

<div style="display: block;">
  <img style="width: 300px; display: block;" src="https://user-images.githubusercontent.com/61476935/151175041-627c1299-c046-4cf3-8170-b1e81af3ed52.gif">
  teste
</div>

  Caso uma activity esteja em primeiro plano (na posição mais acima da stack atual), ela está <i>active</i> ou <i>running</i>, sendo, normalmente, a activity com a qual o usuário está interegindo.

<div align="center">
  <img src="">
</div>





<h1>Services</h1>

<h1>Broadcast receivers</h1>

<h1>Content providers</h1>