<%@ page import="org.example.tphopitalj2ee.model.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="patients" type="java.util.ArrayList<org.example.tphopitalj2ee.model.Patient>" scope="request" />
<html>
<head>
    <title>Liste des patients</title>
    <script src=java.util.ArrayList"https://cdn.tailwindcss.com"></script>
</head>
<body>

<main>
    <div class="container mx-auto">
        <div class="flex justify-center">
            <div class="w-1/3">
                <h1 class="text-2xl font-bold text-center">Liste des patients</h1>
                <table class="table-auto">
                    <thead>
                    <tr>
                        <th class="px-4 py-2">Nom</th>
                        <th class="px-4 py-2">Prénom</th>
                        <th class="px-4 py-2">Date de naissance</th>
                        <th class="px-4 py-2">Photo</th>
                        <th class="px-4 py-2">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (Patient patient : patients) {%>
                        <tr>
                            <td class="border px-4 py-2"><%= patient.getLastName() %></td>
                            <td class="border px-4 py-2"><%= patient.getFirstName() %></td>
                            <td class="border px-4 py-2"><%= patient.getBirthDate() %></td>
                            <td class="border px-4 py-2"><img src="<%= patient.getPicture() %>" alt="photo" class="w-16 h-16"></td>
                            <td class="border px-4 py-2">
                                <a href="patient/details?id=<%= patient.getId() %>" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Details</a>
                        </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</main>

</body>
</html>
