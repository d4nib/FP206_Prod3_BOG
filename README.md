
# Producto 3 - Persistencia en ase de datos

Fecha de entrega 14 de abril - 23:59 

A partir del diagrama de clases, realizado en el primer producto, realizaremos la adaptación del diseño orientado a objetos al modelo relacional. A partir de esta adaptación implementaremos, en lenguaje Java utilizando JDBC, la persistencia en una base de datos relacional. 

## `Objetivos` 
Aplicar la persistencia en bases de datos usando los patrones de diseño DAO y Factory. 


## `Pasos a seguir `
Leer detenidamente estas instrucciones e identificar los requisitos de la actividad. 
Revisar detenidamente la rúbrica de evaluación. 
Consultar los recursos necesarios facilitados en el aula. 
Crear la estructura en la base de datos, a partir del Modelo Relacional, es decir: tablas, claves primarias y foráneas, atributos, relaciones, etc., con base de datos relacional MySQL. 
Realizar un programa en Java en modo de consola que almacene la información en una base de datos relacional utilizando JDBC en lugar de estructuras dinámicas como ArrayList. 
En este producto se debe cambiar la forma de almacenar los datos, de forma que en lugar de almacenarlos en ArrayLists se almacenarán en una base de datos, todo ello manteniendo el patrón de diseño MVC, de esta forma, solo es necesario modificar o adaptar la implementación realizada en la capa del Modelo. 
Además, para separar la persistencia de los datos del resto de funcionalidades del sistema se deberá utilizar el patrón de diseño DAO (Data Access Object). Uno de los beneficios de DAO es la independencia del almacén de datos, así pues, el cambio de motor de base de datos solo afectará al DAO y no a las clases encargadas de la lógica de negocio o de presentación. o el cambio de motor de base de datos. 
Con el objeto de conseguir la independencia del almacén de datos se usará el patrón Factory para instanciar los DAOs. 
Utilizar el SGBD MySQL para realizar la persistencia. 
Utilizar una clase utilidad para controlar las conexiones a la Base de datos. 
Utilizar JDBC de forma adecuara para evitar los ataques SQL Injection. 
Aplicar transacciones y procedimientos almacenados en todas las operaciones DML que así lo requieran. 
Realiza un video mostrando la ejecución de todo el programa en todas sus opciones. Utiliza una herramienta de grabación de videos de captura de pantalla. 
Se requiere Event personal


## `Requisitos` 
Realizar la interacción con la aplicación en modo consola.  
Tener en cuenta la gestión correcta de excepciones. 
Continuar utilizando el sistema de control de versiones Git. 
Disponer del entorno de programación en Java. 
Utilizar la base de datos MySQL. 
Recursos Básicos   Book
Para llevar a cabo la actividad puedes apoyarte en los materiales y fuentes de información disponibles el el documento "Recursos de aprendizaje asociados a los productos".

## Criterios de evaluación  
La puntuación máxima del producto es un 20.  
La puntuación mínima para superarlo es de 10 sobre 20. 

## `Indicaciones para la entrega de la actividad`
Hacerlo por el canal indicado en el aula virtual. 
Formato: zip o rar, en el contenido se deberá incluir el documento PDF con la resolución de los ejercicios y los ficheros del programa en java así como el resto de ficheros relacionados en este producto. 
Nombre del archivo: producto3(FP206)_Apellido1Apellido2_Nombre 
Extensión recomendada: 3-5 páginas. 
