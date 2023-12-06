<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>page</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="commerciale-login">
        <div class="bienvenue"> CONNECTER AU TANT QUE FOURNISSEUR DE COMMERCIALE </div>
        <div class="form">
            <form action="/logincontroller/fournisseur_login" method="post">
                <div>
                    <label> Email </label>
                    <input type="email" name="email">
                </div>
                <div>
                    <label> Password </label>
                    <input type="password" name="password">
                </div>
                <div>
                    <input type="submit" value="Se Connecter">
                </div>
                <span>Forget password ?</span>
            </form>
        </div>
    </div>
</body>
</html>