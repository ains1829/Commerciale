let dynamicFieldsCount = 2;

async function addFields() {
    const dynamicFieldsDiv = document.getElementById('dynamicFields'); 
        const fieldP=document.createElement('p');
        const fieldDiv = document.createElement('div');
        fieldDiv.innerHTML =`
        <label for="Id_article${dynamicFieldsCount}">Article:</label>
        `;
        fieldDiv.id="dynamicFields2";
        const selectElement = document.createElement('select');
        selectElement.name = `Id_article${dynamicFieldsCount}`;
        selectElement.id = `Id_article${dynamicFieldsCount}`;
        var articles;
        await fetch('/getArticles', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => response.json())
        .then(data => {
            // Gérer la réponse du serveur si nécessaire
            articles=data;
            if(articles!=null){
                articles.forEach( article => {
                    const optionElement = document.createElement('option');
                    optionElement.value = article.id_article;
                    optionElement.textContent = article.nom;
                    selectElement.appendChild(optionElement);
                });
            }
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
                     //   <option value="+article.getId_article()"> article.getNom </option><%
        fieldDiv.appendChild(selectElement);
        fieldDiv.innerHTML += `
        <label for="quantite${dynamicFieldsCount}">Quantité:</label>
        <input type="text" id="quantite${dynamicFieldsCount}" name="quantite${dynamicFieldsCount}">
        
        <label for="prixunitaire${dynamicFieldsCount}">Prix Unitaire:</label>
        <input type="text" id="prixunitaire${dynamicFieldsCount}" name="prixunitaire${dynamicFieldsCount}">
        
        <label for="tva${dynamicFieldsCount}">TVA:</label>
        <input type="text" id="tva${dynamicFieldsCount}" name="tva${dynamicFieldsCount}">
        `;
        fieldP.appendChild(fieldDiv);
        dynamicFieldsDiv.appendChild(fieldP);
        dynamicFieldsCount++;
}

function removeFields() {
    if(dynamicFieldsCount>2){
        const dynamicFieldsDiv = document.getElementById('dynamicFields');
            const lastField = dynamicFieldsDiv.lastChild;
            if (lastField) {
                dynamicFieldsDiv.removeChild(lastField);
                dynamicFieldsCount--;
            }
    }
}
// Récupérer la chaîne de requête de l'URL

// Fonction pour extraire la valeur d'un paramètre de la chaîne de requête
const getParameterByName = (name, url) => {
    if (!url) url = window.location.href;
    name = name.replace(/[[\]]/g, "\\$&");
    const regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
};
async function submitForm() {
    const proformatmere={ 
        id_proformatmere:"0",
        dateproformat: document.getElementById('dateproformat').value,
        nomproformat: document.getElementById('nomproformat').value,
        id_fournisseur: document.getElementById('Id_fournisseur').value
    }
    const proformats=[]

    for (let i = 1; i < dynamicFieldsCount; i++) {
        const proformat={ 
            id_proformat:"0",
            id_proformatmere:"0",
            quantite:document.getElementById(`quantite${i}`).value,
            prixunitaire:document.getElementById(`prixunitaire${i}`).value,
            tva :document.getElementById(`tva${i}`).value,
            id_article:document.getElementById(`Id_article${i}`).value
        }

        proformats.push(proformat);
    }
    // Envoyer les données au contrôleur Spring Boot (vous devrez implémenter la logique côté serveur)
    console.log(proformatmere);
    console.log(proformats);
    const data = { 
        proformatsbody:{
            proformatmerebody: proformatmere,
            proformatbodies: proformats
        }
    };
    // Envoyer les données au contrôleur Spring Boot via une requête fetch
    console.log( JSON.stringify({proformatmerebody: proformatmere,proformatbodies: proformats}));
    await fetch('/saveproformats', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({proformatmerebody: proformatmere,proformatbodies: proformats})
    })
    .then(response => response)
    .then(data => {
        // Gérer la réponse du serveur si nécessaire
        console.log('Success:', data);
        const erreurValue = getParameterByName('erreur', data.url);
        const p_erreur = document.getElementById('erreur'); 
        if (erreurValue) {
            console.log('Erreur:', erreurValue);
            p_erreur.innerText=erreurValue;
        }else{
            p_erreur.innerText="";
        }
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}
