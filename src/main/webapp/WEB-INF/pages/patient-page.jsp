<%--
  Created by IntelliJ IDEA.
  User: jnour
  Date: 21/06/2024
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="patient" type="org.example.tphopitalj2ee.model.Patient" scope="request" />
<html>
<head>
    <title>Page patient</title>
</head>
<body>

<main>
    <div class="container mx-auto">
        <div class="flex justify-center">
            <div class="w-1/3">
                <h1 class="text-2xl font-bold text-center">Page patient</h1>
                <div class="flex justify-center">
                    <img src="data:image/jpg;base64,<%= patient.getPicture() %>" alt="photo" class="w-16 h-16">
                </div>
                <div class="mb-4">
                    <label for="lastname" class="last text-gray-700 text-sm font-bold mb-2">Nom</label>
                    <input type="text" id="lastname" name="lastname" value="<%= patient.getLastName() %>" required class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                </div>
                <div class="mb-4">
                    <label for="firstname" class="last text-gray-700 text-sm font-bold mb-2">Prénom</label>
                    <input type="text" id="firstname" name="firstname" value="<%= patient.getFirstName() %>" required class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                </div>
                <div class="mb-4">
                    <label for="birthdate" class="last text-gray-700 text-sm font-bold mb-2">Date de naissance</label>
                    <input type="date" id="birthdate" name="birthdate" value="<%= patient.getBirthDate() %>" required class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                </div>

            </div>




</body>
</html>
