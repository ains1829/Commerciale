<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bande Commande</title>
    <link rel="stylesheet" href="/css/commande.css">
</head>
<body>
    <div class="container-page">
        <%@ include file = "Menu.jsp"  %> 
        <div class="commande">
            <span>Date  : 2023-01-01</span>
            <span>Fournisseur : Jumbo Score</span>
            <span>Manager : andyrakotoanavalona</span>
            <table>
                <tr>
                    <th>Id_article</th>
                    <th>Quantite</th>
                    <th>Prix HT</th>
                    <th>Tva</th>
                    <th>TTC</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>50 kg</td>
                    <td>500000 ar</td>
                    <td>20%</td>
                    <td>500000 ar</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>50 kg</td>
                    <td>500000 ar</td>
                    <td>20%</td>
                    <td>500000 ar</td>
                </tr>
            </table>
            <div> Somme total : 1000000 arairy</div>
            <div> Arreter a la somme de : </div>
        </div>
    </div>
</body>
</html>