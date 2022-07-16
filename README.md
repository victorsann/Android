<div align="center">
  <img src="https://user-images.githubusercontent.com/61476935/154176831-50b6f16a-2858-48a0-b8b7-59b1c8291837.png">
</div>
<br>
<img src="https://img.shields.io/static/v1?label=android&message=Mobile-Development&color=green&style=for-the-badge&logo=Android"/>

O Android é um sistema operacional mobile, baseado em Linux, criado pela Google em 2009. Possuindo mais de dois bilhões de usuários e estando presente em mais de vinte e quatro mil dispositivos, desde smartphones e smartwatches a televisores e veículos, o sistema ganhou a alcunha de mais popular do mundo. O fato é que sua história se mistura com a histório de criação e adoção em massa dos smartphones, e por consequência, do desenvolvimento mobile.

Sendo o principal rival do IOS, e muitas vezes único, o sistema Android passou a ser adotado pela maior parte das empresas que desenvolvem aparelhos móveis. Empresas como Samsung, Motorola, Xiaomi e muitas outras adotaram o OS da Google a partir de sua entrada no mercado. Contudo, sua popularidade se dá muito graças a pirataria, resultado da sua já popular acessibilidade.

Tendo apresentado seus números, é possível passar a pensar no apecto que supre tal montante: o desenvolvimento. A Android SDK faz parte ou impacta a vida da maior parte dos desenvolvedores mobile, sejam especialisatas, generalistas ou criadores de aplicações híbridas, o que contabiliza mais de 70% da stack.

<h1>Guia de Desenvolvimento</h1>

A documentação a seguir busca inicialmente introduzir os fundamentos do desenvolvimento de aplicativos Android, priorizando o desenvolvimento mobile, e, posteriormente, se aprofundar em especificidades. 

<h1>Application Fundamentals</h1>

Os aplicativos Android podem ser desenvolvido usando as linguagens [Kotlin](https://github.com/VictorSantos12/Kotlin), Java e C++. As ferramentas do Android SDK compilam seu código junto com quaisquer dados e arquivos de recursos em um APK ou Android App Bundle. 

Um package Android, que é um arquivo compactado com um sufixo .apk, contém o conteúdo de um aplicativo Android necessário em tempo de execução e é o arquivo que os dispositivos com tecnologia Android usam para instalar o aplicativo.

Um Android App Bundle, que pode ser identificado por um arquivo com o sufixo .aab, contém o conteúdo de um projeto de aplicativo Android, incluindo alguns metadados adicionais que não são necessários em tempo de execução. Um AAB é um formato de publicação e não pode ser instalado em dispositivos Android. Ele adia a geração e a assinatura do APK para um estágio posterior. Ao distribuir seu aplicativo por meio do Google Play, por exemplo, os servidores do Google Play geram APKs otimizados que contêm apenas os recursos e o código exigidos por um determinado dispositivo que está solicitando a instalação do aplicativo.

Cada aplicativo Android vive em sua própria sendBox, protegida pelos seguintes recursos de segurança:

>O sistema operacional Android é um sistema Linux multiusuário no qual cada aplicativo é um usuário diferente.<br>

>Por padrão, o sistema atribui a cada aplicativo um ID de usuário Linux exclusivo (o ID é usado apenas pelo sistema e é desconhecido para o aplicativo). O sistema define permissões para todos os arquivos em um aplicativo para que apenas o ID do usuário atribuído a esse aplicativo possa acessá-los.<br>

>Cada processo tem sua própria máquina virtual (VM), portanto, o código de um aplicativo é executado isoladamente de outros aplicativos.<br>

>Por padrão, cada aplicativo é executado em seu próprio processo Linux. O sistema Android inicia o processo quando qualquer um dos componentes do aplicativo precisa ser executado e, em seguida, encerra o processo quando não é mais necessário ou quando o sistema deve recuperar memória para outros aplicativos.

O sistema Android implementa o princípio de privilégio mínimo. Ou seja, cada aplicativo, por padrão, tem acesso apenas aos componentes necessários para fazer seu trabalho e nada mais. Isso cria um ambiente muito seguro no qual um aplicativo não pode acessar partes do sistema para as quais não tem permissão. No entanto, existem maneiras de um aplicativo compartilhar dados com outros aplicativos e de um aplicativo acessar os serviços do sistema:

>É possível fazer com que dois aplicativos compartilhem o mesmo ID de usuário do Linux e, nesse caso, eles podem acessar os arquivos um do outro. Para conservar os recursos do sistema, os aplicativos com o mesmo ID de usuário também podem ser executados no mesmo processo do Linux e compartilhar a mesma VM. Os aplicativos também devem ser assinados com o mesmo certificado.<br>

>Um aplicativo pode solicitar permissão para acessar dados do dispositivo, como localização, câmera e conexão Bluetooth do dispositivo. O usuário deve conceder explicitamente essas permissões. Para obter mais informações, consulte Trabalhando com permissões do sistema.