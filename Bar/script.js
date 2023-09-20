
//This function will fetch the api and return the data into the table filtered by name of the cocktail
function getDrinkByName() {
    const arr = new Array();
    nom = document.getElementById("se").value;

    fetch(`http://localhost:8080/drinks/${nom}`)

        .then((response) => response.json())
        .then((drinks) => {


            let table = document.getElementById("tBody");
            tBody.innerHTML = "";

            for (let drink of drinks.drinks) {
                arr.push(JSON.stringify(drink))

                table.innerHTML += `
            <tr>
            <td>${drink.idDrink}</td>
            <td>${drink.strDrink}</td>
            <td>${drink.strCategory}</td>
            <td>
                <ol>
                    <li>${drink.strIngredient1}</li>
                    <li>${drink.strIngredient2}</li>
                    <li>${drink.strIngredient3}</li>
                    <li>${drink.strIngredient4}</li>
                    <li>${drink.strIngredient5}</li>
                    <li>${drink.strIngredient6}</li>

                </ol>
            </td>
            <td>
            <ol>
                <li>${drink.strMeasure1}</li>
                <li>${drink.strMeasure2}</li>
                <li>${drink.strMeasure3}</li>
                <li>${drink.strMeasure4}</li>
                <li>${drink.strMeasure5}</li>
                <li>${drink.strMeasure6}</li>

            </ol>
            </td>
            <td>${drink.strInstructions}</td>
            <td><img src="${drink.strDrinkThumb}" class="rounded-circle" style="width: 100px"></td>
          </tr> `
            }
        })
        .catch((error) => {
            console.error("Error: ", error);
            alerta(error);
        })
        console.log(arr);
    return arr;

}

//This function returns all the data filtered by ingredient and posts it into the table 

function getDrinkByIngredient() {

    nom = document.getElementById("se").value;

    fetch(`http://localhost:8080/ingredients/${nom}`)
        .then((response) => response.json())
        .then((ingredients) => {
            console.log(ingredients);

            let table = document.getElementById("tBody");
            tBody.innerHTML = "";


            for (let ingredient of ingredients.drinks) {
                table.innerHTML += `
            <tr>
            <td id="ing">${ingredient.idDrink}</td>
            <td id="dri">${ingredient.strDrink}</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><img src="${ingredient.strDrinkThumb}" class="rounded-circle" style="width: 100px"></td>
          </tr> `


            }
        })
        .catch((error) => {
            console.error("Error: ", error);
            alerta(error);
        })
}



function saveFav() {

    console.log("se guardó")
    //const v = getDrinkByName()
    //console.log(JSON.stringify(v));
    //localStorage.setItem(document.getElementById("se").value, v);


}

function showFav() {
   // console.log(JSON.parse(localStorage.getItem('prueba')));
   console.log("se muestra")

}

