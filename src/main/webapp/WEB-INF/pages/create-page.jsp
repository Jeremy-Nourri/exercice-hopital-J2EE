<%--
  Created by IntelliJ IDEA.
  User: jnour
  Date: 21/06/2024
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Créer un patient</title>
</head>
<body>

<main>
    <div class="container mx-auto">
        <div class="flex justify-center">
            <div class="w-1/3">
                <h1 class="text-2xl font-bold text-center">Créer un patient</h1>
                <form action="create" method="post" enctype="multipart/form-data">
                    <div class="mb-4">
                        <label for="lastname" class="last text-gray-700 text-sm font-bold mb-2">Nom</label>
                        <input type="text" id="lastname" name="lastname" required class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                    </div>
                    <div class="mb-4">
                        <label for="firstname" class="last text-gray-700 text-sm font-bold mb-2">Prénom</label>
                        <input type="text" id="firstname" name="firstname" required class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                    </div>
                    <div class="mb-4">
                        <label for="birthdate" class="last text-gray-700 text-sm font-bold mb-2">Date de naissance</label>
                        <input type="date" id="birthdate" name="birthdate" required class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                    </div>
                    <div class="mb-4">
                        <label for="picture" class="last text-gray-700 text-sm font-bold mb-2">Photo</label>
                        <input type="file" id="picture" name="picture" required class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                    </div>

                    <div class="flex justify-center">
                        <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Créer</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</main>

</body>
</html>
