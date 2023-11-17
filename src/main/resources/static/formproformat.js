let dynamicFieldsCount = 1;

function addFields() {
    const dynamicFieldsDiv = document.getElementById('dynamicFields');  
        const fieldDiv = document.createElement('div');
        fieldDiv.innerHTML = `
            <label for="quantite${dynamicFieldsCount}">Quantité:</label>
            <input type="text" id="quantite${dynamicFieldsCount}" name="quantite${dynamicFieldsCount}">
            
            <label for="prixunitaire${dynamicFieldsCount}">Prix Unitaire:</label>
            <input type="text" id="prixunitaire${dynamicFieldsCount}" name="prixunitaire${dynamicFieldsCount}">
            
            <label for="tva${dynamicFieldsCount}">TVA:</label>
            <input type="text" id="tva${dynamicFieldsCount}" name="tva${dynamicFieldsCount}">
            
            <label for="Id_article${dynamicFieldsCount}">ID Article:</label>
            <input type="text" id="Id_article${dynamicFieldsCount}" name="Id_article${dynamicFieldsCount}">
        `;
        dynamicFieldsDiv.appendChild(fieldDiv);
        dynamicFieldsCount++;
}

function removeFields() {
    const dynamicFieldsDiv = document.getElementById('dynamicFields');
        const lastField = dynamicFieldsDiv.lastChild;
        if (lastField) {
            dynamicFieldsDiv.removeChild(lastField);
            dynamicFieldsCount--;
        }
}

function submitForm() {
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
    fetch('/saveproformats', {
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
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}
