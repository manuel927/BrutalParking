<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Information</title>
    </head>
    <body>
        <h1>User Information</h1>
        <form action="./UserServlet" method="POST">
            <table>
                <tr>
                    <td>Cedula</td>
                    <td><input type="text" name="cedula" value="${Usuario.cedula}" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${Usuario.nombre}" /></td>
                </tr>
                <tr>
                    <td>Correo</td>
                    <td><input type="text" name="correo" value="${Usuario.correo}" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="text" name="password" value="${Usuario.password}" /></td>
                </tr>
                 <tr>
                    <td>ClienteoPropietario</td>
                    <td><input type="text" name="cop" value="${Usuario.cop}" /></td>
                </tr>
                 <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="telefono" value="${Usuario.telefono}" /></td>
                </tr>
               
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>