# Proyecto DynamicWallet
## DynamicWallet es una aplicación web desarrollada utilizando Java Enterprise Edition (JEE) y siguiendo el patrón de diseño Modelo-Vista-Controlador (MVC). Esta aplicación permite a los usuarios registrarse, iniciar sesión y gestionar sus cuentas bancarias.
### Requisitos
Antes de ejecutar la aplicación, es necesario crear una base de datos y las tablas correspondientes. Ejecuta los siguientes comandos SQL para crear las tablas necesarias:
sqlCopy codeCREATE TABLE Cuenta (
    numeroCuenta INT PRIMARY KEY,
    titular VARCHAR(255) NOT NULL,
    saldo DOUBLE NOT NULL
);

CREATE TABLE Cliente (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    cuenta_numeroCuenta INT,
    FOREIGN KEY (cuenta_numeroCuenta) REFERENCES Cuenta(numeroCuenta)
);
## Configuración


### Configura las credenciales de conexión a la base de datos en el archivo Constantes.java ubicado en el paquete com.curso04.dinamicwallet.utils. Reemplaza TU_USUARIO y TU_CONTRASEÑA con los valores correspondientes a tu entorno.

javaCopy codepublic static final String USER = "TU_USUARIO";
public static final String PASSWORD = "TU_CONTRASEÑA";
Estructura del proyecto
El proyecto sigue la arquitectura MVC, donde:

El paquete modelo contiene las clases que representan las entidades del sistema, como Cliente y Cuenta.
El paquete servicios contiene las clases que implementan la lógica de negocio, como ClienteService y CuentaService.
El paquete daos contiene las clases que interactúan con la base de datos, como ClienteDAO y CuentaDAO.
El paquete controladores contiene los servlets que manejan las solicitudes HTTP y enrutan las respuestas correspondientes.
El paquete utils contiene clases de utilidad, como Constantes para almacenar valores constantes utilizados en la aplicación.
La carpeta webapp contiene los archivos JSP que representan las vistas de la aplicación.

![Captura de pantalla 2024-05-21 192533](https://github.com/RodStack/DinamicWallet/assets/57158158/01aa99ff-db0d-424e-8cf6-cba4185fb64a)
![Captura de pantalla 2024-05-21 192545](https://github.com/RodStack/DinamicWallet/assets/57158158/fafc5465-0e12-448a-8bc0-4bf05ac9733a)
![Captura de pantalla 2024-05-21 192552](https://github.com/RodStack/DinamicWallet/assets/57158158/01425ef6-7781-4688-af99-0ac78c75dca4)
![Captura de pantalla 2024-05-21 192557](https://github.com/RodStack/DinamicWallet/assets/57158158/47d7133f-7254-4af5-a87a-c644dc0745b6)
![Captura de pantalla 2024-05-21 192613](https://github.com/RodStack/DinamicWallet/assets/57158158/ff537aff-e33f-4187-8cda-5aaf45004445)
![Captura de pantalla 2024-05-21 192623](https://github.com/RodStack/DinamicWallet/assets/57158158/7a471b29-d7d3-4a98-842c-9958fab9a13a)










## Funcionalidades
### La aplicación DynamicWallet ofrece las siguientes funcionalidades:

Registro de nuevos usuarios: Los usuarios pueden crear una cuenta proporcionando un nombre de usuario y una contraseña.
Gestión de cuentas bancarias: Los usuarios pueden ver el saldo de sus cuentas bancarias y realizar operaciones como depósitos y retiros de manera dinamica.
