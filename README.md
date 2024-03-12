<div align="center">
  <img src="https://user-images.githubusercontent.com/61476935/154176831-50b6f16a-2858-48a0-b8b7-59b1c8291837.png">
</div>
<br>
<img src="https://img.shields.io/static/v1?label=android&message=Mobile-Development&color=green&style=for-the-badge&logo=Android"/>

<p align="justify">O Android é um sistema operacional mobile, baseado em Linux, criado pela Google em 2009. Possuindo mais de dois bilhões de usuários e estando presente em mais de vinte e quatro mil modelos de dispositivos, desde smartphones e smartwatches a televisores e veículos, o sistema ganhou a alcunha de mais popular do mundo. O fato é que sua história se mistura com a histório de criação e adoção em massa dos smartphones, e por consequência, do desenvolvimento mobile.</p>

<p align="justify">Sendo o principal rival do IOS, e muitas vezes único, o sistema Android passou a ser adotado pela maior parte das empresas que desenvolvem aparelhos móveis. Empresas como Samsung, Motorola, Xiaomi e muitas outras adotaram o OS da Google a partir de sua entrada no mercado. Contudo, sua popularidade se dá muito graças a pirataria, resultado da sua já popular acessibilidade.</p>

<h1>Guia de Desenvolvimento</h1>

<p align="justify">Tendo apresentado seus números, é possível passar a pensar no apecto que supre tal montante: o desenvolvimento. O Android SDK faz parte ou impacta a vida da maior parte dos desenvolvedores mobile, sejam especialistas, generalistas ou criadores de aplicações híbridas, o que contabiliza mais de 70% da stack.</p>

<p align="justify">A documentação a seguir busca inicialmente introduzir os fundamentos do desenvolvimento de aplicativos Android, priorizando o desenvolvimento mobile, e, posteriormente, se aprofundar em especificidades.</p>

<h1>Application Fundamentals</h1>

<p align="justify">

Os aplicativos Android podem ser desenvolvidos usando as linguagens [Kotlin](https://github.com/VictorSantos12/Kotlin), [Java]() e C++. As ferramentas do Android SDK compilam seu código junto com quaisquer dados e arquivos de recursos em um APK ou Android App Bundle.

</p>

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

<h1>App Components</h1>

Os App Components são os blocos de construção essenciais de um aplicativo Android. Cada componente é um ponto de entrada pelo qual o sistema ou um usuário pode entrar em seu aplicativo. Há quatro tipos distintos de app components:

- Activities<br>
- Services<br>
- Broadcast receivers<br>
- Content providers

Cada component serve a um propósito distinto e possui um ciclo de vida distinto, o qual define como o mesmo é criado e destruído. Os tópicos a seguir descrevem cada um dos quatro em detalhes:

<h2>a) Activities</h2>

Uma <i>activity</i> é um fragmento da aplicação com qual o usuário pode interagir, a qual possui certa independência dentro da estrutura da aplicação. Por exemplo, um app como o Gmail possui uma atividade para listar novos emails, uma atividade que permite a leitura destes e outra que permite responde-los. Ou seja, as atividade trabalham para criar uma experiência coesa das funções de uma aplicação.

A maioria dos aplicativos contém várias telas, ou seja, várias atividades. Normalmente, uma atividade em um aplicativo é especificada como a <i>MainActivity</i>, sendo a tela inicial do aplicativo. Cada atividade pode então iniciar outra atividade para realizar ações distintas. Porém, diferentemente da sua contraparte desktop, mobile-apps nem sempre são inicializados de um mesmo ponto. Pelo contrário, a jornada do usuário normalmente se inicia de forma não determinada.

Retornando ao exemplo do Gmail App, pode se notar diferentes formas de inicializa-lo, sendo a mais direta delas através da sua MainActivity. Por outro lado, quando seu acesso está atrelado a outro app, a MainActivity não será necessariamente utilizada, sendo possível acessar especificamente a task de escrita e envio de e-mails.

Toda activity é subclasse da classe [Activity](https://developer.android.com/reference/android/app/Activity?authuser=1) foi desenvolvida para falicitar tais necessidades. Quando um aplicativo invoca outro, o que de fato é invocado é uma de suas atividades, não o aplicativo como um todo.

<!-- <h2>a) Stack</h2>

As atividades em um sistema Android são agrupadas seguindo o modelo de [Stacks](https://developer.android.com/guide/components/activities/tasks-and-back-stack?authuser=1), sendo posicionadas de acorde com sua ordem de abertura em uma <i>task</i>. Quando uma atividade é inicializada, ela é posicionada sobre a stack atual, passando a estar em execução; <img align="right" style="width: 400px;" src="https://user-images.githubusercontent.com/61476935/179646952-ac018b2e-97d3-417c-b36b-505bb55f49e4.png">
a atividade anterior sempre permanece abaixo na stack, compondo a <i>back stack</i>.

Uma atividade que faz parte da back stack não retorna ao primeiro plano até que a nova atividade seja encerrada. É possível que haja uma ou multiplas stacks visíveis em uma tela.

A tela inicial do dispositivo é o ponto de partida para a maioria das tasks. Quando um aplicativo é acessado, sua task (conjunto de atividades) fica em primeiro plano. Se não existir nenhuma task para o aplicativo (o aplicativo não foi usado recentemente), uma nova task será criada a partir da tela inicial do app.

As atividades na stack nunca são reorganizadas, apenas sofrem push quando acessadas, ou pop, quando retiradas da pilha caso uma interação do usuário com o Back button ou gesture seja detectada. Quando uma atividade é encerrada, sua antecedente se torna ativa, e o estado anterior da interface é retomado. -->
<!--
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

- O tempo de vida em primeiro plano de uma atividade acontece entre a chamada do método onResume() e uma chamada correspondente ao método onPause(). Durante este periodo a atividade fica visível, ativa e interagindo com o usuário. Uma atividade pode frequentemente ficar entre os estados resumed e paused - por exemplo, quando o dispositivo entra em suspensão, quando um resultado de atividade é entregue, quando uma nova intenção é entregue - portanto, o código nesses métodos deve ser bastante leve. -->

<h2>b) Services</h2>

<h2>c) Broadcast receivers</h2>

<h2>d) Content providers</h2>

<h1>The manifest file</h1>

<p align="justify">A</p>
