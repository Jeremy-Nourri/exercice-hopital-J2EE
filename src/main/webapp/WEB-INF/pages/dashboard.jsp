<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>

<main>
    <div class="container mx-auto">
        <div class="flex justify-center">
            <div class="w-1/3">
                <h1 class="text-2xl font-bol
                d text-center">Dashboard</h1>
                <div class="flex justify-center">
                    <a href="${pageContext.request.contextPath}/patient/create-page" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Créer un patient</a>

                    <a href="${pageContext.request.contextPath}/patient/list-page" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Liste des patients</a>
            </div>
        </div>
    </div>

</body>
</html>
