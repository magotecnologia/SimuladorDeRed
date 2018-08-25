# Network Simulator


Simulador de redes de computadores
Se requiere diseñar y construir un simulador de redes de computadores. La red está
compuesta por computadores, canales de comunicación y dispositivos; otro
elemento de la red es el mensaje que sale de un computador pasando por los
canales de comunicación y los dispositivos hasta su destino. A continuación se
describe cada uno de estos elementos:

**Computador:** Se identifica con una dirección de red IP que es única en toda la red.
Está conectado a un sólo canal de comunicación y a través de él puede recibir o
enviar mensajes. Para enviar un mensaje el computador simplemente crea el
mensaje y se lo envía al canal de comunicación. El computador recibe todos los
mensajes que el canal de comunicación le envía, pero sólo lee los mensajes que
están dirigidos a él o los mensajes dirigidos a la dirección destino asterisco (*) que
significa envío a toda la red, los demás los rechaza (no hace nada con ellos).
Cuando un computador envía un mensaje imprime en pantalla lo siguiente:

Mensaje enviado por computador con IP 157.253.122

Con destino al computador con IP 157.253.90

Contenido del mensaje: Hola

Cuando un computador recibe un mensaje que estaba dirigido a él, este imprime
en pantalla lo siguiente:

Mensaje recibido por computador con IP 157.253.90

El mensaje lo envió el computador con IP 157.253.122

El mensaje pasó por los siguientes dispositivos: Bridge000123, Hub000456,

Router000789

Contenido del mensaje: Hola

**Canal de comunicación:** Tiene un identificador único que se genera aleatoriamente
un conjunto de computadores y un conjunto de dispositivos a los cuales está
conectado. El canal de comunicación puede recibir mensajes de un computador o
de un dispositivo. Cuando recibe un mensaje, el canal lo envía a todos los
computadores y/o dispositivos que tiene conectados exceptuando al computador o
dispositivo del cual recibió el mensaje.

**Dispositivo:** Tiene un identificador único y un conjunto de canales de comunicación
a los que se encuentra conectado. El dispositivo recibe mensajes de los canales de 
comunicación; cuando recibe un mensaje verifica que este no le haya llegado antes,
ya que si el mensaje ya le había llegado lo rechaza, lo cual significa que no hace
nada con él. Si el mensaje no le había llegado antes, debe agregar su identificador
al mensaje y luego lo envía a todos los canales de comunicación a los que está
conectado, excepto al canal que envió el mensaje. Dependiendo el tipo de
dispositivo, el mensaje tarda un tiempo de retraso (delay) en seguirse transmitiendo
por la red. Existen 5 tipos de dispositivos los cuales son: _Router_ que retrasa el
mensaje 1 segundo, _Hub_ que retrasa el mensaje 2 segundos, _Repeater_ que retrasa
el mensaje 3 segundos, _Switch_ que retrasa el mensaje 4 segundos y _Bridge_ que
retrasa el mensaje 5 segundos. El identificador único de cada dispositivo se genera
aleatoriamente acorde a la siguiente estructura: <NombreTipoDispositivo>XXXXXX.
Algunos ejemplos son:

Bridge000123, Hub000456, Router000789, Switch321000, Repeter987456.

**Mensaje:** Tiene un identificador único generado aleatoriamente, una dirección IP de
red origen, una dirección IP de red destino, el contenido del mensaje y almacena en
orden el identificador de cada dispositivo por donde pasa más el tiempo total que
tarda el mensaje en trasmitirse por la red hasta su destino. Cuando la dirección IP
de red destino es el caracter asterisco (*), el mensaje va dirigido a todos los
computadores de la red.
A continuación se muestran redes de prueba a ejecutar en el simulador:

![Red1](/img/Network1.PNG)
![Red2](/img/Network2.PNG)
![Red3](/img/Network3.PNG)
Es necesario que el simulador que usted va a construir pueda ser ejecutado en
múltiples plataformas, por lo tanto se requiere utilizar la versión standard edition del
lenguaje de programación Java en sus últimas versiones. De igual manera, se debe
documentar la solución que se diseñará y construirá a partir de artefactos UML. Por
otro lado, se espera tener una aplicación funcional pero que cumpla con buenas
prácticas de desarrollo de software desde su concepción hasta su entrega.