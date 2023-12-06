var article = document.querySelectorAll('.article-content')[0] ;
var article_quantity = document.querySelectorAll('.article-quantity')[0] ;
var submit = document.querySelector('.inputsubmit') ;
var form = document.querySelector('form')
var ajouter_span = document.querySelector('.ajouter') ;
var remove_span = document.querySelector('.remove') ;
var button_span = document.querySelector('.add-remove')
var input = document.createElement('input')
function countArticle(numbers){
    input.type = "hidden" ;
    input.name = "countArticle" ;
    input.value = numbers ;
    return input ;
}
function transformName(){
    const all_content = document.querySelectorAll('.article-content') ;
    const all_content_quantity = document.querySelectorAll('.article-quantity') ;
    for (let index = 0; index < all_content.length; index++) {
        const select = all_content[index].querySelector('select')
        select.name = "article"+ index ;
        const input = all_content_quantity[index].querySelector('input[type="text"]')
        input.name = "quantite"+ index ;
    }
}
ajouter_span.addEventListener('click', () =>{
    const new_article = document.createElement('div')
    const new_div_article = document.createElement('div')
    const new_div_quantity = document.createElement('div')
    new_div_article.className = "article-content"
    new_div_quantity.className="article-quantity"
    new_div_article.innerHTML = article.innerHTML 
    new_div_quantity.innerHTML = article_quantity.innerHTML
    new_article.appendChild(new_div_article)
    new_article.appendChild(new_div_quantity)
    new_article.className="article"
    form.appendChild(new_article) ;
    form.appendChild(button_span)
    form.appendChild(submit)
    transformName() ;
})
const formulaire = document.getElementById('formulaire');
formulaire.addEventListener('submit' , (e)=>{
    formulaire.appendChild(countArticle(document.querySelectorAll('.article-content').length))
    e.preventDefault() ;
    const formadata = new FormData(formulaire);
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            alert(xhr.responseText)
        }
    }
    xhr.open('POST' , 'http://localhost:8080/livraisoncontroller/insertlivraison' , true) ;
    xhr.send(formadata)
})