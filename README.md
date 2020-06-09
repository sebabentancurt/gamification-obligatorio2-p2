# gamification-obligatorio2-p2

```
Bernard Wand-Polak
Cuareim 1451
11.100 Montevideo, Uruguay
Tel. 2902 15 05 Fax 2908 13 70
http://www.ort.edu.uy
```
EVALUACIÓN Obligatorio 2 GRUPO TODOS FECHA (^) MAYO 2020 V 11
MATERIA Programación II
CARRERA Ing. en Sistemas. Eléctrica, Electrónica, Telecomunicaciones, Lic. en Sistemas^
CONDICIONES -^ Puntos: Máximo:^25 Mínimo:^12

- Fecha máxima de entrega: 29 de junio de 2020
- Defensa: Se realizará en fecha a definir entre el 20 y 29 de julio, en horario de clase, en forma
conjunta a la defensa del parcial. Se publicará en Aulas fecha y horario. La no asistencia a la
defensa implica la pérdida de todos los puntos del obligatorio.

```
LA ENTREGA SE REALIZA EN FORMA ONLINE EN ARCHIVO NO MAYOR A 40MB EN
FORMATO ZIP o RAR
```
```
IMPORTANTE:
```
- Inscribirse.
- Formar grupos de hasta dos personas del mismo dictado.
- Subir el trabajo a Gestión antes de la hora indicada, ver hoja al final del documento:
“RECORDATORIO”.
- Verificar que el trabajo quedó correctamente subido.

La “gamification” es el uso de técnicas, elementos y dinámicas propias de los juegos en otros tipos
de actividades. Se puede incorporar al aprendizaje con el fin de mejorar los resultados. En este
contexto, se desea un sistema para utilizar en los cursos de forma que permita jugar a varios juegos
diferentes, a partir de preguntas con su respectiva respuesta.

En el sistema se debe poder:

a) Gestionar temas. De cada tema se registra nombre (único) y descripción. Debe ser posible
modificar la descripción de temas ya registrados. De cada tema, se debe informar la cantidad de
preguntas que hay en el sistema. Si un tema no tiene ninguna pregunta puede ser eliminado si se
desea.

b) Gestionar preguntas manualmente. Cada pregunta corresponde a un único tema, tiene un
texto que la formula y un texto con su respuesta. Debe permitirse el ingreso manual de una nueva
pregunta, actualizar la respuesta de una pregunta ya registrada y, o, eliminar preguntas.
Si al registrar una nueva pregunta ya existe una de exactamente el mismo tema y texto que la
formula, la respuesta sustituye a la registrada en el sistema.

c) Carga de preguntas en forma colectiva. Se elige de una lista un archivo .txt y se importan al
sistema todas las preguntas válidas contenidas en él. Una pregunta es válida si ninguno de sus
elementos (tema, texto, respuesta) es completamente vacío. Por cada pregunta en el archivo hay
siempre 3 líneas, ver ejemplo del formato:


```
Bernard Wand-Polak
Cuareim 1451
11.100 Montevideo, Uruguay
Tel. 2902 15 05 Fax 2908 13 70
http://www.ort.edu.uy
```
Tema (corresponde al nombre del tema)
Texto de la Pregunta
Texto de la Respuesta
....

El único error puede ser que alguna línea esté vacía, en ese caso no se agrega esa pregunta y se
ignoran sus 3 líneas. Si ya hubiera registrada una pregunta exactamente del mismo tema con el
mismo texto de pregunta, se actualiza su respuesta en el sistema.
Si el tema no está en el sistema, dar de alta ese tema con ese nombre y como descripción: “A
COMPLETAR”.
Al final del proceso, indicar por pantalla la cantidad efectiva de preguntas nuevas ingresadas, la
cantidad que se actualizaron y la cantidad de preguntas ignoradas. Además, agregar una línea al
archivo "BITACORA.txt", con esa misma información, fecha y hora.

A los efectos de las pruebas, se agregará la opción de crear en forma automática cantidades que
se indiquen de temas y de preguntas ficticias de cada uno de esos temas, con datos prefijados que
simplifiquen la verificación. Los contenidos deben ser similares al ejemplo siguiente.
Ejemplo de creación de un tema con dos preguntas, se generan:
Tema: nombre: "T: 1 ", descripción: "Descripción de T1"
Pregunta: texto: "T: 1 P:1 Texto de P1", respuesta: "T: 1 P:1 Respuesta de P1"
Pregunta: texto: "T: 1 P:2 Texto de P2", respuesta: "T:1 P:2 Respuesta de P2"

d) ¡Jugar!
Se seleccionará/n el/los temas sobre los que se jugará y se elegirá el modo de juego: Flash Cards
o Memory. El sistema elegirá preguntas al azar y sin repeticiones de los temas indicados a usar en
el juego.

d1) Jugar en modo **“** Flash Cards **”** (Repaso de tema).
Las tarjetas “Flash” fomentan la memoria. Físicamente, en cada tarjeta, hay una pregunta que se
relaciona con su respuesta, que está en el dorso.
Se va mostrando de a una pregunta del/de los temas elegidos. Al cliquear sobre la pregunta se
alterna entre su texto y su respuesta. Se puede pasar a la siguiente/anterior pregunta. Debe
visualizarse en el título de la ventana los nombres de los temas que se seleccionaron.
Ejemplo:

d2) Jugar en modo **“** Memory **”**
Este tipo de juego contribuye a aumentar la atención, la memoria y la percepción. En este formato,
se presenta un cuadriculado de 3 filas *4 columnas, para 6 preguntas y sus respuestas. En cada


```
Bernard Wand-Polak
Cuareim 1451
11.100 Montevideo, Uruguay
Tel. 2902 15 05 Fax 2908 13 70
http://www.ort.edu.uy
```
posición hay oculta o una pregunta o una respuesta del/ de los temas elegidos. Se trata de recordar
y asociar cada par.

Se hace click en dos cuadros. Si forman una pareja (pregunta y su respuesta o viceversa), se suman
50 puntos y quedan descubiertos esos cuadros. Por cada par incorrecto, se restan 10 puntos y se
ocultan.
Hay ayudas: si se presiona el botón de ayuda parcial se mostrará en cada cuadro si es pregunta o
si es respuesta. Si se presiona el botón de ayuda total, se mostrarán todos los contenidos. También
hay un botón “Reset” que oculta todas las ayudas.

Ejemplo de ayuda parcial con datos de prueba:

Ejemplo de ayuda total con datos de prueba:

Se va mostrando en pantalla el puntaje obtenido.
En el título de la ventana mostrar la descripción de los temas elegidos.
Durante el juego, se puede activar/desactivar música de fondo.


```
Bernard Wand-Polak
Cuareim 1451
11.100 Montevideo, Uruguay
Tel. 2902 15 05 Fax 2908 13 70
http://www.ort.edu.uy
```
e) Exportación de datos
Se elige un directorio de una lista y se graban en él todas las preguntas disponibles en el sistema
en el mismo formato de la carga colectiva. El nombre del archivo es "DATOS.txt". Deben estar
ordenadas por nombre del tema/texto pregunta.

f) Terminar

Se pide:
Implementar en Java un sistema para brindar todas las funcionalidades presentadas. La interfaz
debe ser estilo Windows. El sistema debe ser persistente (en forma automática) y realizar todas las
validaciones necesarias. Entregar además un archivo .jar que contenga toda la aplicación para
funcionar correctamente. Este único archivo no debe tener datos precargados.

Para la entrega: subir un archivo zip/rar de hasta 40 MB con tres carpetas:

a) carpeta del código. Dentro debe estar el proyecto completo en NetBeans, incluyendo los fuentes
java. Los fuentes deben incluir el nombre de los autores.
b) carpeta del ejecutable. Contiene el archivo .jar
c) carpeta de la documentación.
La documentación es un UNICO pdf que contiene:
1) Carátula con foto e identificación de los 2 integrantes del equipo (las 2 personas deben
pertenecer al mismo grupo de clase)
2) Diagrama de clases (UML) del dominio, especificando relaciones, atributos y métodos
3) Listado del código fuente de las clases del dominio
4) Link a un video en YouTube de duración máxima 1 minuto donde se presente el sistema
desarrollado, en formato "Elevator Pitch". En el video deben aparecer los dos integrantes del
equipo.
**RECORDATORIO: IMPORTANTE PARA LA ENTREGA**

```
➢ Obligatorios (Cap.IV.1, Doc. 220)
```
La entrega de los obligatorios será en formato digital online, a excepción de algunas materias que se entregarán en Bedelía y en
ese caso recibirá información específica en el dictado de la misma.
Los principales aspectos a destacar sobre la **entrega online de obligatorios** son:

1. La entrega se realizará desde **gestion.ort.edu.uy**
2. Previo a la conformación de grupos cada estudiante deberá estar inscripto a la evaluación. **Sugerimos realizarlo con**
    **anticipación.**
3. Cada equipo debe entregar **un único archivo en formato zip o rar** (los documentos de texto deben ser pdf, y deben ir
    dentro del zip o rar)
4. El archivo a subir debe tener **un tamaño máximo de 40mb**
5. Les sugerimos **realicen una 'prueba de subida' al menos un día antes** , donde conformarán el **'grupo de obligatorio'.**
6. La **hora tope para subir el archivo será las 21:00** del día fijado para la entrega.
7. La entrega se podrá realizar desde cualquier lugar (ej. hogar del estudiante, etc)
8. Aquellos de ustedes que presenten alguna dificultad con su inscripción o tengan inconvenientes técnicos, contactar con
    la oficina del Coordinador o Coordinación adjunta **antes de las 20:00hs.** del día de la entrega.
    Si tuvieras una situación particular de fuerza mayor, debes dirigirte con suficiente antelación al plazo de entrega, al
    Coordinador de Cursos o Secretario Docente.


