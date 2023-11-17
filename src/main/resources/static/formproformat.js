let dynamicFieldsCount = 0;

function addFields() {
    const dynamicFieldsDiv = document.getElementById('dynamicFields');

    for (let i = 0; i < 4; i++) {
        dynamicFieldsCount++;
        
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
    }
}

function removeFields() {
    const dynamicFieldsDiv = document.getElementById('dynamicFields');
    
    for (let i = 0; i < 4; i++) {
        const lastField = dynamicFieldsDiv.lastChild;
        if (lastField) {
            dynamicFieldsDiv.removeChild(lastField);
            dynamicFieldsCount--;
        }
    }
}

function submitForm() {
    const formData = {
        dateproformat: document.getElementById('dateproformat').value,
        nomproformat: document.getElementById('nomproformat').value,
        Id_fournisseur: document.getElementById('Id_fournisseur').value,
        dynamicFields: []
    };

    for (let i = 1; i <= dynamicFieldsCount; i++) {
        const fieldData = {
            quantite: document.getElementById(`quantite${i}`).value,
            prixunitaire: document.getElementById(`prixunitaire${i}`).value,
            tva: document.getElementById(`tva${i}`).value,
            Id_article: document.getElementById(`Id_article${i}`).value
        };

        formData.dynamicFields.push(fieldData);
    }

    // Envoyer les données au contrôleur Spring Boot (vous devrez implémenter la logique côté serveur)
    console.log(formData);
    // Utilisez AJAX ou fetch pour envoyer formData au contrôleur Spring Boot.
}
