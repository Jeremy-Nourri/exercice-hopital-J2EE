<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>

<main>
    <div class="container mx-auto">
        <div class="flex justify-center">
            <div class="w-1/3">
                <h1 class="text-2xl font-bold text-center">Connexion</h1>
                <form action="signin" method="post" enctype="multipart/form-data">
                    <div class="mb-4">
                        <label for="email" class="block text-gray-700 text-sm font-bold mb-2">Email</label>
                        <input type="email" id="email" name="email" required class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                    </div>
                    <div class="mb-4">
                        <label for="password" class="block text-gray-700 text-sm font-bold mb-2">Mot de passe</label>
                        <input type="password" id="password" name="password" required class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                    </div>
                    <div class="flex justify-center">
                        <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Se connecter</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
